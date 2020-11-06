public class AnnualSale {
	
	int sizeOfArray;
	
	public AnnualSale(int numberOfItems) {
		sizeOfArray = numberOfItems;
	}

	ItemTransaction[] annualSale = new ItemTransaction[sizeOfArray];
	
	void addAnnualSale(ItemTransaction itemTransaction, int itemId) {
		annualSale[itemId] = itemTransaction;
	}
	
	ItemTransaction[] getAnnualSale() {
		return annualSale;
	}
	
}
