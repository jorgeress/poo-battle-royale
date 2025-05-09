package utils;

import characters.Character; 


public class DamageCalculator {
	private static DamageCalculator instance;

    private DamageCalculator() {}

    public static DamageCalculator getInstance() {
        if (instance == null) {
            instance = new DamageCalculator();
        }
        return instance;
    }

    // Método clásico para obtener el daño calculado
    public int calculate(Character attacker, Character defender) {
        int baseDamage = attacker.getStrength();
        int defense = defender.getDefense();
        return Math.max(0, baseDamage - defense);
    }

    // Método nuevo que aplica el daño directamente y gestiona efectos como reflejo
    public void applyDamage(Character attacker, Character defender) {
        int damage = calculate(attacker, defender);
        
        // Reflejo de daño
        if (defender.isReflecting() && attacker != null) {
            int reflectedDamage = damage; 
            attacker.takeDamage(reflectedDamage);
            System.out.println(defender.getName() + " refleja " + reflectedDamage + " de daño a " + attacker.getName());
            defender.setReflecting(false); 
        }
        else {
        	defender.takeDamage(damage);  // Método sugerido para claridad en vez de modificar `health` directamente
            System.out.println(defender.getName() + " recibe " + damage + " de daño.");

        }
    }
}

// GITHUB
