package src.Material;

public class Armor extends Item{
	int armor;
	public Armor(String name, int price, int armor) {
		super(name, price);
		this.armor = armor;
		this.materialType = MaterialType.Armor;
	}

	public int getArmor() {
		return this.armor;
	}
	
	public void setArmor(int armor) {
		this.armor = armor;
	}
	

	@Override
	public String toString() {
		//Example output: Hafif \t <Para : 15 - Hasar : 1>
		return getName() + " \t <Para : " + getPrice()+"- Zırh : " + getArmor() + ">";
		
	}
}
