package characters;

import strategies.NeutralCombatStrategy;

public class Mutant extends Enemy{

	public Mutant() {
		super(new NeutralCombatStrategy());
	}

}
