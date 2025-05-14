package actions;


import characterState.CharacterParalyzedState;
import characters.Character;

public class ParalyzingAttackDecorator extends EffectAttackDecorator {

    public ParalyzingAttackDecorator(ActionComponent actionComponent) {
        super(actionComponent, 10); // 10 de stamina
    }

    protected void applyEffect(Character target) {
        target.setState(new CharacterParalyzedState());
    }

    
    protected String getEffectName() {
        return "paralizado";
    }

	public String getName() {
		return "Paralizador";
	}
	public String getDescription() {
		return actionComponent.getDescription() + getName();
	}
}