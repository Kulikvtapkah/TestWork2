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
            while (randomPoint <= set.getLot(i).getChanceToPick()) {
                i++;
            }
            System.out.println("i= " + i);
            int randomLot = new Random().nextInt(i+1);
            AbstractLot prize = set.getLot(randomLot);
            prize.reduceAmount();
            if (prize.getLotAmount() == 0)
                set.removeLot(randomLot);
            return String.format("%s", prize);
        } else {
            return "Не получилось, не фортануло( В другой раз повезет!";
        }

    }

    public boolean setIsEmpty() {
        return set.getLotterySet().isEmpty();
    }

}
