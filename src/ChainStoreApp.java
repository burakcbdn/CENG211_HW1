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
        String[][] transactions1 = transactionsFileManager1.readFile(numberOfItems,0); //0 is the category index for transactions.csv
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
        
        for(int i = 1; i < numberOfItems; i++) {
        	
        	int itemId = Integer.parseInt(items[i][1]); //id index is 1
        	String itemName = items[i][0]; //name index is 0
        	String itemCategory = items[i][2]; // category index is 2
        	
        	Item item = new Item(itemId, itemName, itemCategory);
        	
        	ItemTransaction itemTransaction = new ItemTransaction(item, numberOfStores, numberOfMonths);
        	
        	double purchasePrice;
        	double salePrice;
        	int numberOfSales;
        	int monthCounter = 1;
        	
        	for(int a = 1; a < (numberOfMonths * 3) +1 ;) {   // 37 column in transaction.csv
        		 purchasePrice = Double.parseDouble(transactions1[i][a++]); //i'th category
        		 salePrice = Double.parseDouble(transactions1[i][a++]);
        		 numberOfSales = Integer.parseInt(transactions1[i][a++]);
        		 itemTransaction.addTransactionItem( new Transaction(purchasePrice, salePrice, numberOfSales), 1, monthCounter);
        		 
        		 a -= 3;
        		 
        		 purchasePrice = Double.parseDouble(transactions2[i][a++]); //i'th category
        		 salePrice = Double.parseDouble(transactions2[i][a++]);
        		 numberOfSales = Integer.parseInt(transactions2[i][a++]);
        		 itemTransaction.addTransactionItem( new Transaction(purchasePrice, salePrice, numberOfSales), 2, monthCounter);
        		 
        		 a -= 3;
        		 
        		 purchasePrice = Double.parseDouble(transactions3[i][a++]); //i'th category
        		 salePrice = Double.parseDouble(transactions3[i][a++]);
        		 numberOfSales = Integer.parseInt(transactions3[i][a++]);
        		 itemTransaction.addTransactionItem( new Transaction(purchasePrice, salePrice, numberOfSales), 3, monthCounter);
        		 
        		 a -= 3;
        		 
        		 purchasePrice = Double.parseDouble(transactions4[i][a++]); //i'th category
        		 salePrice = Double.parseDouble(transactions4[i][a++]);
        		 numberOfSales = Integer.parseInt(transactions4[i][a++]);
        		 itemTransaction.addTransactionItem( new Transaction(purchasePrice, salePrice, numberOfSales), 4, monthCounter++);
        		 
        		 
        	}
        	annualSale.addAnnualSale(itemTransaction, itemId);
        	
        }
    }
}
