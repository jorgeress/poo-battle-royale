package factories;

import characters.Mutant;
import characters.Player;
import strategies.NeutralCombatStrategy;

public class World1Mutant extends Mutant{

	public World1Mutant() {
        super(40, 15, 15, "Basic Mutant", 30, new NeutralCombatStrategy());
    }
    public void rewardPlayer(Player player) {
        player.addPoints(50);
    }
}
