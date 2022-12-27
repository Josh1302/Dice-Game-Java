import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CSVGameData extends GameData {
    
    public CSVGameData(String gamedata,
 String saveData) {
    loadGameData(gamedata);
    loadSaveData(saveData);
 }

    private void loadGameData(String gamedata)  {
        File fi = new File(gamedata);
            try (Scanner file = new Scanner(fi)) {
                while(file.hasNextLine()) {
                    String s = file.nextLine();
                    if(s.startsWith("MOB")){
                    String line [] = s.split(",");
                    MOB kt = new MOB(
                            line[1],
                            Integer.parseInt(line[2]),
                            Integer.parseInt(line[3]),
                            Integer.parseInt(line[4]),
                            DiceType.valueOf(line[5]));
                    monsters.add(kt);
                    }
                     if(s.startsWith("FORTUNE")){

                        String line[] = s.split(",");
                        if(!line[5].equals("-")){
                        Fortune k = new Fortune(line[1],
                        Integer.parseInt(line[2]),
                        Integer.parseInt(line[3]),
                        Integer.parseInt(line[4]),
                        DiceType.valueOf(line[5]));
                        fortunes.add(k);
                        }
                        else{
                            Fortune k = new Fortune(line[1],
                            Integer.parseInt(line[2]),
                            Integer.parseInt(line[3]),
                            Integer.parseInt(line[4]));
                            fortunes.add(k);
                        }
}
            }
}
catch(FileNotFoundException e){
e.printStackTrace();
}
catch(IndexOutOfBoundsException s){
    s.printStackTrace();
   }
   catch(Exception c){
    c.printStackTrace();
   }    
    }
    private void loadSaveData(String saveData)  {
        int counter = 0;
        File fi = new File(saveData);
                try (Scanner file = new Scanner(fi)) {
                    while(file.hasNextLine()) {
                        Scanner line = new Scanner(file.nextLine());
                        line.useDelimiter(","); 
                        Knight kt = new Knight(
                                ++counter,
                                line.next().trim(),
                                line.nextInt(),
                                line.nextInt(),
                                line.nextInt(),
                                DiceType.valueOf(line.next()),
                                line.nextInt());
                        knights.add(kt);
                    }
                }
   catch(FileNotFoundException e){
            e.printStackTrace();
   }
   catch(IndexOutOfBoundsException s){
    s.printStackTrace();
   }
   catch(Exception c){
    c.printStackTrace();
   }
   
        }
    
    @Override
    public void save(String filename) {
        // TODO Auto-generated method stub
        try{
            PrintWriter printwriter = new PrintWriter(filename);
        
        for(int i = 0;i<knights.size();i++){
            Knight k = knights.get(i);
          printwriter.println(k.toCSV());
}
printwriter.close();
        }
catch(FileNotFoundException e){
    e.printStackTrace();
}
    
}
}