package src.Mobs;
import src.Material.IMaterial;

import java.util.Random;
public class Obstacle {
	private String name;
	private int damage, award, health, maxNumber;
	private IMaterial loot;

	public Obstacle(String name, int damage, int health, int award, int maxNumber) {
		this.name = name;
		this.damage = damage;
		this.award = award;
		this.health = health;
		this.maxNumber = maxNumber;
		this.loot = null;
	}
	public Obstacle(String name, int damage, int health, IMaterial loot, int maxNumber) {
		this.name = name;
		this.damage = damage;
		this.award = 0;
		this.health = health;
		this.maxNumber = maxNumber;
		this.loot = loot;
	}


	public int count() {
		Random r = new Random();
		return r.nextInt(this.maxNumber) + 1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getAward() {
		return award;
	}

	public IMaterial getLoot(){return this.loot;}

	protected void setLoot(IMaterial loot){
		this.loot = loot;
	}

	public void setAward(int award) {
		this.award = award;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getMaxNumber() {
		return maxNumber;
	}

	public void setMaxNumber(int maxNumber) {
		this.maxNumber = maxNumber;
	}

}
