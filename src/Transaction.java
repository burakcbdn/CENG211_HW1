import java.util.Objects;

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

	@Override
	public String toString() {
		return "Transaction{" +
				"purchasePrice=" + purchasePrice +
				", salePrice=" + salePrice +
				", numberOfSales=" + numberOfSales +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Transaction that = (Transaction) o;
		return Double.compare(that.purchasePrice, purchasePrice) == 0 &&
				Double.compare(that.salePrice, salePrice) == 0 &&
				numberOfSales == that.numberOfSales;
	}

	@Override
	public int hashCode() {
		return Objects.hash(purchasePrice, salePrice, numberOfSales);
	}
}
