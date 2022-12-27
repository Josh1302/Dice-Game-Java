import java.io.IOException;

public class GameController extends Object{
    private final GameData data;
    private final CombatEngine engine;
    private final GameView view;

public GameController(GameData data,
 GameView view,
 CombatEngine engine){
    this.data = data;
    this.view = view;
    this.engine = engine;
 }
 public void start() throws IOException{
    view.splashScreen();
    while(processCommand(view.displayMainMenu()) == true){
      //processCommand(view.displayMainMenu());
      }
    
      view.endGame();
 }
 protected boolean processCommand(String command) throws IOException {
  command = command.toLowerCase();
   if(command.contains("exit")||command.contains("bye")){
      return false;
   }
    if(command.contains("ls")||command.contains("list all")){
      view.listKnights((data.getKnights()));
      System.out.println("\nWhat would you like to do?");
      return true;
    }
    if(command.contains("list active")){
      view.listKnights(data.getActiveKnights());
      System.out.println("\nWhat would you like to do?");
      return true;
    }
    if(command.contains("show")){
      String s = command;
      String ks = s.substring(s.indexOf(" ")+1, s.length()).trim();
      Knight k = data.getKnight(ks);
      if(k != null){
        view.showKnight(k);
      }
      else{
      view.knightNotFound();
      }
      System.out.println("\nWhat would you like to do?");
      return true;
    }
    else if(command.contains("set active")){
      String s = command;
      String ks = s.substring(s.indexOf("v")+3, s.length()).trim();
      Knight k = data.findKnight(ks, data.getKnights());
      if(k!=null){
      data.setActive(k);
      }
      else{
        view.knightNotFound();
      }
      System.out.println("What would you like to do?");
      return true;
    }
    else if(command.contains("remove")){
      String s = command;
      String ks = s.substring(s.indexOf(" ")+1, s.length()).trim();
      Knight k = data.getActive(ks);
      if(k!=null){
      data.removeActive(k);
      }
      else{
        view.knightNotFound();
      }
      System.out.println("What would you like to do?");
      return true;
    }
    else if(command.equals("save")){
      data.save("saveData.csv");
      System.out.println("What would you like to do?");
      return true;
    }
    else if(command.contains("save")){
      String s = command;
      s = s.substring(s.indexOf(" ")+1, command.length()).trim();
      data.save(s);
      System.out.println("What would you like to do?");
      return true;
    }
    else if(command.contains("explore")||command.contains("adventure")||command.contains("quest")){
      engine.initialize();
         engine.runCombat();
         engine.clear();
         System.out.println("\nWhat would you like to do?");
         return true;
    }
    else{
      view.printHelp();
      System.out.println("\nWhat would you like to do?");
      return true;
    }
  }
  
 
}
