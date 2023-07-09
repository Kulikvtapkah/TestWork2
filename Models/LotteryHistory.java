package TestWork2.Models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import TestWork2.Config;

public class LotteryHistory {
    

     public static void saveHistory(String info) {
          try {
            File file = new File(Config.historyPath);
            FileReader fr = new FileReader(file);

            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            String lines = "";

            while (line != null) {
                lines += line + "\n";
                line = reader.readLine();
            }
            reader.close();
            fr.close();
            FileWriter writer = new FileWriter(Config.historyPath, false);
            writer.append(lines);
            writer.append(String.format("Разыгран:\n %s\n", info));
            
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    
}
