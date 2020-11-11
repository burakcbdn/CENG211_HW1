public class StoreQuery {
	
	
	AnnualSale annualSale;
	int numberOfItems;
	int numberOfStores;
	int numberOfMonths;
	
	
	public StoreQuery(int numberOfItems, AnnualSale annualSale, int numberOfStores, int numberOfMonths) {
		this.numberOfItems = numberOfItems;
		this.annualSale = annualSale;
		this.numberOfStores = numberOfStores;
		this.numberOfMonths = numberOfMonths;
	}

	
}
