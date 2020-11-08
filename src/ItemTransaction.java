public class ItemTransaction {
    
    private int numberOfStores;
    private int numberOfMonths;
    public Item item;

    ItemTransaction(Item item, int numberOfStores, int numberOfMonths){
    	this.item = item;
        this.numberOfStores = numberOfStores;
        this.numberOfMonths = numberOfMonths;    
    }
    
    private Transaction[][] itemTransaction = new Transaction[numberOfStores][numberOfMonths];
    
    public void addTransactionItem(Transaction transaction, int storeNumber, int monthNumber) {
    	// Subtracted 1 from index because it should be [2][8] for 3rd store -september
    	itemTransaction[storeNumber -1][monthNumber-1] = transaction; 
    }
    
    public Transaction getItemTransaction(int numberOfStores, int numberOfMonths){
    	return itemTransaction[numberOfStores][numberOfMonths];
    }
    
}
