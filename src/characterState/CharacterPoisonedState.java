package characterState;

import characters.Character;
public class CharacterPoisonedState implements CharacterState {
    private Integer turns = 2;
    private Integer daño = 10;

    @Override
    public void handle(Character self, Character target) {
        System.out.println(self.getName() + " está envenado.");
        self.takeDamage(daño);
        turns--;
		self.act(target);
        if (turns <= 0) {
            System.out.println(self.getName() + " ha dejado de estar envenenado.");
            self.setState(new CharacterHealthyState());
        }
    }

	public String getName() {
		return "PoisonedState";
	}
}