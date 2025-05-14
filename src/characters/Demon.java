package characters;

import strategies.*;

public class Demon extends Enemy{

	public Demon(int health, int strength, int defense, String name, int speed, CombatStrategy strategy) {
        super(health, strength, defense, name, speed, strategy);
    }

	
}
