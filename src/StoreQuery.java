import java.util.Map;

public class StoreQuery {


    private final AnnualSale annualSale;
    private final int numberOfItems;
    private final int numberOfStores;
    private final int numberOfMonths;


    public StoreQuery(int numberOfItems, AnnualSale annualSale, int numberOfStores, int numberOfMonths) {
        this.numberOfItems = numberOfItems;
        this.annualSale = annualSale;
        this.numberOfStores = numberOfStores;
        this.numberOfMonths = numberOfMonths;
    }

    public double calculateProfit(Transaction transaction) {
        return (transaction.getSalePrice() - transaction.getPurchasePrice()) * transaction.getNumberOfSales();
    }


    public void getMostProfitableItem() {
        sortProfit("most");
    }

    public void mostProfitableStore() {
        double mostProfit = 0;
        int itemId = 1;
        int[] mostProfitableStoresForEachMonth = new int[12];
        for (int monthNo = 0; monthNo < numberOfMonths; monthNo++) {    //index is 1 for itemId 1
            for (int storeNo = 0; storeNo < numberOfStores; storeNo++) {  //index is 0 for store1
                double storeProfit = 0;
                for (int indexID = 1; indexID < numberOfItems; indexID++) { //index is 0 for 1st month

                    storeProfit += calculateProfit(annualSale.getAnnualSale(indexID).getItemTransaction(storeNo, monthNo));
                }

                if (storeProfit > mostProfit) {
                    mostProfit = storeProfit;
                    mostProfitableStoresForEachMonth[monthNo] = storeNo;
                }
                storeProfit = 0;
            }
            System.out.println("Most profitable store for the month " + monthNo + " is store " + mostProfitableStoresForEachMonth[monthNo]);
        }


    }

    public void getMostProfitableCategory() {

    }

    public void getLeastProfitableItem() {
        sortProfit("least");
    }

    private void sortProfit(String type) {
        double mostProfit = 0;
        double leastProfit = Double.MAX_VALUE;
        double tempProfit = 0;
        int itemId = 1;
        for(int indexID = 1; indexID < numberOfItems; indexID++) {	//index is 1 for itemId 1
            for(int storeNo = 0; storeNo < numberOfStores; storeNo++ ) {  //index is 0 for store1
                for(int monthNo = 0; monthNo < numberOfMonths; monthNo++) { //index is 0 for 1st month
                    tempProfit += calculateProfit(annualSale.getAnnualSale(indexID).getItemTransaction(storeNo, monthNo));
                }
            }
            if (type.equals("most")){
                if (tempProfit > mostProfit) {
                    mostProfit = tempProfit;
                    itemId = indexID;
                }
                tempProfit = 0;
            } else if (type.equals("least")){
                if (tempProfit < leastProfit) {
                    leastProfit = tempProfit;
                    itemId = indexID;
                }
                tempProfit = 0;
            }
        }

        System.out.println(annualSale.getAnnualSale(itemId).getItem());
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

        System.out.println(annualSale.getAnnualSale(itemId).getItem());
    }

    public void getMostProfitableStore() {

    }

    public void getLeastProfitableCategory() {

    }

    public void getMostProfitableItemForSingleSale() {

    }

}
