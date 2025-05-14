package actions;


import characters.Character;

public abstract class EffectAttackDecorator implements ActionComponent {

    protected final ActionComponent actionComponent;
    protected final Integer staminaCost;

    public EffectAttackDecorator(ActionComponent actionComponent, int staminaCost) {
        this.actionComponent = actionComponent;
        this.staminaCost = staminaCost;
    }

    
    public void perform(Character attacker, Character target) {
        if (attacker.getStamina() < staminaCost) {
            System.out.println(attacker.getName() + " no tiene suficiente stamina para ataque " + getEffectName() + ".");
            actionComponent.perform(attacker, target); 
            return;
        }

        attacker.setStamina(attacker.getStamina() - staminaCost);
        actionComponent.perform(attacker, target);

        if (target.isAlive()) {
            applyEffect(target);
            System.out.println(target.getName() + " está " + getEffectName() + ".");
        }
    }

    public String getDescription() {
        return actionComponent.getDescription() + getEffectName();
    }

    protected abstract void applyEffect(Character target);

    protected abstract String getEffectName();
    
}