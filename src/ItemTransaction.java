import java.util.Arrays;
import java.util.Objects;

public class ItemTransaction {
    

    private Item item;
    private final Transaction[][] itemTransactions;

    ItemTransaction(Item item, int numberOfStores, int numberOfMonths){

    	this.item = item;
        itemTransactions = new Transaction[numberOfStores][numberOfMonths];
    }
    

    

    public void addTransactionItem(Transaction transaction, int storeNumber, int month) {
    	
    	itemTransactions[storeNumber][month] = transaction;
    }
    
    public Transaction getItemTransaction(int storeNumber, int month){
    	return itemTransactions[storeNumber][month];
    }

    public Item getItem() {
        return item;
    }

    public Transaction[][] getItemTransactions() {
        return itemTransactions;
    }

    @Override
    public String toString() {
        return "ItemTransaction{" +
                "item=" + item +
                ", itemTransactions=" + Arrays.toString(itemTransactions) +
                '}';
    }

  
}
