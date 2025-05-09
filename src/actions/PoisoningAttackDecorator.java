package actions;

import characterState.CharacterBurningState;
import characters.Character;

public class PoisoningAttackDecorator implements ActionComponent {

    private final ActionComponent actionComponent;

    public PoisoningAttackDecorator(ActionComponent actionComponent) {
        this.actionComponent = actionComponent;
    }

    @Override
    public void perform(Character attacker, Character target) {
        actionComponent.perform(attacker, target);
        if (target.isAlive()) {
            target.setState(new CharacterBurningState());
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