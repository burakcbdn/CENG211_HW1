import java.util.Enumeration;
import java.util.Hashtable;

public class StoreQuery {


    private AnnualSale annualSale = null;
    private final int numberOfItems;
    private final int numberOfStores;
    private final int numberOfMonths;


    public StoreQuery(int numberOfItems, AnnualSale annualSale, int numberOfStores, int numberOfMonths) {
        this.numberOfItems = numberOfItems;
        this.annualSale = annualSale;
        this.numberOfStores = numberOfStores;
        this.numberOfMonths = numberOfMonths;
    }



    private double calculateProfit(Transaction transaction) {
        return (transaction.getSalePrice() - transaction.getPurchasePrice()) * transaction.getNumberOfSales();
    }

   

    public void getMostProfitableStoreForEachMonth() {
        double mostProfit = 0;
        double storeProfit = 0;
        int[] mostProfitableStoresForEachMonth = new int[numberOfMonths];
        
        for (int monthNo = 0; monthNo < numberOfMonths; monthNo++) {    //index is 1 for itemId 1
            for (int storeNo = 0; storeNo < numberOfStores; storeNo++) {  //index is 0 for store1
                for (int indexID = 1; indexID < numberOfItems; indexID++) { //index is 0 for 1st month

                    storeProfit += calculateProfit(annualSale.getAnnualSale(indexID).getItemTransaction(storeNo, monthNo));                    
                    
                }

                if (storeProfit > mostProfit) {
                	
                    mostProfit = storeProfit;
                    mostProfitableStoresForEachMonth[monthNo] = storeNo;
                }
                storeProfit = 0;
            }
           
            System.out.println("Most profitable store for the month " + (monthNo+1) + " is store " + (mostProfitableStoresForEachMonth[monthNo]+1));
            mostProfit = 0;
        }


    }

    private Hashtable<String, Double> getCategoryMap() {

        String category;
        Hashtable<String, Double> hashTable = new Hashtable<String, Double>();
        for (int indexID = 1; indexID < numberOfItems; indexID++) {
            category = annualSale.getAnnualSale(indexID).getItem().getCategory();
            hashTable.put(category, (double) 0);
        }
   
        return hashTable;
    }

    private Hashtable<String, Double> getCategoryProfitsMap() {

        Hashtable<String, Double> hashTable = getCategoryMap();
        String category;
        double profit = 0;

        for (int indexID = 1; indexID < numberOfItems; indexID++) {    //index is 1 for itemId 1
            for (int storeNo = 0; storeNo < numberOfStores; storeNo++) {  //index is 0 for store1
                for (int monthNo = 0; monthNo < numberOfMonths; monthNo++) { //index is 0 for 1st month
                    profit += calculateProfit(annualSale.getAnnualSale(indexID).getItemTransaction(storeNo, monthNo));
                }
            }
            category = annualSale.getAnnualSale(indexID).getItem().getCategory();
            hashTable.replace(category, (profit + hashTable.get(category)));
            
            profit = 0;
        }
        return hashTable;
    }

    public void sortCategoryProfit(String type) {
        String category = null;
        String tempCategory;
        double mostProfit = 0;
        double leastProfit = Double.MAX_VALUE;
        Hashtable<String, Double> hashTable = getCategoryProfitsMap();
        Enumeration<String> categories = hashTable.keys();
        while (categories.hasMoreElements()) {

            tempCategory = categories.nextElement();

            if (type.equals("Most")) {
            	
                if (hashTable.get(tempCategory) > mostProfit) {
                    category = tempCategory;
                    mostProfit = hashTable.get(tempCategory);
                    
                }

            } else if (type.equals("Least")) {
            	
                if (hashTable.get(tempCategory) < leastProfit) {
                    category = tempCategory;                   
                    leastProfit = hashTable.get(tempCategory);
                    
                }
            }
        }
      
        System.out.println(type + " profitable category is " + category);


    }

   

    public void sortProfit(String type) {
        double mostProfit = 0;
        double leastProfit = Double.MAX_VALUE;
        double tempProfit = 0;
        int itemId = 1;
        for (int indexID = 1; indexID < numberOfItems; indexID++) {    //index is 1 for itemId 1
            for (int storeNo = 0; storeNo < numberOfStores; storeNo++) {  //index is 0 for store1
                for (int monthNo = 0; monthNo < numberOfMonths; monthNo++) { //index is 0 for 1st month
                    tempProfit += calculateProfit(annualSale.getAnnualSale(indexID).getItemTransaction(storeNo, monthNo));
                }
            }
            if (type.equals("Most")) {
                if (tempProfit > mostProfit) {
                    mostProfit = tempProfit;
                    itemId = indexID;
                }

            } else if (type.equals("Least")) {
                if (tempProfit < leastProfit) {
                    leastProfit = tempProfit;
                    itemId = indexID;
                }

            }
            tempProfit = 0;
        }

        System.out.println(type + " profitable item is " + annualSale.getAnnualSale(itemId).getItem());
      
    }

    public void getBestSellerItem() {
        int numberOfSales = 0;
        int tempNumberOfSales = 0;
        int itemId = 1;
        for (int indexID = 1; indexID < numberOfItems; indexID++) {    //index is 1 for itemId 1
            for (int storeNo = 0; storeNo < numberOfStores; storeNo++) {  //index is 0 for store1
                for (int monthNo = 0; monthNo < numberOfMonths; monthNo++) { //index is 0 for 1st month
                    tempNumberOfSales += annualSale.getAnnualSale(indexID).getItemTransaction(storeNo, monthNo).getNumberOfSales();
                }
            }
            if (tempNumberOfSales > numberOfSales) {
                numberOfSales = tempNumberOfSales;
                itemId = indexID;
            }

            tempNumberOfSales = 0;


        }

        System.out.println("Best Seller Item is " + annualSale.getAnnualSale(itemId).getItem());
    }
    
    private double calculateSingleSaleProfit(Transaction transaction) {
    	return transaction.getSalePrice() - transaction.getPurchasePrice();
    }
    
    public void getMostProfitableItemForSingleSale() {
    
        double mostProfit = 0;
        double tempProfit = 0;
        int itemId = 1;
        for (int monthNo = 0; monthNo < numberOfMonths; monthNo++) {    //index is 1 for itemId 1
            for (int storeNo = 0; storeNo < numberOfStores; storeNo++) {  //index is 0 for store1
                for (int indexID = 1; indexID < numberOfItems; indexID++) { //index is 0 for 1st month
                    tempProfit = calculateSingleSaleProfit(annualSale.getAnnualSale(indexID).getItemTransaction(storeNo, monthNo));
                    if (tempProfit > mostProfit) {
                    
                        mostProfit = tempProfit;
                        itemId = indexID;
                    }
                    tempProfit = 0;
                }
            }

        }
        System.out.println("Most profitable item for single sale : " + annualSale.getAnnualSale(itemId).getItem());
    }

}
