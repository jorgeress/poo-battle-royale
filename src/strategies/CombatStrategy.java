package strategies;

import actions.ActionComponent;

import templates.EnemyBehaviorTemplate;
import characters.Character;

public interface CombatStrategy {
	public ActionComponent decideAction(EnemyBehaviorTemplate self, Character target);

}
