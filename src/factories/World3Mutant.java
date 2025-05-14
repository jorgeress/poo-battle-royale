package factories;

import characters.Mutant;
import characters.Player;
import strategies.NeutralCombatStrategy;

public class World3Mutant extends Mutant{
	public World3Mutant() {
        super(60, 25, 25, "Massive Mutant", 30, new NeutralCombatStrategy());
    }

    public void rewardPlayer(Player player) {
        player.addPoints(150);
    }
}
