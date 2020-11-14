public class ChainStoreApp {
    public static void main(String[] args){
    	System.out.println("=======================================");
        System.out.println("     Welcome to the Chain Store App");
        System.out.println("=======================================");

        int numberOfMonths = 12;
        int numberOfStores = 4;
        int numberOfItems;

        FileManager itemFileManager = new FileManager("HW1_Items.csv");
        String[][] items = itemFileManager.readFile(1);  //1 is the category Index for items.csv
        
        numberOfItems = itemFileManager.getFileLineCount();

        FileManager transactionsFileManager1 = new FileManager("HW1_Transactions_Store1.csv");
        String[][] transactions1 = transactionsFileManager1.readFile(0); //0 is the category index for transactions.csv
        

        FileManager transactionsFileManager2 = new FileManager("HW1_Transactions_Store2.csv");
        String[][] transactions2 = transactionsFileManager2.readFile(0);  

        FileManager transactionsFileManager3= new FileManager("HW1_Transactions_Store3.csv");
        String[][] transactions3 = transactionsFileManager3.readFile(0);

        FileManager transactionsFileManager4 = new FileManager("HW1_Transactions_Store4.csv");
        String[][] transactions4 = transactionsFileManager4.readFile(0);

        AnnualSale annualSale = new AnnualSale(numberOfItems);

        ItemTransaction itemTransaction = null;
        Item item = null ;

        for(int itemIdIndex = 1; itemIdIndex < numberOfItems +1; itemIdIndex++) {

            int itemId = Integer.parseInt(items[itemIdIndex][1]); //itemId index is 1
            String itemName = items[itemIdIndex][0]; //itemName index is 0
            String itemCategory = items[itemIdIndex][2]; // itemCategory index in

            item = new Item(itemId, itemName, itemCategory);

            itemTransaction = new ItemTransaction(item, numberOfStores, numberOfMonths);

            double purchasePrice;
            double salePrice;
            int numberOfSales;
            int monthCounter = 0;

            for(int columnNumber = 1; columnNumber < (numberOfMonths * 3) +1 ;) {   // 12*3+1=37 column in transaction.csv
                purchasePrice = Double.parseDouble(transactions1[itemIdIndex][columnNumber++]);
                salePrice = Double.parseDouble(transactions1[itemIdIndex][columnNumber++]);
                numberOfSales = Integer.parseInt(transactions1[itemIdIndex][columnNumber++]);
                itemTransaction.addTransactionItem( new Transaction(purchasePrice, salePrice, numberOfSales), 0, monthCounter);

                columnNumber -= 3;

                purchasePrice = Double.parseDouble(transactions2[itemIdIndex][columnNumber++]);
                salePrice = Double.parseDouble(transactions2[itemIdIndex][columnNumber++]);
                numberOfSales = Integer.parseInt(transactions2[itemIdIndex][columnNumber++]);
                itemTransaction.addTransactionItem( new Transaction(purchasePrice, salePrice, numberOfSales), 1, monthCounter);

                columnNumber -= 3;

                purchasePrice = Double.parseDouble(transactions3[itemIdIndex][columnNumber++]);
                salePrice = Double.parseDouble(transactions3[itemIdIndex][columnNumber++]);
                numberOfSales = Integer.parseInt(transactions3[itemIdIndex][columnNumber++]);
                itemTransaction.addTransactionItem( new Transaction(purchasePrice, salePrice, numberOfSales), 2, monthCounter);

                columnNumber -= 3;

                purchasePrice = Double.parseDouble(transactions4[itemIdIndex][columnNumber++]);
                salePrice = Double.parseDouble(transactions4[itemIdIndex][columnNumber++]);
                numberOfSales = Integer.parseInt(transactions4[itemIdIndex][columnNumber++]);
                itemTransaction.addTransactionItem( new Transaction(purchasePrice, salePrice, numberOfSales), 3, monthCounter++);


            }
            annualSale.addAnnualSale(itemTransaction, itemId);

        

        }
        
       
        
        
        StoreQuery storeQuery = new StoreQuery(numberOfItems, annualSale, numberOfStores, numberOfMonths);
        
        /// Query 1
        storeQuery.sortProfit("Most");
        // Query 2
        storeQuery.sortCategoryProfit("Most");
        // Query 3
        storeQuery.sortProfit("Least");
        // Query 4
        storeQuery.sortCategoryProfit("Least");
        // Query 5
        storeQuery.getMostProfitableItemForSingleSale();
        // Query 6
        storeQuery.getBestSellerItem();
        // Query 7
        storeQuery.getMostProfitableStoreForEachMonth();
        
        
    }
}
