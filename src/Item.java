import java.util.Objects;

public class Item {
	
	private final String name;
    private final String category;
	private final int id;
	
	public Item(int id, String name, String category) { 
		this.id = id;
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

	
	public String toString() {
		return "Item{" +
				"name='" + name + '\'' +
				", category='" + category + '\'' +
				", id=" + id +
				'}';
	}


	@Override
	public int hashCode() {
		return Objects.hash(name, category, id);
	}


	@Override
	public boolean equals(Object otherItem) {
		if (this == otherItem) return true;
		if (otherItem == null || getClass() != otherItem.getClass()) return false;
		Item item = (Item) otherItem;
		return id == item.id &&
				Objects.equals(name, item.name) &&
				Objects.equals(category, item.category);
	}
	
	
	
	
	

	
}
