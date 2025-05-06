package actions;

import characterState.CharacterBurningState;
import characters.Character;

public class BurningAttackDecorator implements ActionComponent {

    private final ActionComponent actionComponent;

    public BurningAttackDecorator(ActionComponent actionComponent) {
        this.actionComponent = actionComponent;
    }

    @Override
    public void perform(Character attacker, Character target) {
        actionComponent.perform(attacker, target);
        if (target.isAlive()) {
            target.setState(new CharacterBurningState());
            System.out.println(target.getName() + " está ardiendo.");
        }
    }

    @Override
    public String getName() {
        return " incendiario";
    }

    @Override
    public String getDescription() {
        return actionComponent.getDescription() + getName();
    }
}