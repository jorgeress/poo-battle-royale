package strategies;

import actions.ActionComponent;
import characters.Enemy;
import templates.EnemyBehaviorTemplate;
import characters.Character;

public interface CombatStrategy {
	ActionComponent decideAction(EnemyBehaviorTemplate self, Character target);

}
