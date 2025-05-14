package factories;

import characters.Cyborg;
import characters.Player;
import strategies.PassiveCombatStrategy;

public class World1Cyborg extends Cyborg{

    public World1Cyborg() {
        super(50, 10, 15, "Cyborg Básico", 30, new PassiveCombatStrategy());
    }

    public void rewardPlayer(Player player) {
        player.addPoints(50);
    }
}
