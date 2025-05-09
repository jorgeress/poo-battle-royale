package characterState;

import characters.Character;
public class CharacterParalyzedState implements CharacterState {
    private Integer turns = 1;

    @Override
    public void handle(Character self, Character target) {
        System.out.println(self.getName() + " está paralizado y no puede actuar.");
        turns--;
        if (turns <= 0) {
            System.out.println(self.getName() + " se recupera de la parálisis.");
            self.setState(new CharacterHealthyState());
        }
    }
	public String getName() {
		return "ParalyzedState";
	}
}