public class AnnualSale {
	
	private int sizeOfArray;
	
	public AnnualSale(int numberOfItems) {
		this.sizeOfArray = numberOfItems;
	}

	private ItemTransaction[] annualSale = new ItemTransaction[sizeOfArray];
	
	public void addAnnualSale(ItemTransaction itemTransaction, int itemId) {
		annualSale[itemId] = itemTransaction;
	}
	
	public ItemTransaction getAnnualSale(int itemId) {
		return annualSale[itemId];
	}
	
}
