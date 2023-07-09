package TestWork2.View;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView implements View {

    Scanner userAssistent;

    public ConsoleView() {
        userAssistent = new Scanner(System.in, "CP866");

    }

    @Override
    public void userInfo(String message) {
        System.out.print(message);
    }

    @Override
    public void showOptions(ArrayList<String> optiontable) {
        userInfo("\nВыберите действие:\n");
        for (int index = 0; index < optiontable.size(); index++) {
            userInfo(String.format("%s - %s\n", index + 1, optiontable.get(index)));
        }

    }

    @Override
    public String getOption(ArrayList<String> optiontable) {

        showOptions(optiontable);
        userInfo(">> ");
        String key = userAssistent.next();
        System.out.print("\033[H\033[J");
        return key;
    }

 @Override
    public String getStringData(String message) {
        userInfo(message);
        return userAssistent.nextLine();
    }


    @Override
    public int getNumber(String message) throws InputMismatchException {
        userInfo(message);
        int index = -1;
        try {
            index = userAssistent.nextInt();
            userAssistent.nextLine();
        } catch (Exception e) {
           userInfo("");
        }
        return index;
    }
}
