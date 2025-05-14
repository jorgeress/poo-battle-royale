package utils;

import java.util.Scanner;

public class StatAllocator {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Integer TOTAL_POINTS = 120;
    private static Integer remainingPoints = TOTAL_POINTS;

    public static Integer allocate(String statName, Integer min, Integer max) {
        while (true) {
            System.out.println("Reparte tus estadísticas (Total disponible: " + remainingPoints + " puntos)");
            System.out.printf("%s (mín %d, máx %d): ", statName, min, max);

            String input = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(input);
                if (value >= min && value <= max && value <= remainingPoints) {
                    remainingPoints -= value;
                    return value;
                }
            } catch (NumberFormatException e) {
                
            }
            System.out.println("Valor inválido o puntos insuficientes. Intenta de nuevo.");
        }
    }

    public static Integer allocateRemaining(String statName, Integer min, Integer max) {
        System.out.printf("%s asignado automáticamente con %d puntos restantes.\n", statName, remainingPoints);
        if (remainingPoints < min || remainingPoints > max) {
            System.out.println("¡Error! Los puntos restantes no encajan con los límites permitidos.");
            System.exit(1);
        }
        return remainingPoints;
    }
    public static String chooseName() {
        while (true) {
            System.out.print("Elige el nombre de tu personaje: ");
            String name = scanner.nextLine().trim();

            if (!name.isEmpty() && name.length() <= 20) {
                return name;
            }
            System.out.println("Nombre inválido. Debe tener entre 1 y 20 caracteres.");
        }
    }
}
