public class ItemTransaction {
    
  
    public Item item;
    private Transaction[][] itemTransactions;

    ItemTransaction(Item item, int numberOfStores, int numberOfMonths){
    	
    	this.item = item;
        itemTransactions = new Transaction[numberOfStores][numberOfMonths];
    }
    
     
    
        
    public void addTransactionItem(Transaction transaction, int storeNumber, int monthNumber) {
    	// Subtracted 1 from index because it should be [2][8] for 3rd store - September
    	itemTransactions[storeNumber-1][monthNumber-1] = transaction; 
    }
    
    public Transaction getItemTransaction(int numberOfStores, int numberOfMonths){
    	return itemTransactions[numberOfStores][numberOfMonths];
    }
    
}
