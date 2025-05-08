package factories;

import characters.Cyborg;
import strategies.PassiveCombatStrategy;

public class World2Cyborg extends Cyborg{

	public World2Cyborg() {
        super(60, 15, 20, "Advanced Cyborg", 30, new PassiveCombatStrategy());
    }

}
