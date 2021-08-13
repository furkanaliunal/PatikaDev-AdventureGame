package src.Locations;
import src.Material.Items.Trophies.Water;
import src.Player;
import src.Mobs.Bear;

public class River extends BattleLoc{

	public River(Player player) {
		super(player, "River", new Bear(),new Water());
	}

}
