package TestWork2.Models;

import java.io.FileWriter;
import java.io.IOException;

import TestWork2.Config;

public class LotteryHistory {

     public static void saveHistory(String info) {

        try (FileWriter writer = new FileWriter(Config.historyPath, false)) {
            writer.append(String.format("Разыгран:\n %s\n", info));
            

            writer.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
