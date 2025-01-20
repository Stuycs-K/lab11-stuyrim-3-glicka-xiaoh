import java.util.ArrayList;
public class Healer extends Adventurer{
  int mana, manaMax;

  public Healer(String name, int hp){
    super(name,hp);
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
      int damage = 5;
      other.applyDamage(damage);
      restoreSpecial(10);
      return this.getName() + " tickled "+ other + " and dealt "+ damage +
      " points of damage.";
  }
public String specialAttack(Adventurer other) {
  return "shouldn't be calling this";
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
  public String support(Adventurer other){
    return "Throws casts a Mana Waterfall on top "+other+" to restore "
    + other.restoreSpecial(50)+" "+other.getSpecialName();
  }
}
