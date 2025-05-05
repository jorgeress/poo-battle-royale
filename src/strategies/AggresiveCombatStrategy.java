package strategies;

import java.util.Random;

import actions.ActionComponent;
import actions.BasicAttackComponent;
import actions.BasicDefenseComponent;
import characters.Character;
import characters.Enemy;

public class AggresiveCombatStrategy implements CombatStrategy{

	public ActionComponent decideAction(Enemy self, Character target) {
		 Random rand = new Random();

	        double chance = rand.nextDouble(); 
	        
	        if (chance <= 0.8) {
	            return new BasicAttackComponent();
	        } else {
	            return new BasicDefenseComponent();
	        }
	    }

}
