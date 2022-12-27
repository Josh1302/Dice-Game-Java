public class Knight extends MOB {
private Fortune activeFortune;
protected final int id;
protected int xp;

public Knight(int id, String name, int hp, int armor, int hitModifier, DiceType damageDie, int xp){
    super(name, hp, armor, hitModifier,damageDie);
        this.id = id;
    this.xp=xp;

}
public Fortune getActiveFortune(){
    return activeFortune;
}
public void setActiveFortune(Fortune activeFortune){
    this.activeFortune = activeFortune;
}
public int getArmor(){
    if(getActiveFortune()!=null){
        armor = activeFortune.getArmor()+super.getArmor();
    }
    else{
        armor=super.getArmor();
    }
    return armor;
}
public int getMaxHP(){
    if(getActiveFortune()!=null){
        maxHP = activeFortune.getMaxHP()+super.getMaxHP();
    }
    else{
        maxHP=super.getMaxHP();
    }
    return maxHP;
}
public DiceType getDamageDie(){
    if(getActiveFortune()!=null){
        damageDie = activeFortune.getDamageDie();
    }
    else{
        damageDie = super.getDamageDie();
    }
    return damageDie;
}
public int getHitModifier(){
    if(getActiveFortune()!=null){
        hitModifier = activeFortune.getHitModifier()+super.getHitModifier();
    }
    else{
        hitModifier = super.getHitModifier();
    }
    return hitModifier;
}
public int getXP(){
    return xp;
}
public Integer getID(){
    return id;
}
public void addXP(int xp){
    this.xp = xp + getXP();
}
public String toString(){
String s = "+============================+\n";
s+=String.format("|%-28s|\n",getName());
s+=String.format("|id:%-25d|\n",getID());
s+="|                            |\n";
s+=String.format("|Health: %-6dXP: %-10d|\n",getMaxHP(),getXP());
s+=String.format("| Power: %-6sArmor: %-7d|\n",getDamageDie(),getArmor());
    s+="|                            |\n";
    s += "+============================+\n";
    return s;
}
public String toCSV(){
    String CSV;
    CSV = String.format("%s,%d,%d,%d,%s,%d",getName(),getMaxHP(),getArmor(),getHitModifier(),getDamageDie(),getXP());
return CSV;
}

    public static void main(String[] args) {
        Knight ftn = new Knight(12,"Merlin Luck", 10, 5, 2, DiceType.D12,5);
        System.out.println("TESTING Armor in MOB " + ftn.getArmor());
        System.out.println(ftn);
        System.out.println(ftn.getXP());
    }
    
}
