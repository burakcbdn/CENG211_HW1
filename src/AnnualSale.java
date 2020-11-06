public class AnnualSale {
	
	ItemTransaction[] annualSale = new ItemTransaction[33];
	
	void addAnnualSale(ItemTransaction itemTransaction, int itemId) {
		annualSale[itemId] = itemTransaction;
	}
	
	ItemTransaction[] getAnnualSale() {
		return annualSale;
	}
}
