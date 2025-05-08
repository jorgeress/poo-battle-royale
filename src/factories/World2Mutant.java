package factories;

import characters.Mutant;
import strategies.NeutralCombatStrategy;

public class World2Mutant extends Mutant{
	public World2Mutant() {
        super(50, 20, 20, "Advanced Mutant", 30, new NeutralCombatStrategy());
    }
}
