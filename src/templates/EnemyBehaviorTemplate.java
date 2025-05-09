package templates;


import characters.Character;
import characters.Enemy;
import characters.Player;
import actions.*;
import strategies.*;
import java.util.Random;


public abstract class EnemyBehaviorTemplate extends Character {

	protected CombatStrategy combatStrategy;
	 public EnemyBehaviorTemplate(int health, int strength, int defense, String name, int speed, CombatStrategy combatStrategy) {
	        super(health, strength, defense, name, speed);
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

	    if (rand.nextDouble() <= 0.25 && getStamina() >= 10) {
	        action = new ParalyzingAttackDecorator(action);
	    }
	    if (rand.nextDouble() <= 0.25 && getStamina() >= 10) {
	        action = new PoisoningAttackDecorator(action);
	    }
	    if (rand.nextDouble() <= 0.25 && getStamina() >= 10) {
	        action = new BurningAttackDecorator(action);
	    }

	    if (strength > 60 && action instanceof BasicAttackComponent && getStamina() >= 15) {
	        action = new PowerfulAttackDecorator(action);
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
	
	public void rewardPlayer(Player player) {
       // Otorga puntos al jugador al derrotar al enemigo
       player.addPoints(100);  // Ejemplo: da 100 puntos por derrotar al enemigo
   }
}