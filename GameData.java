import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public  abstract class GameData extends Object{
protected final List<Knight> activeKnights = new ArrayList<Knight>();
protected final List<Fortune> fortunes= new ArrayList<Fortune>();
protected final List<Knight> knights= new ArrayList<Knight>();
private static final int MAX_ACTIVE = 4;
protected final List<MOB> monsters= new ArrayList<MOB>();
private static final Random random = new Random();
public GameData(){
}
public List<Knight> getKnights(){
    return knights;
}
public List<MOB> getMonsters(){
   return monsters;
}
public List<Fortune> getFortunes(){
   return fortunes;
}
public List<Knight> getActiveKnights(){
    return activeKnights;
}
 public boolean setActive(Knight kt){
    if(getActiveKnights().size()<MAX_ACTIVE){
        activeKnights.add(kt);
        return true;
    }
    else{
      System.out.println("Unable to set active knight. Only four can be active at a time.");
    }
    return false;
 }
 public void removeActive(Knight kt){
    activeKnights.remove(kt);
    kt.resetDamage();
 }
 public Knight getActive(String nameOrId){ 
    return  findKnight(nameOrId,getActiveKnights());
 }
 public Knight getKnight(String nameOrId){
    return findKnight(nameOrId, getKnights());
 }
protected Knight findKnight(String nameOrId,
 List<Knight> list){
   nameOrId.toLowerCase();
   Knight kt = null;
for(int i = 0;i<list.size();i++){
   kt = list.get(i);
   String id = kt.getID().toString();
if(kt.getName().toLowerCase().contains(nameOrId)||id.equals(nameOrId)){
   return kt;
}
else{
   kt = null;
}
}
return kt;
}
 public Fortune getRandomFortune(){
    return fortunes.get(random.nextInt(fortunes.size()));
 }
 public List<MOB> getRandomMonsters(){
    if(activeKnights.size()<MAX_ACTIVE){
        int rand = random.nextInt(monsters.size());
        MOB random = monsters.get(rand);
        monsters.add(random);
    }
    return monsters;
 }
 public List<MOB> getRandomMonsters(int number) throws CloneNotSupportedException{
    for(int i = 0;i<=number;i++){
        int rand = random.nextInt(monsters.size());
        MOB random = monsters.get(rand);
        random.copy();
        monsters.add(random);
    }
    return monsters;
 }
 public abstract void save(String filename);
 }