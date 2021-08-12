package src.Locations;
import src.Player;

public class SafeHouse extends NormalLoc {

	public SafeHouse(Player player) {
		super(player, "Güvenli Ev");
	}
	
	public boolean getLocation() {
		player.setHealthy(player.getrHealthy());
		System.out.println("İyileştiniz...");
		System.out.println("Şuan Güvenli Ev adlı yerdesiniz.");
		return true;
	}

}
