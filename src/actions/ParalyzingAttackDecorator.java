package actions;

import characterState.CharacterParalyzedState;
import characters.Character;

public class ParalyzingAttackDecorator implements ActionComponent{

	private final ActionComponent actionComponent;

    public ParalyzingAttackDecorator(ActionComponent actionComponent) {
        this.actionComponent = actionComponent;
    }

    public void perform(Character attacker, Character target) {
        System.out.println(attacker.getName() + " realiza " + getDescription());
        int stamina = attacker.getStrength();
        attacker.stamina = stamina - 10;

        actionComponent.perform(attacker, target);

        // Aplicar parálisis al objetivo
        if (target.isAlive()) {
            target.setState(new CharacterParalyzedState());
            System.out.println(target.getName() + " ha quedado paralizado por 1 turno.");
        }
    }

	
	public String getName() {
		return " paralizador";
	}


	public String getDescription() {
		return actionComponent.getDescription() + getName();
	}

}
