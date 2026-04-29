package edu.sandiego.comp305;

public class EnemyFactory {

    public Enemy createEnemy(String type) {
        if (type.equalsIgnoreCase("slime")) {
            return new Slime();
        } else if (type.equalsIgnoreCase("zombie")) {
            return new Zombie();
        } else if (type.equalsIgnoreCase("skeleton")) {
            return new Skeleton();
        } else {
            throw new IllegalArgumentException("Unknown enemy type");
        }
    }

    public BossEnemy createBoss() {
        return new BossEnemy();
    }
}

