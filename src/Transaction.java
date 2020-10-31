public class Transaction {
	
	private final double purchasePrice;
	private final double salePrice;
	private final double numberOfSales;
	
	public Transaction(double purchasePrice, double salePrice, double numberOfSales) {
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

	public double getNumberOfSales() {
		return numberOfSales;
	}
	
	
}
