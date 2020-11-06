public class ItemTransaction {
    
    int numberOfStores;
    int numberOfMonths;

    ItemTransaction(int numberOfStores, int numberOfMonths){
        this.numberOfStores = numberOfStores;
        this.numberOfMonths = numberOfMonths;    
    }
    
    Transaction[][] itemTransaction = new Transaction[numberOfStores][numberOfMonths];
    
    void addItemTransaction(Transaction transaction, int storeNumber, int monthNumber) {
    	itemTransaction[storeNumber][monthNumber] = transaction;
    }
    
}
