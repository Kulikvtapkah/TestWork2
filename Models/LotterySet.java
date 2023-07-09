package TestWork2.Models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LotterySet {
    protected List<AbstractLot> lotterySet;

    public LotterySet() {
        this.lotterySet = new ArrayList<AbstractLot>();
    }

    public LotterySet(List<AbstractLot> list) {
        this();
        this.lotterySet.addAll(list);
        setIDs();
        
    }

    private void setIDs() {
        lotterySet.sort(Comparator.reverseOrder());
        for (int index = 0; index < lotterySet.size(); index++) {
            getLot(index).setLotID(index);
        }
    }

    public void addLot(AbstractLot newLot){
        lotterySet.add(newLot);
        setIDs();
        System.out.println();
    }
    public void removeLot(int lotID ){
        lotterySet.remove(lotID);
        setIDs();
    }    

    public AbstractLot getLot(int ID) {
        return lotterySet.get(ID);
    }

    public List<AbstractLot> getLotterySet() {
        return lotterySet;
    }

}
