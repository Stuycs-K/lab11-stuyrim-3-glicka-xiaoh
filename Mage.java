public class Mage extends Adventurer{
  int mana, manaMax;
  String preferredClass;

  /*the other constructors ultimately call the constructor
  *with all parameters.*/
  public Mage(String name, int hp){
    super(name,hp);
    manaMax = 100;
    mana = 35;
  }

  public Mage(String name){
    this(name,70);
  }

  public Mage(){
    this("Dr. Strange");
  }

  /*The next 8 methods are all required because they are abstract:*/
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


  public String attack(Adventurer other1, Adventurer other2){
    int damage = 15;
    other1.applyDamage(damage);
    other2.applyDamage(damage);
    restoreSpecial(5);
    return this.getName() + " used hailstorm on "+ other1.getName() + " and " + other2.getName() + ", dealt "+ damage +
    " points of damage to both of them. They then flipped through their scrolls.";
  }

  public String attack(Adventurer other){
    int damage = 25;
    other.applyDamage(damage);
    restoreSpecial(5);
    return this.getName() + " used hailstorm on "+ other.getName() + " and dealt "+ damage +
    " points of damage to them. They then flipped through their scrolls.";
  }



  public String specialAttack(Adventurer other){
    if(getSpecial() >= 20){
      setSpecial(getSpecial()-20);
      int damage = 60;
      other.applyDamage(damage);
      return this.getName() + " used fireball"+ other+" dealing "+ damage +" points of damage.";
    }else{
      return "Not enough mana to use their ultimate. Instead "+attack(other);
    }
  }

    public String specialAttack(Adventurer other1, Adventurer other2){
    if(getSpecial() >= 35){
      setSpecial(getSpecial()-35);
      int damage = 40;
      other1.applyDamage(damage);
      other2.applyDamage(damage);
      return this.getName() + " used Chain Lightning on " +other1.getName() + " and " + other2.getName() +", dealing " + damage +" points of damage on both of them.";
    }else{
      return "Not enough mana to use their ultimate. Instead "+attack(other1, other2);
    }
  }

    public String specialAttack(Adventurer other1, Adventurer other2, Adventurer other3){
    if(getSpecial() >= 50){
      setSpecial(getSpecial()-50);
      int damage = 20;
      other1.applyDamage(damage);
      other2.applyDamage(damage);
      other3.applyDamage(damage);
      return this.getName() + " used Meteor Shower on "+other1.getName() + ", " + other2.getName() + ", and " + other3.getName() + ", dealing "+ damage +" points of damage on all of them.";
    }else{
      return "Not enough mana to use their ultimate. Instead "+attack(other1);
    }
  }

  public String support(Adventurer other){
    return this.getName() + " throws a mana potion at "+other+" to restore "
    + other.restoreSpecial(30)+" "+other.getSpecialName();
  }

  public String support(){
    int manaRes = 30;
    restoreSpecial(manaRes);
    return this.getName() + " uses 'Salvation' to restore " + manaRes + " mana";
  }
}
