package characterState;

import characters.Character;

public class CharacterDeadState implements CharacterState{

	public void handle(Character self, Character target) {

		System.out.println(self.getName() + "esta muerto.");
	}

}
