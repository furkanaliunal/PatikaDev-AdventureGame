package src;

import java.util.HashSet;

import src.Material.*;

public class Inventory {
	HashSet<IMaterial> items;
	private int damage,armor, trophyAmount;
	
	Inventory(){
		items = new HashSet<>();
		this.damage = 0;
		this.armor = 0;
		this.trophyAmount = 0;
	}

	public void addItem(IMaterial item) {
		Boolean hasItem = hasItem(item);
		if (hasItem) {
			System.out.println("Bu item zaten mevcut!!");
			return;
		}
		switch(item.getMaterialType()) {
			case Armor:
				Armor newArmor = (Armor)item;
				this.armor += newArmor.getArmor();
				break;
			case Weapon:
				Weapon newWeapon = (Weapon)item;
				this.damage += newWeapon.getDamage();
				break;
			case Trophy:
				this.trophyAmount++;
				break;
			}
			items.add(item);
	}
	
	private Boolean hasItem(IMaterial item) {
		return items.contains(item);
	}

	public int getArmor() {
		return armor;
	}
	public int getDamage() {
		return this.damage;
	}
	
	public int getTrophyAmount() {
		return this.trophyAmount;
	}
	
	public String getWeaponName() {
		Weapon mainWeapon = null;
		for(IMaterial m : items) {
			if (m.getMaterialType() == MaterialType.Weapon) {
				Weapon currWeapon = (Weapon)m;
				if  (mainWeapon == null || currWeapon.getDamage() > mainWeapon.getDamage()){
					mainWeapon = currWeapon;
				}
			}
		}
		return mainWeapon.getName();
	}
	
	public String getArmorName() {
		Armor mainArmor = null;
		for(IMaterial m : items) {
			if (m.getMaterialType() == MaterialType.Armor) {
				Armor currWeapon = (Armor)m;
				if  (mainArmor == null || currWeapon.getArmor() > mainArmor.getArmor()){
					mainArmor = currWeapon;
				}
			}
		}
		return mainArmor.getName();
	}
	
	
}
