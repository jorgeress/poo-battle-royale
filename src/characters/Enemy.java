
package characters;

import strategies.CombatStrategy;
import templates.EnemyBehaviorTemplate;

public class Enemy extends EnemyBehaviorTemplate {

    public Enemy(int health, int strength, int defense, String name, int speed, CombatStrategy strategy) {
        super(health, strength, defense, name, speed, strategy);
    }

}