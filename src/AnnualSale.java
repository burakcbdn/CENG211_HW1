public class AnnualSale {
	
	private int sizeOfArray;
	
	public AnnualSale(int numberOfItems) {
		this.sizeOfArray = numberOfItems;
	}

	ItemTransaction[] annualSale = new ItemTransaction[sizeOfArray];
	
	void addAnnualSale(ItemTransaction itemTransaction, int itemId) {
		annualSale[itemId] = itemTransaction;
	}
	
	ItemTransaction[] getAnnualSale() {
		return annualSale;
	}
	
}
