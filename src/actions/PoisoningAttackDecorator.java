package actions;



import characterState.CharacterPoisonedState;
import characters.Character;

public class PoisoningAttackDecorator extends EffectAttackDecorator {

    public PoisoningAttackDecorator(ActionComponent actionComponent) {
        super(actionComponent, 10); // 10 de stamina
    }

    protected void applyEffect(Character target) {
        target.setState(new CharacterPoisonedState());
    }

    
    protected String getEffectName() {
        return "envenenado";
    }

	public String getName() {
		return "Envenenado";
	}
	public String getDescription() {
		return actionComponent.getDescription() + getName();
	}
}