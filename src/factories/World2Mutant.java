package factories;

import characters.Mutant;
import characters.Player;
import strategies.NeutralCombatStrategy;

public class World2Mutant extends Mutant{
	public World2Mutant() {
        super(50, 20, 20, "Advanced Mutant", 30, new NeutralCombatStrategy());
    }
    public void rewardPlayer(Player player) {
        player.addPoints(100);
    }
}
