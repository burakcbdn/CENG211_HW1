public class Item {
	
	private String name,category;
	private int id;
	
	public Item(int id, String name, String category) {
		this.id = id;
		this.name = name;
		this.category = category;
	}
	
	// Setters are not needed.
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCategory() {
		return category;
	}
	
	
	
}
