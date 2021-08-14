package src.Locations;

import src.Mobs.Snake;
import src.Player;

public class Mine extends BattleLoc{
    public Mine(Player player) {

        super(player, "Maden", new Snake(), null);
    }
}
