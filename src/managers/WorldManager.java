package managers;

import characters.Enemy;

import factories.*;


public class WorldManager {

    private int currentWorldIndex;
    private int currentEnemyIndex;

    private EnemyAbstractFactory currentFactory;

    public WorldManager() {
        this.currentWorldIndex = 1; // Empieza en el mundo 1
        this.currentEnemyIndex = 0;
        this.currentFactory = new World1AbstractFactory();
    }

    public boolean hasNextEnemy() {
        // Solo 3 enemigos por mundo y 3 mundos en total
        return !(currentWorldIndex > 3);
    }

    public Enemy getNextEnemy() {
        if (!hasNextEnemy()) return null;

        Enemy enemy = null;

        switch (currentEnemyIndex) {
            case 0:
                enemy = currentFactory.createDemon();
                break;
            case 1:
                enemy = currentFactory.createCyborg();
                break;
            case 2:
                enemy = currentFactory.createMutant();
                break;
            default:
                break;
        }

        currentEnemyIndex++;

        if (currentEnemyIndex >= 3) {
            // Avanza al siguiente mundo
            currentEnemyIndex = 0;
            currentWorldIndex++;

            // Cambiar fábrica dependiendo del nuevo mundo
            switch (currentWorldIndex) {
                case 2:
                    currentFactory = new World2AbstractFactory();
                    break;
                case 3:
                	currentFactory = new World3AbstractFactory();
                    break;
                default:
                    break; // si hay más mundos, añádelos aquí
            }
        }

        return enemy;
    }
}
