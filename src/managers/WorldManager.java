package managers;

import characters.Enemy;
import factories.*;

public class WorldManager {

    private int currentEnemyIndex;
    private final EnemyAbstractFactory factory;

    public WorldManager() {
        this.currentEnemyIndex = 0;
        this.factory = new World1AbstractFactory(); // Podrías cambiar dinámicamente el mundo
    }

    public boolean hasNextEnemy() {
        // Supongamos que hay 3 enemigos por mundo (ajusta según necesidad)
        return currentEnemyIndex < 3;
    }

    public Enemy getNextEnemy() {
        Enemy enemy = null;
        switch (currentEnemyIndex) {
            case 0:
                enemy = factory.createDemon();
                break;
            case 1:
                enemy = factory.createCyborg();
                break;
            case 2:
                enemy = factory.createMutant();
                break;
            // Podrías añadir más casos o controlar por configuración externa
        }
        currentEnemyIndex++;
        return enemy;
    }
}
