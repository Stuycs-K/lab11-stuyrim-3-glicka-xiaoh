public class Warrior extends Adventurer{
  int mana, manaMax;
  String preferredClass;

  /*the other constructors ultimately call the constructor
  *with all parameters.*/
  public Warrior(String name, int hp, String preferredClass){
    super(name,hp);
    manaMax = 100;
    mana = 50;
    preferredClass = class;
  }

  public Warrior(String name, int hp){
    this(name,hp,"barbarian");
  }

  public Warrior(String name){
    this(name,100);
  }

  public Warrior(){
    this("Griffith");
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
    int damage = 20;
    other.applyDamage(damage);
    restoreSpecial(5);
    return this.getName() + " attacked "+ other + " and dealt "+ damage +
    " points of damage. They then taunted.";
  }

  public String specialAttack(Adventurer other){
    if(getSpecial() >= 20){
      setSpecial(getSpecial()-20);
      int damage = (int) (Math.random() * 21) + 30; //change this to random from 30-50
      other.applyDamage(damage);
      return this.getName() + " used their "+preferredClass+
      " skills to damage "+other+" dealing "+ damage +" points of damage.";
    }else{
      return "Not enough mana to summon Mediarahan. Instead "+attack(other);
    }

  }

  public String support(Adventurer other){
    return this.getName() + " gives a warrior's shout to "+other+" and restores "
    + other.restoreSpecial(20)+" "+other.getSpecialName();
  }

  public String support(){
    int hp = 10;
    setHP(getHP()+hp);
    return this.getName() +" pounds his chest to restores "+restoreSpecial(20)+" "
    + getSpecialName()+ " and "+hp+" HP";
  }
}
