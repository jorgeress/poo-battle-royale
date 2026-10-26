# Combate por turnos (Java, patrones de diseño)

*[English version](README.md)*

Un juego de combate por turnos en consola, en Java, hecho para la asignatura
de programación orientada a objetos de U-tad. El juego es pequeño; lo que
importa del proyecto es la arquitectura: cada pieza es un patrón de diseño
clásico, y encajan unas con otras.

Creas un personaje repartiendo 120 puntos entre vida, fuerza y defensa, y
luchas a través de 3 mundos con 3 enemigos cada uno (un demonio, un cíborg y un
mutante). Una moneda decide quién empieza cada combate, cada victoria da un
power-up al azar, y los estados (quemado, paralizado, envenenado) se mantienen
de un turno a otro.

## Patrones

| Patrón | Dónde | Qué hace aquí |
|---|---|---|
| **Abstract Factory** | `factories/` | `World1AbstractFactory`, `World2…` y `World3…` crean cada uno su demonio, su cíborg y su mutante. `WorldManager` cambia de fábrica al pasar de mundo, y el resto del código no sabe en qué mundo está. |
| **Strategy** | `strategies/` | Cada enemigo lleva una `CombatStrategy` agresiva, neutral o pasiva que decide su siguiente acción. Se puede cambiar en ejecución. |
| **Decorator** | `actions/` | Un ataque básico se puede envolver en los decoradores `Paralyzing`, `Burning`, `Poisoning` o `Powerful`, apilados en cualquier combinación. `EffectAttackDecorator` reúne la lógica común: coste de stamina, ataque base y luego el efecto. |
| **State** | `characterState/` | Sano, quemado, paralizado, envenenado y muerto son objetos de estado que ejecutan cada turno del personaje: el paralizado pierde el turno, el quemado recibe daño y luego actúa, y el estado se pasa al cabo de unos turnos. |
| **Template Method** | `templates/EnemyBehaviorTemplate` | `act()` fija los pasos del turno de un enemigo (preguntar a la estrategia, decorar o no la acción, ejecutarla), y cada tipo de enemigo pone sus estadísticas. |

## Cómo ejecutarlo

Necesita Java 14 o superior (usa expresiones `switch`).

```bash
javac -d out $(find src -name '*.java')
java -cp out main.Main
```

## Estructura

```
src/
  main/            punto de entrada
  controller/      GameController: el bucle de la partida
  managers/        CombatManager (un combate) y WorldManager (mundos y enemigos)
  characters/      Character, Player, Enemy y los tres tipos de enemigo
  factories/       una fábrica abstracta por mundo
  strategies/      estrategias de combate de los enemigos
  actions/         ataques, defensa y sus decoradores
  characterState/  estados alterados
  templates/       la plantilla del turno enemigo
  utils/           daño, orden de turno, reparto de estadísticas y power-ups
docs/
  memoria-combate-por-turnos.pdf   la memoria del proyecto: análisis, diseño y manual de usuario
```
