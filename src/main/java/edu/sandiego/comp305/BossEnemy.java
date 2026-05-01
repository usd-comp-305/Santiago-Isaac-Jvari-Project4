package edu.sandiego.comp305;

public class BossEnemy extends Enemy {

    public BossEnemy(String name,int health,int attackPower,int goldReward,String hint) {
        super(name, health, attackPower, goldReward, hint);
    }

    public void triggerDifficultyIncrease(Dungeon dungeon) {
        dungeon.increaseDifficulty();
    }
}
