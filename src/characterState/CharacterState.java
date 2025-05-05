package characterState;

import characters.Character;
public interface CharacterState {
    void handle(Character self, Character target);
}
