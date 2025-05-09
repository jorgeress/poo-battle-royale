package utils;


import characters.Player;

public class PowerUp {
    public enum StatType {
        HEALTH(30), STRENGTH(10), DEFENSE(5), STAMINA(20);

        private final int increment;

        StatType(int increment) {
            this.increment = increment;
        }

        public void applyTo(Player player) {
            switch (this) {
                case HEALTH:
                    player.setHealth(player.getHealth() + increment);
                    break;
                case STRENGTH:
                    player.setStrength(player.getStrength() + increment);
                    break;
                case DEFENSE:
                    player.setDefense(player.getDefense() + increment);
                    break;
                case STAMINA:
                    player.setStamina(player.getStamina() + increment);
                    break;
            }

            System.out.println("¡Power-Up conseguido! " + this + " aumentada en " + increment + ".");
        }
    }

    private final StatType type;

    public PowerUp(StatType type) {
        this.type = type;
    }

    public void apply(Player player) {
        type.applyTo(player);
    }
}
