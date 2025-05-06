package managers;

import characters.*;

public class CombatManager {

    private Player player;
    private Enemy enemy;

    public CombatManager(Player player) {
        this.player = player;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public void runCombat() {
        while (player.isAlive() && enemy.isAlive()) {
            updateStates();

            System.out.println("\n--- Turno del Jugador ---");

            player.performTurn(enemy);

            if (enemy.isAlive()) {
                System.out.println("\n--- Turno de " + enemy.getName() + " ---");
                enemy.performTurn(player);
            }

            printStatus();
        }

        if (!enemy.isAlive()) {
            System.out.println(enemy.getName() + " ha sido derrotado.");
        }
    }

    private void updateStates() {
        player.updateStates();
        enemy.updateStates();
    }

    private void printStatus() {
        System.out.println("\n[Estado]");
        System.out.println(player.getName() + " - HP: " + player.getHealth() + " - Estado: " + player.getState().getClass().getSimpleName());
        System.out.println(enemy.getName() + " - HP: " + enemy.getHealth() + " - Estado: " + enemy.getState().getClass().getSimpleName());
    }
}