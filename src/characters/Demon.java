package characters;

import actions.ActionComponent;
import actions.BurningAttackDecorator;
import strategies.*;
import templates.DemonBehaviorTemplate;

public class Demon extends Enemy{

	private int mana;
	private int maxMana;
	private boolean aggressiveMode;
	private boolean demonicPact;
	private int hellAttackCount;

	public Demon() {
		super(new AggresiveCombatStrategy()); // O cualquier estrategia por defecto
		this.mana = 100;
		this.maxMana = 100;
		this.aggressiveMode = false;
		this.demonicPact = false;
		this.hellAttackCount = 0;

		setEnemyBehavior(new DemonBehaviorTemplate());
	}



	// Getters y setters requeridos por DemonBehaviorTemplate
	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public int getMaxMana() {
		return maxMana;
	}

	public void setMaxMana(int maxMana) {
		this.maxMana = maxMana;
	}

	public boolean isAggressiveMode() {
		return aggressiveMode;
	}

	public void setAggressiveMode(boolean aggressiveMode) {
		this.aggressiveMode = aggressiveMode;
	}

	public boolean hasDemonicPact() {
		return demonicPact;
	}

	public void setDemonicPact(boolean demonicPact) {
		this.demonicPact = demonicPact;
	}

	public int getHellAttackCount() {
		return hellAttackCount;
	}

	public void incrementHellAttackCount() {
		this.hellAttackCount++;
	}


	@Override
	protected ActionComponent applyTypeSpecificEffects(ActionComponent action) {
		// Los demonios tienden a aplicar efectos de quemadura
		if (mana >= 25) {
			mana -= 25;
			return new BurningAttackDecorator(action);
		}
		return action;
	}

}
	

