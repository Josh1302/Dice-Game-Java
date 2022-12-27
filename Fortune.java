public class Fortune extends Object implements Attributes {
    private final int armor;
    private final int hpBonus;
    private final int hitModifier;
    private final String name;
    private final DiceType dtype;

    public Fortune(String name, int hpBonus, int armor,int hitModifier) {
        this(name, hpBonus, armor, hitModifier,null);
    }

    public Fortune(String name, int hpBonus, int armor, int hitModifier, DiceType type) {
        this.armor = armor;
        this.name = name;
        this.hpBonus = hpBonus;
        this.hitModifier = hitModifier;
        dtype = type;

    }
    @Override
    public int getArmor() {
        return armor;
    }

    @Override
    public int getMaxHP() {
        // TODO Auto-generated method stub
        return hpBonus;
    }

    @Override
    public DiceType getDamageDie() {
        // TODO Auto-generated method stub
        return dtype;
    }

    @Override
    public int getHitModifier() {
        // TODO Auto-generated method stub
        return hitModifier;
    }
    public String getName(){
        return name;
    }
    public String toString(){
        String s = "+======================+\n";
        s+=String.format("|%-22s|\n",getName());
        s+=String.format("|HP Bonus:          +%s|\n",getMaxHP());
        s+=String.format("|AC Bonus:           +%s|\n",getArmor());
        s+=String.format("|Hit Bonus:          +%s|\n",getHitModifier());
        if(getDamageDie()==null){
            s += String.format("|Damage Adj:%11s|\n", "-");
        }
        else {
            s += String.format("|Damage Adj:%11s|\n", getDamageDie());
        }
        s+="+======================+\n";
        return s;
    }
    public static void main(String[] args) {
        Fortune ftn = new Fortune("Merlin Luck", 10, 5, 2, DiceType.D12);
        System.out.println("TESTING Armor in fortune " + ftn.getArmor());
        System.out.println(ftn);
    }
    
}
