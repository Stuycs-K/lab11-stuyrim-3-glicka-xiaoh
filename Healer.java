public class Healer extends Adventurer{
  int mana, manaMax;

  /*the other constructors ultimately call the constructor
  *with all parameters.*/
  public Warrior(String name, int hp, String class){
    super(name,hp);
    manaMax = 12;
    mana = manaMax/2;
  }

  public Warrior(String name, int hp){
    this(name,hp,);
  }

  public Warrior(String name){
    this(name,24);
  }

  public Warrior(){
    this("Adam Warlock");
  }

  /*The next 8 methods are all required because they are abstract:*/
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
    if(enemy){
      int damage = (int)(Math.random()*6)+2;
      other.applyDamage(damage);
      restoreSpecial(2);
      return this + " tickled "+ other + " and dealt "+ damage +
      " points of damage.";
    }
    else {
      int restore = (int)(Math.random()*6)+2;
      setHP(getHP() + restore);
      return getName() + " casts 'Dia' to heal" + " other for " + restore " health!";
    }
  }

  public String specialAttack{
    if(getSpecial() >= 8){
      setSpecial(getSpecial()-8);
      int restore = (int)(Math.random()*5+Math.random()*5)+3;
      for(int i = 0; i < 3; i++){
          setHP(getHP(Team[i]) + restore);
      }
      return getName() + " summons Mediarahan to heal" + " the whole team for " + restore " health!";
    }else{
      return "Not enough mana to use their ultimate. Instead "+ support();
    }

  }

  public String support(){
    int manares = random(50);
    for(int i =0; i < 3; i++){
      Ally[i].setSpecial(getSpecial() + manares);
    }
    return this+" uses 'Salvation' to "+restoreSpecial(50)+" and 10 "
    + getSpecialName() + " to all teamates";
  }
}
