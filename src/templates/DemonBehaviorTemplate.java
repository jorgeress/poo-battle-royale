package templates;

import characters.Character;
import characters.Enemy;
import characters.Demon;


    public class DemonBehaviorTemplate extends EnemyBehaviorTemplate {

        @Override
        protected void analyzeCombatSituation(Enemy enemy, Character player) {
            // Análisis específico para demonios
            Demon demon = (Demon) enemy;

            // Ejemplo: Los demonios evalúan el nivel de vida del jugador para adaptar su estrategia
            demon.setAggressiveMode(player.getHealth() < player.getMaxHealth() * 0.3);
        }

        @Override
        protected String chooseStrategy(Enemy enemy, Character player) {
            Demon demon = (Demon) enemy;

            // Los demonios eligen estrategia basada en su propio estado de salud y el del jugador
            if (demon.getHealth() < demon.getMaxHealth() * 0.4) {
                return "DEFENSIVE";
            } else if (demon.isAggressiveMode()) {
                return "AGGRESSIVE";
            } else if (demon.getMana() > demon.getMaxMana() * 0.7) {
                return "MAGICAL";
            } else {
                return "BALANCED";
            }
        }

        @Override
        protected String determineSpecificAction(Enemy enemy, Character player, String strategy) {
            Demon demon = (Demon) enemy;

            // Dependiendo de la estrategia elegida, el demonio realiza diferentes acciones
            switch (strategy) {
                case "AGGRESSIVE":
                    if (demon.getMana() >= 30) {
                        demon.setMana(demon.getMana() - 30);
                        return "Ataque infernal";
                    } else {
                        return "Ataque demoníaco";
                    }
                case "DEFENSIVE":
                    if (demon.getMana() >= 25) {
                        demon.setMana(demon.getMana() - 25);
                        return "Escudo de fuego";
                    } else {
                        return "Posición defensiva";
                    }
                case "MAGICAL":
                    if (demon.getMana() >= 50) {
                        demon.setMana(demon.getMana() - 50);
                        return "Invocación del abismo";
                    } else if (demon.getMana() >= 35) {
                        demon.setMana(demon.getMana() - 35);
                        return "Maldición de debilidad";
                    } else {
                        return "Rayo oscuro";
                    }
                case "BALANCED":
                default:
                    if (Math.random() < 0.3 && demon.getMana() >= 20) {
                        demon.setMana(demon.getMana() - 20);
                        return "Garra sombría";
                    } else {
                        return "Ataque básico";
                    }
            }
        }

        @Override
        protected String applyStateModifiers(Enemy enemy, String action) {
            // Modificadores específicos para demonios además de los heredados
            String modifiedAction = super.applyStateModifiers(enemy, action);

            Demon demon = (Demon) enemy;

            // Si el demonio tiene un pacto demoníaco activo, potencia sus ataques
            if (demon.hasDemonicPact()) {
                modifiedAction = "Potenciado: " + modifiedAction;
            }

            return modifiedAction;
        }

        @Override
        protected void recordAction(Enemy enemy, String action) {
            // Registro específico para demonios
            super.recordAction(enemy, action);

            // Actualiza contador de acciones específicas para demonios
            Demon demon = (Demon) enemy;
            if (action.contains("Ataque infernal")) {
                demon.incrementHellAttackCount();
            }
        }
    }

