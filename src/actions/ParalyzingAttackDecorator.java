package actions;

import characterState.CharacterParalyzedState;
import characters.Character;

public class ParalyzingAttackDecorator implements ActionComponent{

	private final ActionComponent actionComponent;
    private final int staminaCost = 10;

    public ParalyzingAttackDecorator(ActionComponent actionComponent) {
        this.actionComponent = actionComponent;
    }

    public void perform(Character attacker, Character target) {
    	if (attacker.getStamina() < staminaCost) {
            System.out.println(attacker.getName() + " no tiene suficiente stamina para ataque paralizador.");
            actionComponent.perform(attacker, target); // fallback
            return;
        }

    	 attacker.setStamina(attacker.getStamina() - staminaCost); // Gasta stamina

         actionComponent.perform(attacker, target); // Aplica el daño base
    	if (target.isAlive()) {
            target.setState(new CharacterParalyzedState());
            System.out.println(target.getName() + " está paralizado.");
        }
    }

	
	public String getName() {
		return "paralizador";
	}


	public String getDescription() {
		return actionComponent.getDescription() + getName();
	}

}
