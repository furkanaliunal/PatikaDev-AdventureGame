package src.Material;

public class Weapon extends Item{
	private int damage;
	public Weapon(String name, int price, int damage) {
		super(name, price);
		this.damage = damage;
		this.materialType = MaterialType.Weapon;
	}
	
	public int getDamage() {
		return this.damage;
	}
	
	public void setDamage(int damage) {
		this.damage = damage;
	}
	@Override
	public String toString() {
		//Example output: Tabanca\t<Para : 25 - Hasar : 2>
		return getName() + " \t <Para : " + getPrice()+"- Hasar : " + getDamage() + ">";
		
	}
}
