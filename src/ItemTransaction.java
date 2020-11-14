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
    	// Subtracted 1 from index because it should be [2][8] for 3rd store - September
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemTransaction that = (ItemTransaction) o;
        return Objects.equals(item, that.item) &&
                Arrays.equals(itemTransactions, that.itemTransactions);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(item);
        result = 31 * result + Arrays.hashCode(itemTransactions);
        return result;
    }
}
