package characters;

import strategies.CombatStrategy;

public class Cyborg extends Enemy{

	public Cyborg(int health, int strength, int defense, String name, int speed, CombatStrategy strategy) {
        super(health, strength, defense, name, speed, strategy);
    }

}
