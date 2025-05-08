package characters;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import actions.*;
import strategies.*;
import templates.EnemyBehaviorTemplate;

public abstract class Enemy extends Character {

	protected CombatStrategy combatStrategy;
	protected EnemyBehaviorTemplate enemyBehavior;
	protected int maxHealth;
	protected List<String> actionHistory;

	public Enemy(CombatStrategy combatStrategy) {
		super(100, 20, 10, "Enemigo",50);
		this.combatStrategy = combatStrategy;
		this.maxHealth = 100;
		this.actionHistory = new ArrayList<>();
	}
	
	public CombatStrategy getCombatStrategy() {
		return combatStrategy;
	}

	public void setCombatStrategy(CombatStrategy combatStrategy) {
		this.combatStrategy = combatStrategy;
	}

	public void setEnemyBehavior(EnemyBehaviorTemplate behavior) {
		this.enemyBehavior = behavior;
	}


	public int getMaxHealth() {
		return this.maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	// Método para registrar acciones tomadas por el enemigo
	public void addToActionHistory(String action) {
		actionHistory.add(action);
	}

	public List<String> getActionHistory() {
		return actionHistory;
	}

	//implementacion de act con template method
	@Override
	public final void act(Character target) {
		// Si tenemos un comportamiento de enemigo definido, lo usamos
		if (enemyBehavior != null) {
			String action = enemyBehavior.execute(this, target);
			System.out.println(getName() + " realiza " + action);
			return;
		}

		// De lo contrario, usamos la implementación original
		ActionComponent action = selectBaseAction(target);
		action = applyCommonEffects(action);
		action = applyTypeSpecificEffects(action);
		action = applyAttributeModifiers(action);

		System.out.println(getName() + " realiza " + action.getDescription());
		action.perform(this, target);
	}

	// Implementación del paso 1 - común para todos los enemigos
	protected ActionComponent selectBaseAction(Character target) {
		return combatStrategy.decideAction(this, target);
	}

	// Implementación del paso 2 - común para todos los enemigos
	protected ActionComponent applyCommonEffects(ActionComponent action) {
		Random rand = new Random();

		double paralyzeChance = rand.nextDouble();
		double burnChance = rand.nextDouble();

		if (paralyzeChance <= 0.25) {
			action = new ParalyzingAttackDecorator(action);
		}
		if (burnChance <= 0.25) {
			action = new BurningAttackDecorator(action);
		}

		return action;
	}

	// Paso 3 - abstracto, cada subclase debe implementarlo
	protected abstract ActionComponent applyTypeSpecificEffects(ActionComponent action);

	// Implementación del paso 4 - común pero puede ser sobrescrito
	protected ActionComponent applyAttributeModifiers(ActionComponent action) {
		if (strength > 60 && action instanceof BasicAttackComponent) {
			action = new PowerfulAttackDecorator(action);
		}
		return action;
	}
}
