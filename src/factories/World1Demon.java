package factories;

import characters.Demon;
import strategies.AggresiveCombatStrategy;

public class World1Demon extends Demon{

	public World1Demon() {
        super(50, 15, 10, "Lower Demon", 30, new AggresiveCombatStrategy());
    }
}
