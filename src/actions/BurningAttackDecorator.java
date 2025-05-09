package actions;

import characterState.CharacterBurningState;
import characters.Character;

public class BurningAttackDecorator implements ActionComponent {

    private final ActionComponent actionComponent;
    private final int staminaCost = 10;


    public BurningAttackDecorator(ActionComponent actionComponent) {
        this.actionComponent = actionComponent;
    }

    @Override
    public void perform(Character attacker, Character target) {
    	if (attacker.getStamina() < staminaCost) {
            System.out.println(attacker.getName() + " no tiene suficiente stamina para ataque ígneo.");
            actionComponent.perform(attacker, target); // fallback
            return;
        }


        attacker.setStamina(attacker.getStamina() - staminaCost); // Gasta stamina

        actionComponent.perform(attacker, target); // Aplica el daño base

        if (target.isAlive()) {
            target.setState(new CharacterBurningState());
            System.out.println(target.getName() + " está ardiendo.");
        }
    }

    @Override
    public String getName() {
        return "incendiario";
    }

    @Override
    public String getDescription() {
        return actionComponent.getDescription() + getName();
    }
}