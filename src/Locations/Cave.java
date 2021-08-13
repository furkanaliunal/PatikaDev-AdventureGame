package src.Locations;
import src.Material.Items.Trophies.Food;
import src.Player;
import src.Mobs.Zombie;

public class Cave extends BattleLoc{

	public Cave(Player player) {
		super(player, "Mağara", new Zombie(), new Food());
	}

}
