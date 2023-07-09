package TestWork2.View;

import java.util.ArrayList;
import java.util.Arrays;

public class ConsoleMenu implements Menu {

    public ArrayList<String> mainMenu;
    public ArrayList<String> editLotteryMenu;

    public ConsoleMenu() {

        this.mainMenu = new ArrayList<String>(Arrays.asList("Провести розыгрыш", "Добавить лот", "Изменить количество",
                "Изменить вес лота", "Информация о розыгрыше"));
    }

}
