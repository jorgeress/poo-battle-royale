package characters;

import java.util.Random;

import actions.*;
import strategies.*;

public class Enemy extends Character {

	protected CombatStrategy combatStrategy;
	public Enemy(CombatStrategy combatStrategy) {
		super(100, 20, 10, "Enemigo",50);
		this.combatStrategy = combatStrategy;
	}
	
	public CombatStrategy getCombatStrategy() {
		return combatStrategy;
	}

	public void setCombatStrategy(CombatStrategy combatStrategy) {
		this.combatStrategy = combatStrategy;
	}
	public void act(Character target) {
		ActionComponent action = combatStrategy.decideAction(this, target);
		
		Random rand = new Random();

        // Generamos un número aleatorio entre 0 y 1
        double chance = rand.nextDouble(); // Valor entre 0.0 y 1.0
        
        if (chance <= 0.2) {
            action = new ParalyzingAttackDecorator(action);
        }
    
		
	    if (strength > 60 && action instanceof BasicAttackComponent) {
	        action = new PowerfulAttackDecorator(action);
	    }

	    action.perform(this, target);
	}
	
}
