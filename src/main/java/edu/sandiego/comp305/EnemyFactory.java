package edu.sandiego.comp305;

public class EnemyFactory {
    // add to this for every new enemy class/ boss class
    public Enemy createEnemy(String enemyType) {
        if (enemyType.equalsIgnoreCase("slime")) {
            return new Slime();
        } else if (enemyType.equalsIgnoreCase("zombie")) {
            return new Zombie();
        } else if (enemyType.equalsIgnoreCase("skeleton")) {
            return new Skeleton();
        } else if (enemyType.equalsIgnoreCase("Lich")) {
            return new BossEnemy();
        }

        throw new IllegalArgumentException("Unknown enemy type");
    }

    public Enemy createEnemy(String enemyType, int difficultyLevel) {
        Enemy enemy = createEnemy(enemyType);

        enemy.increaseStats(difficultyLevel);

        return enemy;
    }
}

