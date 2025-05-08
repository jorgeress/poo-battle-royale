package characters;

import strategies.CombatStrategy;

public class Mutant extends Enemy{

	public Mutant(int health, int strength, int defense, String name, int speed, CombatStrategy strategy) {
        super(health, strength, defense, name, speed, strategy);
    }

}
