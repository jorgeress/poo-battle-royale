package factories;

import characters.Cyborg;
import characters.Demon;
import characters.Mutant;

public class World3AbstractFactory implements EnemyAbstractFactory{

	public Demon createDemon() {
		return new World3Demon();
	}

	public Mutant createMutant() {
		return new World3Mutant();
	}

	public Cyborg createCyborg() {
		return new World3Cyborg();
	}

}
