public class StoreAssistant {
    public void start(){
        System.out.println("=======================================");
        System.out.println("     Welcome to the Chain Store App");
        System.out.println("=======================================");

        int numberOfMonths = 12;
        int numberOfStores = 4;
        int numberOfItems;

        FileManager fileManager = new FileManager();

        numberOfItems = fileManager.getFileLineCount("HW1_Items.csv");

        String[][] items = fileManager.readFile("HW1_Items.csv", 1);  //1 is the category Index for items.csv

        String[][] transactions1 = fileManager.readFile("HW1_Transactions_Store1.csv", 0); //0 is the category index for transactions.csv

        String[][] transactions2 = fileManager.readFile("HW1_Transactions_Store2.csv", 0);

        String[][] transactions3 = fileManager.readFile("HW1_Transactions_Store3.csv", 0);

        String[][] transactions4 = fileManager.readFile("HW1_Transactions_Store4.csv", 0);

        AnnualSale annualSale = new AnnualSale(numberOfItems);

        ItemTransaction itemTransaction;
        Item item;

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

        // Query 1
        storeQuery.sortProfit("Most");
        setBorder();
        // Query 2
        storeQuery.sortCategoryProfit("Most");
        setBorder();
        // Query 3
        storeQuery.sortProfit("Least");
        setBorder();
        // Query 4
        storeQuery.sortCategoryProfit("Least");
        setBorder();
        // Query 5
        storeQuery.getMostProfitableItemForSingleSale();
        setBorder();
        // Query 6
        storeQuery.getBestSellerItem();
        setBorder();
        // Query 7
        storeQuery.getMostProfitableStoreForEachMonth();
    }

   

    private static void setBorder() {
        System.out.println("**************************************************");
    }

}
