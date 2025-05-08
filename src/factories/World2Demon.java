package factories;

import characters.Demon;
import strategies.AggresiveCombatStrategy;

public class World2Demon extends Demon{

	public World2Demon() {
        super(60, 20, 15, "Medium Demon", 30, new AggresiveCombatStrategy());
    }

}
