package characterState;

import characters.Character;

public class CharacterHealthyState implements CharacterState{

	public void handle(Character self, Character target) {
		self.act(target);
	}
	public String getName() {
		return "HealthyState";
	}

}
