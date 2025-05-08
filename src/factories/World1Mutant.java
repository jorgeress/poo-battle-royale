package factories;

import characters.Mutant;
import strategies.NeutralCombatStrategy;

public class World1Mutant extends Mutant{

	public World1Mutant() {
        super(40, 15, 15, "Basic Mutant", 30, new NeutralCombatStrategy());
    }

}
