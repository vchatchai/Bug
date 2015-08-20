package Stock;

public class Stock {
	private String stockId;
	private String name;
	private int quantity;

	public Stock(String string, String string2, int i) {
		stockId = string;
		name = string2;
		quantity = i;
	}

	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


}
