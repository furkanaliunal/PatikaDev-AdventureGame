package src.Locations;
import src.Material.Items.Trophies.Firewood;
import src.Player;
import src.Mobs.Vampire;

public class Forest extends BattleLoc{

	public Forest(Player player) {
		super(player, "Orman", new Vampire(), new Firewood());
		
	}
	

}
