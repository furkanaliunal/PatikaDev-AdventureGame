package src.Locations;
import src.BattleLoc;
import src.Player;
import src.Mobs.Zombie;

public class Cave extends BattleLoc{

	public Cave(Player player) {
		super(player, "Ma�ara", new Zombie(),"Food");
	}

}
