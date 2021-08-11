package src.Locations;
import src.BattleLoc;
import src.Player;
import src.Mobs.Vampire;

public class Forest extends BattleLoc{

	public Forest(Player player) {
		super(player, "Orman", new Vampire(),"Firewood");
		
	}
	

}
