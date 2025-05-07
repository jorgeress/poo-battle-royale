package characterState;

import characters.Character;
public interface CharacterState {
    public void handle(Character self, Character target);
    public String getName();
}
