package src.Material;

public class Armor extends Item{
	int armor;
	public Armor(String name, int price, int armor) {
		super(name, price);
		this.armor = armor;
		this.materialType = MaterialType.armor;
	}

	public int getArmor() {
		return this.armor;
	}
	
	public void setArmor(int armor) {
		this.armor = armor;
	}
}
