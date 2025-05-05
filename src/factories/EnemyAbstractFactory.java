package factories;

import characters.*;

public interface EnemyAbstractFactory {
	public Demon createDemon();
	public Mutant createMutant();
	public Cyborg createCyborg();
}
