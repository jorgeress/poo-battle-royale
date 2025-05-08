package factories;

import characters.Cyborg;
import strategies.PassiveCombatStrategy;

public class World1Cyborg extends Cyborg{

    public World1Cyborg() {
        super(50, 10, 15, "Cyborg Básico", 30, new PassiveCombatStrategy());
    }

}
