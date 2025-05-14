package factories;

import characters.Demon;
import characters.Player;
import strategies.AggresiveCombatStrategy;

public class World3Demon extends Demon{

	public World3Demon() {
        super(70, 25, 20, "Upper Demon", 30, new AggresiveCombatStrategy());
    }

    public void rewardPlayer(Player player) {
        player.addPoints(150);
    }
}
