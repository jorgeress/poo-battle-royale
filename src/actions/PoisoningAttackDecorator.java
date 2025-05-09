package actions;


import characterState.CharacterPoisonedState;
import characters.Character;

public class PoisoningAttackDecorator implements ActionComponent {

    private final ActionComponent actionComponent;
    private final int staminaCost = 10;


    public PoisoningAttackDecorator(ActionComponent actionComponent) {
        this.actionComponent = actionComponent;
    }

    @Override
    public void perform(Character attacker, Character target) {
    	if (attacker.getStamina() < staminaCost) {
            System.out.println(attacker.getName() + " no tiene suficiente stamina para ataque paralizador.");
            actionComponent.perform(attacker, target); // fallback
            return;
        }

    	 attacker.setStamina(attacker.getStamina() - staminaCost); // Gasta stamina

         actionComponent.perform(attacker, target); // Aplica el daño base
    	if (target.isAlive()) {
            target.setState(new CharacterPoisonedState());
            System.out.println(target.getName() + " está envenenado.");
    	}
    }

    @Override
    public String getName() {
        return "envenenado";
    }

    @Override
    public String getDescription() {
        return actionComponent.getDescription() + getName();
    }
}