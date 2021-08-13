package src.Locations;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import src.Player;
import src.Material.*;
import src.Material.Items.Armors.*;
import src.Material.Items.Weapons.*;

public class ToolStore extends NormalLoc {
	
	Set<Armor> armors;
	Set<Weapon> weapons;

	public ToolStore(Player player) {
		super(player, "Mağaza");
		armors = new HashSet<>();
		weapons = new HashSet<>();
		
		armors.add(new LightArmor());
		armors.add(new MediumArmor());
		armors.add(new HeavyArmor());
		
		weapons.add(new Pistol());
		weapons.add(new Sword());
		weapons.add(new Shotgun());
	}

	public boolean getLocation() {
		System.out.println("Para : " + player.getMoney());
		System.out.println("1. Silahlar");
		System.out.println("2. Zırhlar");
		System.out.println("3. Çıkış");
		System.out.print("Seçiminiz : ");
		int selTool = scan.nextInt();
		int selItemID;
		switch (selTool) {
		case 1:
			selItemID = weaponMenu();
			buyWeapon(selItemID);
			break;
		case 2:
			selItemID = armorMenu();
			buyArmor(selItemID);
			break;
		default:
			break;
		}

		return true;
	}
	
	public int armorMenu() {
		Iterator<Armor> it = armors.iterator();
		int i = 1;
		while(it.hasNext()) {
			System.out.println(i++ + ". " + it.next().toString());
		}

		System.out.println("4. Çıkış");
		System.out.print("Silah Seçiniz : ");
		int selArmorID = scan.nextInt();
		return selArmorID;
	}
	
	public void buyArmor(int itemID) {
		int exitID = armors.size() + 1;
		if (itemID >= exitID){
			System.out.println("Çıkış Yapılıyor.");
			return;
		}

		Armor newArmor = null;
		Iterator<Armor> it = armors.iterator();

		for(int i = 1; i < itemID; i++){
			it.next();
		}
		newArmor = it.next();

		if (newArmor == null) {
			System.out.println("Geçersiz işlem !");
			return;
		}
		if (newArmor.getPrice() > 0) {
			if (player.getMoney() >= newArmor.getPrice()) {
				player.setMoney(player.getMoney() - newArmor.getPrice());
				player.getInv().addItem(newArmor);
				System.out.println(player.getInv().getArmorName() + " satın aldınız, Engellenen Hasar : " + player.getInv().getArmor());
				System.out.println("Kalan Para :" + player.getMoney());
			} else {
				System.out.println("Para yetersiz. !");
			}
		}
	}

	public int weaponMenu() {
		Iterator<Weapon> it = weapons.iterator();
		int i = 1;
		while(it.hasNext()) {
			System.out.println(i++ + ". " + it.next().toString());
		}

		System.out.println(i + ". Çıkış");
		System.out.print("Silah Seçiniz : ");
		int selWeaponID = scan.nextInt();
		return selWeaponID;
	}

	public void buyWeapon(int itemID) {
		int exitID = weapons.size() + 1;
		if (itemID >= exitID){
			System.out.println("Çıkış Yapılıyor.");
			return;
		}

		Weapon newWeapon = null;
		Iterator<Weapon> it = weapons.iterator();
		for(int i = 1; i < itemID; i++){
			it.next();
		}
		newWeapon = it.next();

		if (newWeapon == null) {
			return;
		}
		if (newWeapon.getPrice() > 0) {
			if (player.getMoney() >= newWeapon.getPrice()) {
				player.setMoney(player.getMoney() - newWeapon.getPrice());
				player.getInv().addItem(newWeapon);
				System.out.println(player.getInv().getWeaponName() + " satın aldınız, Önceki Hasar :" + player.getDamage() + ", Yeni Hasar : "
						+ player.getTotalDamage());
				System.out.println("Kalan Para :" + player.getMoney());
			} else {
				System.out.println("Para yetersiz. !");
			}
		}
	}

}
