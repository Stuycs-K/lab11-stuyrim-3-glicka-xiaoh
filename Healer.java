public class Healer extends Adventurer{
  int mana, manaMax;

  public Healer(String name, int hp, String class){
    super(name,hp,false);
    manaMax = 100;
    mana = 25;
  }

  public Healer(String name){
    this(name,50);
  }

  public Healer(){
    this("Adam Warlock");
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
    if(isEnemy()){
      int damage = 5;
      other.applyDamage(damage);
      restoreSpecial(10);
      return this.getName() + " tickled "+ other + " and dealt "+ damage +
      " points of damage.";
    }
    else {
      int restore = (int)(Math.random()*19)+10;
      other.setHP(getHP() + restore);
      return this.getName() + " casts 'Dia' to heal" + other.getName() + " for " + restore + " health!";
    }
  }

public String specialAttack(ArrayList<Adventurer> team) {
        if (getSpecial() >= 60) {
            setSpecial(getSpecial() - 60);
            int restore = 30;
            for (Adventurer member : team) {
                member.setHP(member.getHP() + restore);
            }
            return this.getName() + " summons Mediarahan to heal the whole team for " + restore + " health!";
        } else {
            return "Not enough mana to use their ultimate. They started started panicking";
        }
    }

  public String support(){
    int manaRes = 20;
    int heal = 15;
    restoreSpecial(manaRes);
    setHP(getHP() + heal);
    return this.getName() + " uses 'Salvation' to restore " + manaRes + " mana and heals themselves for " + heal + " HP.";
  }
}
