package actions;

import characters.Character;
public interface ActionComponent {
	public void perform(Character attacker, Character target);
    public String getName();
    public String getDescription();
    
}
