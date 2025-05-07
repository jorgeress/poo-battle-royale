package utils;


import java.util.Random;

public class TurnDecider {

    public enum FirstTurn {
        PLAYER, ENEMY
    }

    private static final Random random = new Random();

    public static FirstTurn decideFirstTurn() {
        boolean playerStarts = random.nextBoolean();
        if (playerStarts) {
            return FirstTurn.PLAYER;
        } else {
            return FirstTurn.ENEMY;
        }
    }
}
