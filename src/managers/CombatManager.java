package managers;

import characters.*;
import utils.PowerUp;
import utils.PowerUpGenerator;
import utils.TurnDecider;

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
        TurnDecider.FirstTurn firstTurn = TurnDecider.decideFirstTurn();
        announceFirstTurn(firstTurn);

        while (player.isAlive() && enemy.isAlive()) {
            updateStates();
            executeTurnOrder(firstTurn);
            printStatus();
        }

        announceWinner();
    }
    private void announceFirstTurn(TurnDecider.FirstTurn firstTurn) {
        System.out.println("\nLanzando una moneda...");
        System.out.println(firstTurn == TurnDecider.FirstTurn.PLAYER
            ? "¡El jugador comienza!"
            : "¡El enemigo comienza!");
    }

    private void executeTurnOrder(TurnDecider.FirstTurn firstTurn) {
        if (firstTurn.equals(TurnDecider.FirstTurn.PLAYER)) {
            performPlayerTurn();
            if (enemy.isAlive()) performEnemyTurn();
        } else {
            performEnemyTurn();
            if (player.isAlive()) performPlayerTurn();
        }
    }

    private void performPlayerTurn() {
        System.out.println("\n--- Turno de " + player.getName() + " ---");
        player.setReflecting(false);
        player.performTurn(enemy);
    }

    private void performEnemyTurn() {
        System.out.println("\n--- Turno de " + enemy.getName() + " ---");
        enemy.setReflecting(false);
        enemy.performTurn(player);
    }

    private void announceWinner() {
        if (!enemy.isAlive()) {
            System.out.println(enemy.getName() + " ha sido derrotado.");
            PowerUp powerUp = PowerUpGenerator.generateRandomPowerUp();
            powerUp.apply(player);  // El jugador recibe el power-up
            enemy.rewardPlayer(player);
            player.recoverPostBattle();

        } else {
            System.out.println(player.getName() + " ha sido derrotado.");
            printFinalStatus();
            
        }
    }

 // Mostrar el puntaje final al terminar la partida
    private void printFinalStatus() {
        System.out.println("\n--- Fin del Combate ---");
        player.displayFinalScore();
    }
    private void updateStates() {
        player.updateStates();
        enemy.updateStates();
    }

    private void printStatus() {
        System.out.println("\n[Estado]");
        System.out.println(player.getName() + " - HP: " + player.getHealth() + " - Estado: " + player.getState().getName());
        System.out.println(enemy.getName() + " - HP: " + enemy.getHealth() + " - Estado: " + enemy.getState().getName());
    }
    
}