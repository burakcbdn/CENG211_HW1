public class Transaction {
	
	private final double purchasePrice;
	private final double salePrice;
	private final int numberOfSales;
	
	public Transaction(double purchasePrice, double salePrice, int numberOfSales) {
		this.purchasePrice = purchasePrice;
		this.salePrice = salePrice;
		this.numberOfSales = numberOfSales;
	}

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public double getSalePrice() {
		return salePrice;
	}

	public int getNumberOfSales() {
		return numberOfSales;
	}
	
}
