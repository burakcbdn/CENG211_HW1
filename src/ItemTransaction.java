public class ItemTransaction {
    
    private int numberOfStores;
    private int numberOfMonths;

    ItemTransaction(int numberOfStores, int numberOfMonths){
        this.numberOfStores = numberOfStores;
        this.numberOfMonths = numberOfMonths;    
    }
    
    private Transaction[][] itemTransaction = new Transaction[numberOfStores][numberOfMonths];
    
    public void addTransactionItem(Transaction transaction, int storeNumber, int monthNumber) {
    	itemTransaction[storeNumber][monthNumber] = transaction;
    }
    
    public Transaction getItemTransaction(int numberOfStores, int numberOfMonths){
    	return itemTransaction[numberOfStores][numberOfMonths];
    }
    
}
