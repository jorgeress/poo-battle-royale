package factories;

import characters.*;

public class World1AbstractFactory implements EnemyAbstractFactory {
	

	public Demon createDemon() {
		return new World1Demon();
	}

	public Mutant createMutant() {
		return new World1Mutant();
	}

	public Cyborg createCyborg() {
		return new World1Cyborg();
	}



}