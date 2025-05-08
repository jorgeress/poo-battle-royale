package factories;

import characters.Mutant;
import strategies.NeutralCombatStrategy;

public class World3Mutant extends Mutant{
	public World3Mutant() {
        super(60, 25, 25, "Massive Mutant", 30, new NeutralCombatStrategy());
    }
}
