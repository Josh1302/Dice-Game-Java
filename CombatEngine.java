import java.util.Random;

public class CombatEngine {
private final GameData data;
private final Random rnd = new Random();
private final GameView view;
public CombatEngine(GameData data,
 GameView view){
    this.data = data;
    this.view = view;
 }
 public void initialize(){
for(int i = 0;i<data.getActiveKnights().size();i++){
   Knight k = data.getActiveKnights().get(i);
    k.setActiveFortune(data.getRandomFortune());
    }
    view.printFortunes(data.getActiveKnights());
 }
 public void runCombat(){
    System.out.println("Not implemented");
 }
 public void clear(){
    for(int i = 0;i<data.getActiveKnights().size();i++){
        Knight k = data.getActiveKnights().get(i);
    k.setActiveFortune(null);

    }
 }
}
