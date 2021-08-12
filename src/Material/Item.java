package src.Material;

public abstract class Item {
	private int price;
	private String name;
	MaterialType materialType;
	public Item(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public int getPrice() {
		return this.price;
	}
	public String getName() {
		return this.name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
