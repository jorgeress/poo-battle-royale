package characters;

import java.util.Random;

import actions.*;
import strategies.*;

public class Enemy extends Character implements CombatStrategy {

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


		double paralyzeChance = rand.nextDouble();
		double burnChance = rand.nextDouble();

		if (paralyzeChance <= 0.25) {
			action = new ParalyzingAttackDecorator(action);
		}
		if (burnChance <= 0.25) {
			action = new BurningAttackDecorator(action);
		}
    
		
	    if (strength > 60 && action instanceof BasicAttackComponent) {
	        action = new PowerfulAttackDecorator(action);
	    }
	    System.out.println(getName() + " realiza " + action.getDescription());

	    action.perform(this, target);
	}

	
	public ActionComponent decideAction(Enemy self, Character target) {
		return this.combatStrategy.decideAction(self, target);
	}
	
	
}
