package edu.sandiego.comp305;

public class EnemyFactory {
    // add to this for every new enemy class/ boss class
    public Enemy createEnemy(String enemyType, int difficultyLevel) {
        Enemy enemy;

        if (enemyType.equalsIgnoreCase("slime")) {
            enemy = new Slime();
        } else if (enemyType.equalsIgnoreCase("zombie")) {
            enemy = new Zombie();
        } else if (enemyType.equalsIgnoreCase("skeleton")) {
            enemy = new Skeleton();
        } else {
            enemy = createBoss(enemyType);
        }

        enemy.increaseStats(difficultyLevel);
        return enemy;
    }

    private Enemy createBoss(String bossName) {
        if (bossName.equalsIgnoreCase("Lich")) {
            return new Lich();
        } else if (bossName.equalsIgnoreCase("Minotaur")) {
            return new Minotaur();
        } else if (bossName.equalsIgnoreCase("ZombieKing")) {
            return new ZombieKing();
        }

        throw new IllegalArgumentException("Unknown boss type");
    }
}

