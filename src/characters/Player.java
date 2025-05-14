package characters;

import actions.*;
import utils.StatAllocator;

import java.util.Scanner;

public class Player extends Character {

    private int puntos; // Puntos obtenidos por derrotar enemigos.
    private static final int MAX_HEALTH = 100;  // Máximo de vida
    private static final int MAX_STAMINA = 50;  // Máxima stamina

    public Player() {
        super(
            StatAllocator.allocate("Vida", 70, MAX_HEALTH),
            StatAllocator.allocate("Fuerza", 20, 60),
            StatAllocator.allocateRemaining("Defensa", 0, 30),
            StatAllocator.chooseName(),
            50
        );
        this.puntos = 0;  // Inicialmente no tiene puntos
    }

    // Método para recuperar vida y stamina después de cada combate
    public void recoverPostBattle() {
        System.out.println("¡Recuperas salud y stamina!");
        this.setHealth(Math.min(this.getHealth() + 20, MAX_HEALTH)); // Recuperar 20 de vida, no superar el máximo.
        this.setStamina(Math.min(this.getStamina() + 30, MAX_STAMINA)); // Recuperar 10 de stamina, no superar el máximo.
    }

    public void addPoints(int points) {
        this.puntos += points;
    }

    public int getPuntos() {
        return this.puntos;
    }

    @Override
    public void act(Character target) {
        Scanner scanner = new Scanner(System.in);
        ActionComponent chosenAction = null;

        while (chosenAction == null) {
            System.out.println("\nElige una acción:");
            System.out.println("1. Ataque básico");
            System.out.println("2. Defender");
            System.out.println("3. Ataque paralizador (10 stamina)");
            System.out.println("4. Ataque quemador (10 stamina)");
            System.out.println("5. Ataque venenoso (10 stamina)");


            String input = scanner.nextLine().trim();

            switch (input) {
                case "1" -> chosenAction = new BasicAttackComponent();
                case "2" -> chosenAction = new BasicDefenseComponent();
                case "3" -> {
                    if (getStamina() >= 10) {
                        chosenAction = new ParalyzingAttackDecorator(new BasicAttackComponent());
                    } else {
                        System.out.println("No tienes suficiente stamina.");
                    }
                }
                case "4" -> {
                    if (getStamina() >= 10) {
                        chosenAction = new BurningAttackDecorator(new BasicAttackComponent());
                    } else {
                        System.out.println("No tienes suficiente stamina.");
                    }
                }
                case "5" -> {
                    if (getStamina() >= 10) {
                        chosenAction = new PoisoningAttackDecorator(new BasicAttackComponent());
                    } else {
                        System.out.println("No tienes suficiente stamina.");
                    }
                }
                default -> System.out.println("Opción inválida. Intenta de nuevo.");
            }
        }

        chosenAction.perform(this, target);
    }

    // Mostrar puntos al final del juego
    public void displayFinalScore() {
        System.out.println("Puntos conseguidos: " + this.puntos);
    }
}
