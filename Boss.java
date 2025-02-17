public class Boss extends Adventurer{
  int mana, manaMax;

  /*the other constructors ultimately call the constructor
  *with all parameters.*/
  public Boss(String name, int hp){
    super(name,hp);
    manaMax = 200;
    mana = 150;
  }
  public Boss(String name){
    this(name,100);
  }

  public Boss(){
    this("Iron Fist");
  }

  public String getSpecialName(){
    return "mana";
  }

  public int getSpecial(){
    return mana;
  }

  public void setSpecial(int n){
    mana = Math.min(n, manaMax);
  }

  public int getSpecialMax(){
    return manaMax;
  }

  public String attack(Adventurer other){
    int damage = (int) (Math.random() * 21) + 30; //lets do random from 30-50
    other.applyDamage(damage);
    restoreSpecial(5);
    return this + " used Jeet Kune Do on "+ other + " and dealt "+ damage +
    " points of damage. They then meditated to restore 5 mana";
  }

  public String specialAttack(Adventurer other){
    if(getSpecial() >= 20){
      setSpecial(getSpecial()-20);
      int basedamage = (int)(Math.random() * 21) + 30;
      int bonus = (int)(0.1 * other.getHP());
      int damage = basedamage + bonus;
      other.applyDamage(damage);
      return this + " used K'un-L kick to damage"+other+" dealing "+ damage +" points of damage.";
    }else{
      return "Not enough mana to use their special. Instead "+attack(other);
    }
  }
public String support(Adventurer other){
  return "this is temp";
}
  public String support(){
    int hp = 30;
    setHP(getHP()+hp);
    return this.getName()+" meditated with harmony recovery to restores "+restoreSpecial(30)+" "
    + getSpecialName()+ " and "+hp+" HP";
  }
}
