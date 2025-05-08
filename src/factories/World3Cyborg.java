package factories;

import characters.Cyborg;
import strategies.PassiveCombatStrategy;

public class World3Cyborg extends Cyborg{

	public World3Cyborg() {
        super(70, 20, 25, "High Tech", 30, new PassiveCombatStrategy());
    }

}
