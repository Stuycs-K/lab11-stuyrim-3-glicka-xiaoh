public class Warrior extends Adventurer{
  int energy, energyMax;
  String preferredClass;

  /*the other constructors ultimately call the constructor
  *with all parameters.*/
  public Warrior(String name, int hp, String class){
    super(name,hp);
    energyMax = 12;
    energy = energyMax/2;
    preferredClass = class;
  }

  public Warrior(String name, int hp){
    this(name,hp,"barbarian");
  }

  public Warrior(String name){
    this(name,24);
  }

  public Warrior(){
    this("Griffith");
  }

  /*The next 8 methods are all required because they are abstract:*/
  public String getSpecialName(){
    return "energy";
  }

  public int getSpecial(){
    return energy;
  }

  public void setSpecial(int n){
    energy = n;
  }

  public int getSpecialMax(){
    return energyMax;
  }

  /*Deal 2-7 damage to opponent, restores 2 energy*/
  public String attack(Adventurer other){
    int damage = (int)(Math.random()*6)+2;
    other.applyDamage(damage);
    restoreSpecial(2);
    return this + " attacked "+ other + " and dealt "+ damage +
    " points of damage. They then taunted.";
  }

  /*Deal 3-12 damage to opponent, only if energy is high enough.
  *Reduces energy by 8.
  */
  public String specialAttack(Adventurer other){
    if(getSpecial() >= 8){
      setSpecial(getSpecial()-8);
      int damage = (int)(Math.random()*5+Math.random()*5)+3;
      other.applyDamage(damage);
      return this + " used their "+preferredClass+
      " skills to damage"+other+" dealing "+ damage +" points of damage.";
    }else{
      return "Not enough energy to use their ultimate. Instead "+attack(other);
    }

  }
  /*Restores 5 special to other*/
  public String support(Adventurer other){
    return "Gives a warrior's shout to "+other+" and restores "
    + other.restoreSpecial(5)+" "+other.getSpecialName();
  }
  /*Restores 6 special and 1 hp to self.*/
  public String support(){
    int hp = 1;
    setHP(getHP()+hp);
    return this+" pounds his chest to restores "+restoreSpecial(6)+" "
    + getSpecialName()+ " and "+hp+" HP";
  }
}
