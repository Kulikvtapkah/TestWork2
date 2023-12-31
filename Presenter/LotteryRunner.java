package TestWork2.Presenter;

import TestWork2.Models.Lottery;
import TestWork2.Models.LotteryHistory;
import TestWork2.View.View;

public class LotteryRunner {
    protected Lottery lottery;
    protected View view;
    protected LotteryHistory history;

    public LotteryRunner(Lottery lottery, View view) {
        this.lottery = lottery;
        this.view = view;
    }

    public void lotteryRun() {
        boolean lotteryIsOn = true;
        while (lotteryIsOn) {
            if (!lottery.setIsEmpty()) {
                view.userInfo("Начинаем розыгрыш игрушек! ");
                if (view.getNumber(
                        "\nЧтобы участвовать, введите сумму вашей покупки в магазине, \nлибо любой другой знак, для отмены >> ") > 0) {

                    String prize = lottery.spin();
                    view.userInfo(String.format("%s", prize));

                    LotteryHistory.saveHistory(String.format("%s", prize));

                } else {
                    view.userInfo("Пока!");
                    lotteryIsOn = false;
                }
            } else {
                view.userInfo("Увы! Призы закончились(");
                lotteryIsOn = false;
            }

        }
    }
}
