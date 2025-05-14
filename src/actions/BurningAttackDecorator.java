package actions;

import characterState.CharacterBurningState;
import characters.Character;

public class BurningAttackDecorator extends EffectAttackDecorator {

    public BurningAttackDecorator(ActionComponent actionComponent) {
        super(actionComponent, 10); // 10 de stamina
    }

    protected void applyEffect(Character target) {
        target.setState(new CharacterBurningState());
    }

    
    protected String getEffectName() {
        return "ardiendo";
    }

	public String getName() {
		return "Incendiario";
	}
	public String getDescription() {
		return actionComponent.getDescription() + getName();
	}
}