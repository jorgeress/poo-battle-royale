package factories;

import characters.Cyborg;
import characters.Demon;
import characters.Mutant;

public class World2AbstractFactory implements EnemyAbstractFactory{

	public Demon createDemon() {
		return new World2Demon();
	}

	public Mutant createMutant() {
		return new World2Mutant();
	}

	public Cyborg createCyborg() {
		return new World2Cyborg();
	}

}
