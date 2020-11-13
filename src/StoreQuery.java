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

	public void getMostProfitableItem(){
		double mostProfit = 0;
		double tempProfit = 0;
		int itemId = 1;
		for(int indexID = 1; indexID < numberOfItems; indexID++) {	//index is 1 for itemId 1
			for(int storeNo = 0; storeNo < numberOfStores; storeNo++ ) {  //index is 0 for store1
				for(int monthNo = 0; monthNo < numberOfMonths; monthNo++) { //index is 0 for 1st month
					tempProfit += calculateProfit(annualSale.getAnnualSale(indexID).getItemTransaction(storeNo, monthNo));						
					}
				}
			if(tempProfit > mostProfit) {
				mostProfit = tempProfit;
				itemId = indexID;
			}
			tempProfit = 0;
					
		}
		
		System.out.println(annualSale.getAnnualSale(itemId).getItem());
	}

	public void getMostProfitableCategory(){

    }

    public void getLeastProfitableItem(){

    }

    public void  getLeastProfitableCategory(){

    }

    public void getMostProfitableItemForSingleSale(){

    }
}
