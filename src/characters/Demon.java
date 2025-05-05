package characters;

import strategies.*;

public class Demon extends Enemy{

	public Demon() {
		super(new AggresiveCombatStrategy());
	}

	
}
