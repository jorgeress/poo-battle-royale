package utils;


import java.util.Random;

public class PowerUpGenerator {

    private static final Random random = new Random();

    public static PowerUp generateRandomPowerUp() {
        PowerUp.StatType[] types = PowerUp.StatType.values();
        int index = random.nextInt(types.length);
        return new PowerUp(types[index]);
    }
}