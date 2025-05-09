package characters;

import actions.ActionComponent;
import actions.PowerfulAttackDecorator; // Asumiendo que tienes este decorador
import strategies.NeutralCombatStrategy;

public class Mutant extends Enemy {

	private int mutationLevel;

	public Mutant() {
		super(new NeutralCombatStrategy());
		this.mutationLevel = 1; // Nivel inicial de mutación
	}


	@Override
	protected ActionComponent applyTypeSpecificEffects(ActionComponent action) {
		// Los mutantes tienen chance de aplicar atauqes poderosos basados en su nivel de mutación
		if (Math.random() < 0.2 * mutationLevel) {
			mutationLevel = (int) Math.min(mutationLevel + 0.5, 5); // Máximo nivel 5
			return new PowerfulAttackDecorator(action);
		}

		return action;
	}

	/**
	 * Sobrescritura opcional del método de modificadores de atributos.
	 * Los mutantes reciben bonificaciones basadas en su nivel de mutación.
	 */
	@Override
	protected ActionComponent applyAttributeModifiers(ActionComponent action) {
		// Primero aplicamos el comportamiento heredado
		ActionComponent modifiedAction = super.applyAttributeModifiers(action);

		// Luego aplicamos modificaciones específicas del mutante
		if (mutationLevel >= 3) {
			// A partir del nivel 3, los ataques ganan potencia adicional
			// Aquí podríamos aplicar otro decorador específico para mutantes
			// modifiedAction = new MutatedAttackDecorator(modifiedAction);
		}

		return modifiedAction;
	}

	/*
	 Métodos adicionales específicos de Mutant

	public int getMutationLevel() {
		return mutationLevel;
	}

	public void setMutationLevel(int level) {
		this.mutationLevel = Math.max(1, Math.min(level, 5)); // Entre 1 y 5
	}

	public void evolve() {
		if (mutationLevel < 5) {
			mutationLevel++;
			setStrength(getStrength() + 10);
			setDefense(getDefense() + 5);
		}
	}
	 */

}