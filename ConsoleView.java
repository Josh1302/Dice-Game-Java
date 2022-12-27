import java.util.List;
import java.util.Scanner;

public class ConsoleView extends Object implements GameView {
    private final Scanner in = new Scanner(System.in);
    public ConsoleView(){
}
public void splashScreen(){
    System.out.println("Round Table Games: Knights of Legend\nloading...");
    System.out.println("What would you like to do?");
}
public void endGame(){
    System.out.println("Thank you for playing!");
}
public String displayMainMenu(){
    String s = in.nextLine();
    return s;
}
public void printHelp(){
    System.out.println("Unsure what to do, here are some options:");
    System.out.println("    ls or list all  - listing the knights");
    System.out.println("    list active  - list the active knights knights only");
    System.out.println("    show name or id - show the knight details card");
    System.out.println("    set active name or id - set knight as active (note: only 4 knights can be active)");
    System.out.println("    remove active name or id - remove a knight from active status (heals knight)");
    System.out.println("    explore or adventure or quest - find random monsters to fight");
    System.out.println("    save filename - save the game to the file name (default: saveData.csv)");
    System.out.println("    exit or goodbye - to leave the game");
    System.out.println("Game rules: You can have four active knights. As long as they are active, they won't heal,\nbut they can gain XP by going on adventures.");
    System.out.println("When you make a knight inactive, they will heal. How many monsters can you defeat\nbefore, you have to heal?");
}
public void knightNotFound(){
    System.out.println("Knight not found!");
}
public void listKnights(List<Knight> knights){
    if(knights!=null){
    for(int i = 0; i<knights.size();i++){
    System.out.println(knights.get(i).getID()+": "+knights.get(i).getName());
    }
}
else{
    System.out.println("No knights to list");
}
}
public void showKnight(Knight knight){
  System.out.print(knight.toString()) ;
}
public void setActiveFailed(){
    System.out.println("Unable to set active knight. Only four can be active at a time.");
    System.out.println();
}
public void printBattleText(MOB dead){
    System.out.println(dead.getName()+" was defeated!");
}
public void printBattleText(List<MOB> monsters,
 List<Knight> activeKnights){
    System.out.println("Our heroes come across the following monsters. Prepare for battle!");
    System.out.printf("Knights%27s\n","Foes");
    if(monsters.size() == 1){
        String s = monsters.get(0).getName();
        System.out.printf("%-27s%s\n",activeKnights.get(0).getName(),s);
        System.out.printf("%-27s\n",activeKnights.get(1));
        System.out.printf("%-27s\n",activeKnights.get(2));
    }   
    else if(monsters.size() == 2){
        String s = monsters.get(0).getName();
        String b = monsters.get(1).getName();
        System.out.printf("%-27s%s\n",activeKnights.get(0).getName(),s);
        System.out.printf("%-27s%s\n",activeKnights.get(1).getName(),b);
        System.out.printf("%-27s\n",activeKnights.get(2));
    }
    else if(monsters.size() == 3){
        String s = monsters.get(0).getName();
        String b = monsters.get(1).getName();
        String c = monsters.get(2).getName();
    System.out.printf("%-27s%s\n",activeKnights.get(0).getName(),s);
    System.out.printf("%-27s%s\n",activeKnights.get(1).getName(),b);
    System.out.printf("%-27s%s\n",activeKnights.get(2),c);}
}
public void printFortunes(List<Knight> activeKnights){
    System.out.println("For this quest, our knights drew the following fortunes!");
    for(int i = 0;i<activeKnights.size();i++){
    Knight k = activeKnights.get(i);
    if(k.getActiveFortune()!=null){
            System.out.println(k.getName()+" drew");
            System.out.println(k.getActiveFortune().toString());
    
    }
}
}
    public boolean checkContinue(){
        System.out.print("Would you like to continue on your quest (y/n)?");
        String s = in.nextLine();
        s.toLowerCase();
        if(s.equals("y")||s.equals("yes")){
            return true;
        }
        return false;
    }
    public void printDefeated(){
        System.out.println("All active knights have been defeated!");
    } 

}
