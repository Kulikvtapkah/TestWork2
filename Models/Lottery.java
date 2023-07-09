package TestWork2.Models;

import java.util.Random;

public class Lottery {
    LotterySet set;

    public Lottery(LotterySet set) {
        this.set = set;
    }

    public String spin() {
        int randomPoint = new Random().nextInt(100);
        System.out.println("выпало " + randomPoint);
        int i = 0;
        if (i < set.getLotterySet().size()) {
            while (i < set.getLotterySet().size() && randomPoint <= set.getLot(i).getChanceToPick()) {
                i++;
            }
            if (i > 0){

            int randomLot = new Random().nextInt(i);
            AbstractLot prize = set.getLot(randomLot);
            prize.reduceAmount();
            if (prize.getLotAmount() == 0)
                set.removeLot(randomLot);
            return String.format("Поздравляем! Ваш выигрыш: \n%s", prize);

            }
            else {
            return "Не получилось, не фортануло( В другой раз повезет!\n";
        }
           
        } 
         else {
            return "Не получилось, не фортануло( В другой раз повезет!";
        }
           


    }

    public boolean setIsEmpty() {
        return set.getLotterySet().isEmpty();
    }

}
