package characters;

import strategies.PassiveCombatStrategy;

public class Cyborg extends Enemy{

	public Cyborg() {
		super(new PassiveCombatStrategy());
	}

}
