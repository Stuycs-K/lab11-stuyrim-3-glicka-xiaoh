public class Warrior extends Adventurer{
  int mana, manaMax;

  /*the other constructors ultimately call the constructor
  *with all parameters.*/
  public Warrior(String name, int hp){
    super(name,hp);
    manaMax = 200;
    mana = 200;
  }

  public Warrior(String name, int hp){
    this(name,hp);
  }

  public Warrior(String name){
    this(name,100);
  }

  public Warrior(){
    this("Iron Fist");
  }

  public String getSpecialName(){
    return "mana";
  }

  public int getSpecial(){
    return mana;
  }

  public void setSpecial(int n){
    mana = n;
  }

  public int getSpecialMax(){
    return manaMax;
  }

  public String attack(Adventurer other){
    int damage = 40; //lets do random from 30-50
    other.applyDamage(damage);
    restoreSpecial(5);
    return this + " used Jeet Kune Do on "+ other + " and dealt "+ damage +
    " points of damage. They then meditated for .";
  }

  public String specialAttack(Adventurer other){
    if(getSpecial() >= 20){
      setSpecial(getSpecial()-20);
      int damage = 35; //change this to random from 30-50
      other.applyDamage(damage);
      return this + " used K'un-L "
      " skills to damage"+other+" dealing "+ damage +" points of damage.";
    }else{
      return "Not enough mana to use their ultimate. Instead "+attack(other);
    }

  }

//random 1 or 2, if 1 use harmony recovery, if 2 use dragons defense
  public String support(){
    int hp = 30;
    setHP(getHP()+hp);
    return this+" meditated with harmony recovery to restores "+restoreSpecial(30)+" "
    + getSpecialName()+ " and "+hp+" HP";
  }
}
