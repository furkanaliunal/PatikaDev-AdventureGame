package src.Locations;
import src.Material.Trophy;
import src.Player;

public class SafeHouse extends NormalLoc {

	public SafeHouse(Player player) {
		super(player, "Güvenli Ev");
	}
	
	public boolean getLocation() {
		player.setHealthy(player.getrHealthy());
		System.out.println("İyileştiniz...");
		System.out.println("Şuan Güvenli Ev adlı yerdesiniz.");


		System.out.println("Alınmış ödüller: (" + player.getInv().getTrophyAmount() + ")");
		for (Trophy t : player.getInv().getTrophies()){
			System.out.println(t.toString());
		}
		if (player.getInv().getTrophyAmount() == 3){
			System.out.println("Tebrikler oyunu bitirdiniz!!!");
			return false;
		}

		return true;
	}

}
