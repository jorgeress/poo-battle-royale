package templates;

import characters.Character;
import characters.Enemy;
import characterState.CharacterState;

public abstract class EnemyBehaviorTemplate {

    // Método template que define la secuencia de pasos
    public final String execute(Enemy enemy, Character player) {
        // Paso 1: Analizar la situación de combate
        analyzeCombatSituation(enemy, player);

        // Paso 2: Elegir una estrategia basada en el análisis
        String strategy = chooseStrategy(enemy, player);

        // Paso 3: Determinar la acción específica basada en la estrategia
        String action = determineSpecificAction(enemy, player, strategy);

        // Paso 4: Aplicar modificadores de estado a la acción
        String modifiedAction = applyStateModifiers(enemy, action);

        // Paso 5: Registrar la acción para análisis futuros
        recordAction(enemy, modifiedAction);

        // Devolver la acción resultante
        return modifiedAction;
    }

    // Los siguientes métodos definen los pasos del algoritmo
    // y pueden ser sobreescritos por las subclases

    //Verifica si el enemigo puede realizar uan accion
    protected boolean canPerformAction(Enemy enemy) {
        // Implementación por defecto - verifica salud básica
        return enemy.getHealth() > 0;
    }

    // Análisis de la situación
    protected abstract void analyzeCombatSituation(Enemy enemy, Character player);

    // Selección de estrategia
    protected abstract String chooseStrategy(Enemy enemy, Character player);

    // Determinación de acción específica
    protected abstract String determineSpecificAction(Enemy enemy, Character player, String strategy);

    // Aplicación de modificadores de estado
    protected String applyStateModifiers(Enemy enemy, String action) {
        // Implementación por defecto - puede ser extendida
        if (enemy.getHealth() < enemy.getMaxHealth() * 0.2) {
            action = "Desesperado: " + action;
        }
        return action;
    }

    // Registro de acciones
    protected void recordAction(Enemy enemy, String action) {
        // Implementación por defecto - puede ser extendida
        enemy.addToActionHistory(action);
    }
}