package edu.sandiego.comp305;

public abstract class Enemy {
    public String name;
    public int health;
    public int attackPower;
    public int goldReward;
    public String hint;
    public AttackStrategy attackStrategy;
    public EnemyBehaviorStrategy behaviorStrategy;
    public int defenseBonus = 0;

    public Enemy(String name, int health, int attackPower, int goldReward, String hint) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.goldReward = goldReward;
        this.hint = hint;

    }

    public void attack(Player player) {
        // TODO
    }

    public void takeDamage(int amount) {
        int reducedDamage = amount - defenseBonus;

        if (reducedDamage < 0) {
            reducedDamage = 0;
        }

        health -= reducedDamage;

        if (health < 0) {
            health = 0;
        }
        defenseBonus = 0;
    }

    public boolean isAlive() {
        if (getHealth() == 0) {
            return false;
        }
        else{
            return true;
        }
    }

    public String getHint() {
        return hint;
    }

    public int getHealth() {

        return health;
    }

    public void setAttackStrategy(AttackStrategy strategy) {

        attackStrategy = strategy;
    }

    public void setBehaviorStrategy(EnemyBehaviorStrategy strategy) {
        behaviorStrategy = strategy;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getGoldReward() {
        return goldReward;
    }

    public String getName() {
        return name;
    }

    public void defend() {
        defenseBonus = 5;
    }


}