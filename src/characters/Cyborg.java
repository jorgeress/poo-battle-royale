package characters;

import actions.ActionComponent;
import actions.PowerfulAttackDecorator;
import strategies.PassiveCombatStrategy;
import templates.CyborgBehaviorTemplate;

public class Cyborg extends Enemy{

	private int energy;
	private int maxEnergy;
	private String targetWeakness;
	private boolean overclocked;
	private boolean hasActiveUpgrades;



	public Cyborg() {
		super(new PassiveCombatStrategy());
		this.energy = 100;
		this.maxEnergy = 100;
		this.overclocked = false;
		this.hasActiveUpgrades = false;
		this.targetWeakness = null;

		setEnemyBehavior(new CyborgBehaviorTemplate());
	}

	// Getters y setters necesarios
	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = Math.min(energy, maxEnergy);
	}

	public int getMaxEnergy() {
		return maxEnergy;
	}

	public void setMaxEnergy(int maxEnergy) {
		this.maxEnergy = maxEnergy;
	}

	public String getTargetWeakness() {
		return targetWeakness;
	}

	public void setTargetWeakness(String targetWeakness) {
		this.targetWeakness = targetWeakness;
	}

	public boolean isOverclocked() {
		return overclocked;
	}

	public void setOverclocked(boolean overclocked) {
		this.overclocked = overclocked;
	}

	public boolean hasActiveUpgrades() {
		return hasActiveUpgrades;
	}

	public void setHasActiveUpgrades(boolean hasActiveUpgrades) {
		this.hasActiveUpgrades = hasActiveUpgrades;
	}

	// Métodos requeridos por CyborgBehaviorTemplate
	public void consumeEnergy(int amount) {
		this.energy = Math.max(0, this.energy - amount);
	}

	public void scanTarget(Character player) {
		// Implementación simple: determina una debilidad basada en las estadísticas del jugador
		if (player.getDefense() < 30) {
			targetWeakness = "defensa baja";
		} else if (player.getStrength() < 20) {
			targetWeakness = "ataque débil";
		} else if (player.getHealth() < player.getMaxHealth() * 0.4) {
			targetWeakness = "salud crítica";
		} else {
			targetWeakness = null;
		}
	}

	public void optimizeSystemsFor(String weakness) {
		// Ajusta los sistemas del cyborg para explotar la debilidad
        switch (weakness) {
            case "defensa baja" -> {
                setStrength(getStrength() + 10);
                hasActiveUpgrades = true;
            }
            case "ataque débil" -> {
                setDefense(getDefense() + 15);
                hasActiveUpgrades = true;
            }
            case "salud crítica" ->
                //setSpeed(getSpeed() + 5);
                    hasActiveUpgrades = true;
        }
	}

	@Override
	protected ActionComponent applyTypeSpecificEffects(ActionComponent action) {
		// Los cyborgs pueden modificar sus ataques con tecnología
		if (energy >= 30) {
			energy -= 30;
			return new PowerfulAttackDecorator(action);
			//return new ElectricalAttackDecorator(action); podemos implementar esto
		}
		return action;
	}
}


