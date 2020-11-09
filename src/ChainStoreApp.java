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
   
        
        FileManager transactionsFileManager1 = new FileManager("HW1_Transactions_Store1.csv");
        String[][] transactions1 = transactionsFileManager1.readFile(numberOfItems); //0 is the category index for transactions.csv
        //transactions1 = [null,[1, 0.28, 1.45, 565, 0.27, 1.34 444],[0.27, 1.34, 444],[],[],[]]
        //transactions[categoryId][index]
        System.out.println(transactions1[1][36]);
        FileManager transactionsFileManager2 = new FileManager("HW1_Transactions_Store2.csv"); 
        String[][] transactions2 = transactionsFileManager2.readFile(numberOfItems);  //default categorIndex parameter is 0
        
        FileManager transactionsFileManager3= new FileManager("HW1_Transactions_Store3.csv");
        String[][] transactions3 = transactionsFileManager3.readFile(numberOfItems);
        
        FileManager transactionsFileManager4 = new FileManager("HW1_Transactions_Store4.csv");
        String[][] transactions4 = transactionsFileManager4.readFile(numberOfItems);
     
        AnnualSale annualSale = new AnnualSale(numberOfItems);
        
        ItemTransaction itemTransaction;
        Item item;
        
        for(int categoryIndex = 1; categoryIndex < numberOfItems; categoryIndex++) {
        	
        	int itemId = Integer.parseInt(items[categoryIndex][1]); //itemId index is 1
        	String itemName = items[categoryIndex][0]; //itemName index is 0
        	String itemCategory = items[categoryIndex][2]; // itemCategory index in 
        	
        	item = new Item(itemId, itemName, itemCategory);
        	
        	itemTransaction = new ItemTransaction(item, numberOfStores, numberOfMonths);
        	
        	double purchasePrice;
        	double salePrice;
        	int numberOfSales;
        	int monthCounter = 1;
        	
        	for(int columnNumber = 1; columnNumber < (numberOfMonths * 3) +1 ;) {   // 37 column in transaction.csv
        		 purchasePrice = Double.parseDouble(transactions1[categoryIndex][columnNumber++]); //i'th category
        		 salePrice = Double.parseDouble(transactions1[categoryIndex][columnNumber++]);
        		 numberOfSales = Integer.parseInt(transactions1[categoryIndex][columnNumber++]);
        		 itemTransaction.addTransactionItem( new Transaction(purchasePrice, salePrice, numberOfSales), 1, monthCounter);
        		 
        		 columnNumber -= 3;
        		 
        		 purchasePrice = Double.parseDouble(transactions2[categoryIndex][columnNumber++]); 
        		 salePrice = Double.parseDouble(transactions2[categoryIndex][columnNumber++]);
        		 numberOfSales = Integer.parseInt(transactions2[categoryIndex][columnNumber++]);
        		 itemTransaction.addTransactionItem( new Transaction(purchasePrice, salePrice, numberOfSales), 2, monthCounter);
        		 
        		 columnNumber -= 3;
        		 
        		 purchasePrice = Double.parseDouble(transactions3[categoryIndex][columnNumber++]); 
        		 salePrice = Double.parseDouble(transactions3[categoryIndex][columnNumber++]);
        		 numberOfSales = Integer.parseInt(transactions3[categoryIndex][columnNumber++]);
        		 itemTransaction.addTransactionItem( new Transaction(purchasePrice, salePrice, numberOfSales), 3, monthCounter);
        		 
        		 columnNumber -= 3;
        		 
        		 purchasePrice = Double.parseDouble(transactions4[categoryIndex][columnNumber++]);
        		 salePrice = Double.parseDouble(transactions4[categoryIndex][columnNumber++]);
        		 numberOfSales = Integer.parseInt(transactions4[categoryIndex][columnNumber++]);
        		 itemTransaction.addTransactionItem( new Transaction(purchasePrice, salePrice, numberOfSales), 4, monthCounter++);
        		 
        		 
        	}
        	annualSale.addAnnualSale(itemTransaction, itemId);
        	
        }
    }
}
