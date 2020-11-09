public class AnnualSale {
	
	private ItemTransaction[] annualSale;
	
	public AnnualSale(int numberOfItems) {
		 annualSale = new ItemTransaction[numberOfItems];
	}

	
	
	public void addAnnualSale(ItemTransaction itemTransaction, int itemId) {
		annualSale[itemId] = itemTransaction;
	}
	
	public ItemTransaction getAnnualSale(int itemId) {
		return annualSale[itemId];
	}
	
}
