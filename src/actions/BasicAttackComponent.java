package actions;

import utils.DamageCalculator;
import characters.Character;

public class BasicAttackComponent implements ActionComponent{
	 public void perform(Character attacker, Character target) {
	        DamageCalculator.getInstance().applyDamage(attacker, target);
	    }

	public String getName() {
		return "Ataque ";
	}

	public String getDescription() {
		return "Ataque ";
	}
	 
	 
	
}
