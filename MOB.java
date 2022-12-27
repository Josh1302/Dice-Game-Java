public class MOB implements Attributes {
    protected int armor;
    protected int damage;
    protected DiceType damageDie;
    protected int hitModifier;
    protected int maxHP;
    private final String name;


    public MOB(String name, int maxHP, int armor, int hitModifier, DiceType damageDie){
        this.armor = armor;
        this.name = name;
        this.maxHP = maxHP;
        this.hitModifier = hitModifier;
        this.damageDie= damageDie;
    }

    @Override
    public int getArmor() {
        // TODO Auto-generated method stub
        return armor;
    }

    @Override
    public int getMaxHP() {
        // TODO Auto-generated method stub
        return maxHP;
    }

    @Override
    public DiceType getDamageDie() {
        // TODO Auto-generated method stub
        return damageDie;
    }

    @Override
    public int getHitModifier() {
        // TODO Auto-generated method stub
        return hitModifier;
    }
    public String getName(){
        return name;
    }
    public int getDamage(){
        return damage;
    }
    public void addDamage(int damage){
        this.damage = damage+getDamage();

    }
    public int getHP(){
        return maxHP-damage;
    }
    public void resetDamage(){
        damage = 0;
    }
    public String toString(){
        return "+============================+\n" +
                String.format("| %-27s|%n", getName()) +
                "|                            |\n" +
                String.format("|         Health: %-10d |%n", getMaxHP())  +
                String.format("|  Power: %-6s  Armor: %-4d|%n", getDamageDie().toString(), getArmor()) +
                "|                            |\n" +
                "+============================+";
    }
    public MOB copy()throws CloneNotSupportedException{
        return (MOB) super.clone();
    }
    
    public static void main(String[] args) {
        MOB ftn = new MOB("Merlin Luck", 10, 5, 2, DiceType.D12);
        System.out.println("TESTING Armor in MOB " + ftn.getArmor());
        System.out.println(ftn);
        ftn.addDamage(5);
    }
}
