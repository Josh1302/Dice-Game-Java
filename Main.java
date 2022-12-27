import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
public class Main {
    
    private static String gamedata = File.separator+"Users"+File.separator+"joshu"+File.separator+"OneDrive"+File.separator +"Cs 163" +File.separator+"PracticalOptionKnightFight-main"+File.separator +"gamedata.csv";
    private static String saveData = File.separator+"Users"+File.separator+"joshu"+File.separator+"OneDrive"+File.separator+"Cs 163"+File.separator+"PracticalOptionKnightFight-main"+File.separator+"knights.csv";
    public static void main(String[] args) throws IOException{
        processArgs(args); // method that parses the args, optional but cleaned up the code
     GameData data = new CSVGameData(gamedata, saveData);
     GameView view  = (GameView) new ConsoleView();
     CombatEngine engine = new CombatEngine(data, view);
     GameController controller = new GameController(data, view, engine);
     controller.start();
    }
    private static void processArgs(String[] args){
        for(String ag : args){
            if(ag.startsWith("--data")){
                gamedata = ag.substring(ag.indexOf("=")+1, ag.length());
            }
            else{
                saveData = ag;
            }
        }
    }
}
