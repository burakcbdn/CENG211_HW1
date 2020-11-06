public class Item {
	
	private final String name;
    private final String category;
	private final int id;
	
	public Item(int id, String name, String category) { this.id = id;
		this.name = name;
		this.category = category;
	}
	
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
