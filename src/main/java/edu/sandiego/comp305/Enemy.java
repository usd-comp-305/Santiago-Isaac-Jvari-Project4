package edu.sandiego.comp305;

public abstract class Enemy {

    public String name;

    public String hint;

    protected int health;

    protected int attackPower;

    protected int goldReward;

    protected AttackStrategy attackStrategy;

    protected EnemyBehaviorStrategy behaviorStrategy;

    protected int defenseBonus = 0;

    protected int attackBonus = 0;

    public Enemy(final String name, final int health,
            final int attackPower, final int goldReward, final String hint) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.goldReward = goldReward;
        this.hint = hint;

    }

    public void attack(final Player player) {
        int damage = attackPower + attackBonus;;

        if (attackStrategy != null) {
            damage = attackStrategy.executeAttack(damage);
        }

        player.takeDamage(damage);

        attackBonus = 0;
    }

    public void takeDamage(final int amount) {
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
        return getHealth() != 0;
    }

    public String getHint() {
        return hint;
    }

    public int getHealth() {
        return health;
    }

    public void setAttackStrategy(final AttackStrategy strategy) {
        attackStrategy = strategy;
    }

    public void setBehaviorStrategy(final EnemyBehaviorStrategy strategy) {
        behaviorStrategy = strategy;
    }

    public EnemyBehaviorStrategy getBehaviorStrategy() {
        return behaviorStrategy;
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

    public void rage() {
        attackBonus = 5;
    }

    public void increaseStats(final int difficultyLevel) {
        health += difficultyLevel * 5;
        attackPower += difficultyLevel * 2;
        goldReward += difficultyLevel * 3;
    }

}
