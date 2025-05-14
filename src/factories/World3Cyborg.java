package factories;

import characters.Cyborg;
import characters.Player;
import strategies.PassiveCombatStrategy;

public class World3Cyborg extends Cyborg{

	public World3Cyborg() {
        super(70, 20, 25, "High Tech", 30, new PassiveCombatStrategy());
    }

    public void rewardPlayer(Player player) {
        player.addPoints(150);
    }
}
