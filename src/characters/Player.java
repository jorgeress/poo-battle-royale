package characters;

import actions.*;
import utils.StatAllocator;

import java.util.Scanner;

public class Player extends Character {

    public Player() {
        super(
            StatAllocator.allocate("Vida", 70, 100),
            StatAllocator.allocate("Fuerza", 20, 60),
            StatAllocator.allocateRemaining("Defensa", 0, 30),
            StatAllocator.chooseName(),
            50
        );
    }

    @Override
    public void act(Character target) {
        Scanner scanner = new Scanner(System.in);
        ActionComponent chosenAction = null;

        while (chosenAction == null) {
            System.out.println("\nElige una acción:");
            System.out.println("1. Atacar");
            System.out.println("2. Defender");

            String input = scanner.nextLine().trim();

            switch (input) {
                case "1" -> chosenAction = new BasicAttackComponent();
                case "2" -> chosenAction = new BasicDefenseComponent();
                default -> System.out.println("Opción inválida. Intenta de nuevo.");
            }
        }

        chosenAction.perform(this, target);
    }
}

