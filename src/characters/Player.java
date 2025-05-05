package characters;

import actions.*;
import java.util.Scanner;

public class Player extends Character {

    public Player() {
        super(5150, 80, 10, "Dingolingo", 50);
    }

    @Override
    public void act(Character target) {
        Scanner scanner = new Scanner(System.in);
        ActionComponent chosenAction = null;

        while (chosenAction == null) {
            System.out.println("\nElige una acción:");
            System.out.println("1. Atacar\n");
            System.out.println("2. Defender\n");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    chosenAction = new BasicAttackComponent();
                    break;
                case "2":
                    chosenAction = new BasicDefenseComponent();
                    break;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }
        }

        chosenAction.perform(this, target);
    }
}