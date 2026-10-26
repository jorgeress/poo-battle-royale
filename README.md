# Turn-based combat (Java, design patterns)

*[Versión en español](README.es.md)*

A turn-based console combat game in Java, built for an object-oriented
programming course at U-tad. The game itself is small; the point of the
project is the architecture: each moving part is a classic design pattern,
and they plug into each other.

You build a character by spending 120 points across health, strength and
defense, then fight through 3 worlds with 3 enemies each (a demon, a cyborg
and a mutant). A coin toss decides who starts each fight, every win grants a
random power-up, and status effects (burning, paralyzed, poisoned) carry over
between turns.

> The game's console text and the project report are in Spanish.

## Patterns

| Pattern | Where | What it does here |
|---|---|---|
| **Abstract Factory** | `factories/` | `World1AbstractFactory`, `World2…`, `World3…` each create their own demon, cyborg and mutant. `WorldManager` swaps the factory when you move to the next world, and the rest of the code never knows which world it's in. |
| **Strategy** | `strategies/` | Each enemy carries an aggressive, neutral or passive `CombatStrategy` that decides its next action. It can be changed at runtime. |
| **Decorator** | `actions/` | A basic attack can be wrapped in `Paralyzing`, `Burning`, `Poisoning` or `Powerful` decorators, stacked in any combination. `EffectAttackDecorator` holds the shared logic: stamina cost, then the base attack, then the effect. |
| **State** | `characterState/` | Healthy, burning, paralyzed, poisoned and dead are state objects that run each of a character's turns: a paralyzed character loses its turn, a burning one takes damage and then acts, and the state wears off after a few turns. |
| **Template Method** | `templates/EnemyBehaviorTemplate` | `act()` fixes the steps of an enemy's turn (ask the strategy, maybe decorate the action, perform it), and each enemy type fills in its own stats. |

## Running it

Requires Java 14 or later (it uses switch expressions).

```bash
javac -d out $(find src -name '*.java')
java -cp out main.Main
```

## Structure

```
src/
  main/            entry point
  controller/      GameController: the game loop
  managers/        CombatManager (one fight) and WorldManager (worlds and enemies)
  characters/      Character, Player, Enemy and the three enemy types
  factories/       one abstract factory per world
  strategies/      enemy combat strategies
  actions/         attacks, defense and their decorators
  characterState/  status effects
  templates/       the enemy turn template
  utils/           damage, turn order, stat allocation and power-ups
docs/
  memoria-combate-por-turnos.pdf   the project report (Spanish): analysis, design, user manual
```
