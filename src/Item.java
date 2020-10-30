public class Item {
	
	private String id,name,category;
	
	public Item(String id, String name, String category) {
		this.id = id;
		this.name = name;
		this.category = category;
	}
	
	// Setters are not needed.
	
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCategory() {
		return category;
	}
	
	
	
}
