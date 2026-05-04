package edu.sandiego.comp305;

public class BossEnemy extends Enemy {

    public BossEnemy(final String name, final int health,
            final int attackPower, final int goldReward, final String hint) {
        super(name, health, attackPower, goldReward, hint);
    }
    public void triggerDifficultyIncrease(final Dungeon dungeon) {
        dungeon.increaseDifficulty();
    }
}
