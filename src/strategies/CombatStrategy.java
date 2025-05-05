package strategies;

import actions.ActionComponent;
import characters.Enemy;
import characters.Character;

public interface CombatStrategy {
	ActionComponent decideAction(Enemy self, Character target);

}
