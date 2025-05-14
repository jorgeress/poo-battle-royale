package factories;

import characters.Demon;
import characters.Player;
import strategies.AggresiveCombatStrategy;

public class World2Demon extends Demon{

	public World2Demon() {
        super(60, 20, 15, "Medium Demon", 30, new AggresiveCombatStrategy());
    }
    public void rewardPlayer(Player player) {
        player.addPoints(100);
    }
}
