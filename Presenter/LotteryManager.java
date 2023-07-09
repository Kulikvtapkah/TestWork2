package TestWork2.Presenter;

import TestWork2.Models.AbstractLot;
import TestWork2.Models.LotterySet;
import TestWork2.Models.ToyLot;

import TestWork2.View.View;

public class LotteryManager implements ILotteryManager {
    protected LotterySet set;
    protected View view;


        public LotteryManager(LotterySet set, View view) {
        this.set = set;
        this.view = view;
    }

    @Override
    public void addNewLot() {
        view.userInfo("Добавим лот!");
        String lotName = view.getStringData("\nВведите имя лота >> ");

        int lotChanceToPick = view.getNumber("\nВведите базовую частоту выигрыша для лота (1-100%) >> ");
        int lotAmount = view.getNumber("\nВведите количество >> ");

        if (lotAmount <= 0) {
            view.userInfo(String.format("Pазыграть %s призов едва ли получится", lotAmount));
            view.userInfo(String.format("Лот %s не добавлен(", lotName));
        } else if (lotChanceToPick <= 0 || lotChanceToPick > 100) {
            view.userInfo(String.format(" %s - хмм, очевидно, невероятная вероятность...", lotChanceToPick));
            view.userInfo(String.format("Лот %s не добавлен(", lotName));
        } else {
            set.addLot(new ToyLot(lotName, lotChanceToPick, lotAmount));
            view.userInfo(String.format("Лот %s успешно добавлен!", lotName));

        }

    }

    @Override
    public void editLotAmount() {
        view.userInfo("Изменим количество");
        
        int id = view.getNumber("\nВведите номер лота >> ");
        if (id < 0 || id >= set.getLotterySet().size()) {
            view.userInfo("Такого лота нет(");
        } else {
            AbstractLot lotToEdit = set.getLotterySet().get(id);
            view.userInfo(String.format("Редактируем\n%s", lotToEdit));
            int newAmount = view.getNumber("\nВведите новое количество >> ");
            if (newAmount > 0) {
                lotToEdit.setLotAmount(newAmount);
                view.userInfo(String.format("Лот %s успешно изменен!", id));
            } else {
                set.removeLot(id);
                view.userInfo(String.format("Лот %s удален из розырыша", id));
            }
        }

    }

    @Override
    public void editLotChanceToPick() {
        view.userInfo("Изменим частоту выпадания лота");
        int id = view.getNumber("\nВведите номер лота >> ") ;
        if (id < 0 || id >= set.getLotterySet().size()) {
            view.userInfo("Такого лота нет(");
        } else {
            AbstractLot lotToEdit = set.getLotterySet().get(id);
            view.userInfo(String.format("Редактируем\n%s", lotToEdit));
            int newChanseToPick = view.getNumber("\nВведите новое значение (1-100%) >> ");
            if (newChanseToPick > 0 && newChanseToPick <= 100) {
                lotToEdit.setChanceToPick(newChanseToPick);
                view.userInfo(String.format("Лот %s успешно изменен!", id));
            } else {
                view.userInfo(String.format("Лот %s не изменен. Неверный ввод(", id));
            }
        }
    }

    @Override
    public void lotterySetInfo() {
        view.userInfo("Сейчас в розыгрыше: \n");
        for (AbstractLot lot : set.getLotterySet()) {
            System.out.println(lot);

        }
    }

}
