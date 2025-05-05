package controller;

import characters.*;
import managers.CombatManager;
import managers.WorldManager;

public class GameController {

    private Player player;
    private CombatManager combatManager;
    private WorldManager worldManager;

    public GameController() {
        this.player = new Player();
        this.combatManager = new CombatManager(player);
        this.worldManager = new WorldManager();
    }

    public void startGame() {
        System.out.println("¡Bienvenido al combate!");

        while (player.isAlive() && worldManager.hasNextEnemy()) {
            Enemy enemy = worldManager.getNextEnemy();
            System.out.println("\nAparece un nuevo enemigo: " + enemy.getName());

            combatManager.setEnemy(enemy);
            combatManager.runCombat();

            if (!player.isAlive()) {
                System.out.println("\nHas sido derrotado...");
                return;
            }
        }

        System.out.println("\n¡Has completado todos los combates del mundo!");
    }
}

