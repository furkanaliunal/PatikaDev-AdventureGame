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
		super(player, "Ma�aza");
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
		System.out.println("2. Z�rhlar");
		System.out.println("3. ��k��");
		System.out.print("Se�iminiz : ");
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
		
		/*System.out.println("1. Hafif \t <Para : 15 - Hasar : 1>");
		System.out.println("2. Orta \t <Para : 25 - Hasar : 3>");
		System.out.println("3. A��r \t <Para : 40 - Hasar : 5>");*/
		System.out.println("4. ��k��");
		System.out.print("Silah Se�iniz : ");
		int selArmorID = scan.nextInt();
		return selArmorID;
	}
	
	public void buyArmor(int itemID) {
		Armor newArmor = null;
		switch (itemID) {
		case 1:
			newArmor = new LightArmor();
			break;
		case 2:
			newArmor = new MediumArmor();
			break;
		case 3:
			newArmor = new HeavyArmor();
			break;
		case 4:
			System.out.println("��k�� Yap�l�yor.");
			break;
		default:
			System.out.println("Ge�ersiz ��lem !");
			break;
		}

		if (newArmor.getPrice() > 0) {
			if (player.getMoney() >= newArmor.getPrice()) {
				player.setMoney(player.getMoney() - newArmor.getPrice());
				System.out.println(player.getInv().getArmorName() + " sat�n ald�n�z, Engellenen Hasar : " + player.getInv().getArmor());
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
		
		/*System.out.println("1. Tabanca\t<Para : 25 - Hasar : 2>");
		System.out.println("2. K�l��\t<Para : 35 - Hasar : 3>");
		System.out.println("3. T�fek\t<Para : 45 - Hasar : 7>");*/
		System.out.println(i + ". ��k��");
		System.out.print("Silah Se�iniz : ");
		int selWeaponID = scan.nextInt();
		return selWeaponID;
	}

	public void buyWeapon(int itemID) {
		Weapon newWeapon = null;
		switch (itemID) {
		case 1:
			newWeapon = new Pistol();
			break;
		case 2:
			newWeapon = new Sword();
			break;
		case 3:
			newWeapon = new Shotgun();
			break;
		case 4:
			System.out.println("��k�� Yap�l�yor.");
			break;
		default:
			System.out.println("Ge�ersiz ��lem !");
			break;
		}

		if (newWeapon.getPrice() > 0) {
			if (player.getMoney() > newWeapon.getPrice()) {
				player.setMoney(player.getMoney() - newWeapon.getPrice());
				System.out.println(player.getInv().getWeaponName() + " sat�n ald�n�z, �nceki Hasar :" + player.getDamage() + ", Yeni Hasar : "
						+ player.getTotalDamage());
				System.out.println("Kalan Para :" + player.getMoney());
			} else {
				System.out.println("Para yetersiz. !");
			}
		}
	}

}
