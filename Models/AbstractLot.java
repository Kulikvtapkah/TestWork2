package TestWork2.Models;

public abstract class AbstractLot implements Comparable<AbstractLot> {
    protected String lotName;
    protected int chanceToPick;
    //это базовая вероятность выпадения при условии, что в выпадает только этот лот либо ничего.
    //фактическая вероятность будет другой. Например, если в беспроигрышной лотерее все лоты
    //имеют вероятность выпадения 100%, это будет означать, что в 100% случаев
    //игроку достанется ОДИН из них. Т.е., если их 10, вероятность выпадения каждого конкретного = 10%, если их 5 = 20% и т.д.
    //Если в розыгрыше 2 лота 1 с базовой вероятностью 50%, второй - 100%, это будет означать, что игроку
    // в 50% случаев может достаться либо 1, либо 2 лот, в остальных 50% случаев ему достанется точно 2 лот.    
   

    protected int lotAmount;
    protected int lotID;

    protected AbstractLot(String lotName, int chanceToPick, int lotAmount) {
        this.lotName = lotName;
        this.chanceToPick = chanceToPick;
        this.lotAmount = lotAmount;
    }

    public int getChanceToPick() {
        return chanceToPick;
    }

    public void setChanceToPick(int rarity) {
        this.chanceToPick = rarity;
    }


    public void reduceAmount() {
        if (lotAmount > 0) {
            lotAmount--;
        }
    }

    public int getLotAmount() {
        return lotAmount;
    }

    public void setLotAmount(int lotAmount) {
        this.lotAmount = lotAmount;
    }


    public int getlotID() {
        return lotID;
    }

    public void setLotID(int lotID) {
        this.lotID = lotID;
    }

    @Override
    public int compareTo(AbstractLot otherLot) {
        return Integer.compare(this.chanceToPick, otherLot.chanceToPick);
    }

    @Override
    public String toString() {
        return String.format("%s. Лот: %s \nБазовая вероятность: %s\n Осталось %s шт.\n",
                lotID, lotName, chanceToPick, lotAmount);
    }

} 