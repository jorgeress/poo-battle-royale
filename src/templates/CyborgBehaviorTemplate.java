package templates;

import characters.Character;
import characters.Enemy;
import characters.Cyborg;

public class CyborgBehaviorTemplate extends EnemyBehaviorTemplate{

    @Override
    protected boolean canPerformAction(Enemy enemy) {
        boolean baseCheck = super.canPerformAction(enemy);

        // Los cyborgs también verifican su nivel de energía
        Cyborg cyborg = (Cyborg) enemy;
        return baseCheck && cyborg.getEnergy() > 0;
    }

    @Override
    protected void analyzeCombatSituation(Enemy enemy, Character player) {
        Cyborg cyborg = (Cyborg) enemy;

        // Los cyborgs escanean al jugador para detectar debilidades
        cyborg.scanTarget(player);

        // Ajustan sus sistemas basados en el escaneo
        if (cyborg.getTargetWeakness() != null) {
            cyborg.optimizeSystemsFor(cyborg.getTargetWeakness());
        }
    }

    @Override
    protected String chooseStrategy(Enemy enemy, Character player) {
        Cyborg cyborg = (Cyborg) enemy;

        // Los cyborgs eligen estrategia basada en análisis lógico y niveles de energía
        if (cyborg.getEnergy() < cyborg.getMaxEnergy() * 0.2) {
            return "RECHARGE";
        } else if (cyborg.getHealth() < cyborg.getMaxHealth() * 0.3) {
            return "REPAIR";
        } else if (cyborg.getTargetWeakness() != null) {
            return "EXPLOIT_WEAKNESS";
        } else if (cyborg.getEnergy() > cyborg.getMaxEnergy() * 0.8) {
            return "FULL_POWER";
        } else {
            return "STANDARD";
        }
    }

    @Override
    protected String determineSpecificAction(Enemy enemy, Character player, String strategy) {
        Cyborg cyborg = (Cyborg) enemy;

        // Dependiendo de la estrategia elegida, el cyborg realiza diferentes acciones
        switch (strategy) {
            case "RECHARGE":
                cyborg.setEnergy((int) (cyborg.getEnergy() + cyborg.getMaxEnergy() * 0.3));
                return "Recarga de energía";

            case "REPAIR":
                cyborg.consumeEnergy(20);
                cyborg.setHealth((int) (cyborg.getHealth() + cyborg.getMaxHealth() * 0.15));
                return "Autoreparación";

            case "EXPLOIT_WEAKNESS":
                cyborg.consumeEnergy(30);
                return "Ataque dirigido a " + cyborg.getTargetWeakness();

            case "FULL_POWER":
                cyborg.consumeEnergy(50);
                return "Sobrecarga de sistemas";

            case "STANDARD":
            default:
                if (Math.random() < 0.6) {
                    cyborg.consumeEnergy(10);
                    return "Láser de precisión";
                } else {
                    cyborg.consumeEnergy(5);
                    return "Puño metálico";
                }
        }
    }

    @Override
    protected String applyStateModifiers(Enemy enemy, String action) {
        String modifiedAction = super.applyStateModifiers(enemy, action);

        Cyborg cyborg = (Cyborg) enemy;

        // Si el cyborg tiene mejoras activas, modifica la acción
        if (cyborg.hasActiveUpgrades()) {
            modifiedAction = "Mejorado: " + modifiedAction;
        }

        // Si el cyborg está en modo de sobrecarga, puede dañarse a sí mismo
        if (cyborg.isOverclocked() && Math.random() < 0.2) {
            cyborg.setHealth((int) (cyborg.getHealth() - cyborg.getMaxHealth() * 0.05));
            modifiedAction = "Inestable: " + modifiedAction;
        }

        return modifiedAction;
    }

}
