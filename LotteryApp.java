package TestWork2;


import java.util.Arrays;

import TestWork2.Models.AbstractLot;
import TestWork2.Models.Lottery;
import TestWork2.Models.LotterySet;
import TestWork2.Models.ToyLot;
import TestWork2.Presenter.ILotteryManager;
import TestWork2.Presenter.LotteryManager;
import TestWork2.Presenter.LotteryRunner;
import TestWork2.View.ConsoleMenu;
import TestWork2.View.ConsoleView;

import TestWork2.View.View;

public class LotteryApp {
    public static void main(String[] args) {
        runApp();

    }

    public static void runApp() {
        System.out.print("\033[H\033[J");
        View view = new ConsoleView();
        ConsoleMenu menu = new ConsoleMenu();
        
        AbstractLot teddyBear = new ToyLot("Teddy bear", 100, 1);
        AbstractLot legoStarWarsSet = new ToyLot("Star Wars (Lego Set)", 40, 1);
        AbstractLot huggyWuggy = new ToyLot("Huggy Wuggy blue", 80, 1);
        AbstractLot erenYeagerActionToy = new ToyLot("Eren Yeager Action Figure", 3, 1);

        LotterySet toyLottery = new LotterySet(Arrays.asList(teddyBear, legoStarWarsSet, huggyWuggy, erenYeagerActionToy));
        View lotteryView = new ConsoleView();
        ILotteryManager lotteryManager = new LotteryManager(toyLottery, lotteryView);
        LotteryRunner lottery = new LotteryRunner(new Lottery(toyLottery), lotteryView);
        
        // Presenter presenter = new Presenter(view, Config.pathDb);
        // presenter.LoadFromFile();

        view.userInfo("Добро пожаловать в \"Лотерею\"! \n");
        while (true)
            switch (view.getOption(menu.mainMenu)) {
                case "1":
                    lottery.lotteryRun();
                    break;
                case "2":
                    lotteryManager.addNewLot();
                    break;
                case "3":
                    lotteryManager.editLotAmount();
                    break;
                case "4":
                    lotteryManager.editLotChanceToPick();
                    break;
                case "5":
                    lotteryManager.lotterySetInfo();

                    break;

                default:
                    System.out.println("Такой команды нет");
                    break;
            }

    }
}
