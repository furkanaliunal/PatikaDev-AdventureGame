package src.Material;

public class Trophy extends Item{

	public Trophy(String name) {
		super(name, 0);
		this.materialType = MaterialType.Trophy;
	}

	@Override
	public String toString() {
		return this.getName();
	}

}
