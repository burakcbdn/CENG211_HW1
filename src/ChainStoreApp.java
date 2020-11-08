import java.io.File;

public class ChainStoreApp {
    public static void main(String[] args){
        System.out.println("Welcome to Chain Store");
        
        int numberOfMonths = 12;
        int numberOfStores = 4;
        int numberOfItems = 33; //This can be found by reading Items.csv again.
        
        FileManager itemFileManager = new FileManager("HW1_Items.csv");
        String[][] items = itemFileManager.readFile(numberOfItems, 1);  //1 is the category Index for items.csv
        //items = [null,[Water,1,Beverage],[Coke,2,Beverage],[],[]]
        System.out.println(items[2][0]);
        
        FileManager transactionsFileManager1 = new FileManager("HW1_Transactions_Store1.csv");
        String[][] transactions1 = transactionsFileManager1.readFile(numberOfItems,0); //0 is the category index for transactions.csv
        
        FileManager transactionsFileManager2 = new FileManager("HW1_Transactions_Store2.csv"); 
        String[][] transactions2 = transactionsFileManager2.readFile(numberOfItems);  //default category index is 0
        
        FileManager transactionsFileManager3= new FileManager("HW1_Transactions_Store3.csv");
        String[][] transactions3 = transactionsFileManager3.readFile(numberOfItems);
        
        FileManager transactionsFileManager4 = new FileManager("HW1_Transactions_Store4.csv");
        String[][] transactions4 = transactionsFileManager4.readFile(numberOfItems);
     
        AnnualSale annualSale = new AnnualSale(numberOfItems);
        
        for(int i = 1; i < numberOfItems; i++) {
        	int itemId = Integer.parseInt(items[i][1]); //id index is 1
        	String itemName = items[i][0]; //name index is 0
        	String itemCategory = items[i][2]; // category index is 2
        	Item item = new Item(itemId, itemName, itemCategory);
        	ItemTransaction itemTransaction = new ItemTransaction(item, numberOfStores, numberOfMonths);
        	for(int a = 1; a < numberOfItems; i++) {
        		
        	}
        	
        }
    }
}
