package edu.sandiego.comp305;

public abstract class Enemy {

    private static final int DEFENSE_BONUS_AMOUNT = 5;

    private static final int RAGE_ATTACK_BONUS = 5;

    private static final int HEALTH_INCREASE_PER_DIFFICULTY = 10;

    private static final int ATTACK_INCREASE_PER_DIFFICULTY = 3;

    private static final int GOLD_INCREASE_PER_DIFFICULTY = 5;

    private static final int NO_BONUS = 0;

    private static final int MIN_HEALTH = 0;

    private final int maxHealth;

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
        this.maxHealth = health;

    }

    public void attack(final Player player) {
        int damage = attackPower + attackBonus;

        if (attackStrategy != null) {
            damage = attackStrategy.executeAttack(damage);
        }

        player.takeDamage(damage);

        attackBonus = NO_BONUS;
    }

    public void takeDamage(final int amount) {
        int reducedDamage = amount - defenseBonus;

        if (reducedDamage < NO_BONUS) {
            reducedDamage = NO_BONUS;
        }

        health -= reducedDamage;

        if (health < MIN_HEALTH) {
            health = MIN_HEALTH;
        }
        defenseBonus = NO_BONUS;
    }

    public boolean isAlive() {
        return getHealth() != MIN_HEALTH;
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
        defenseBonus = DEFENSE_BONUS_AMOUNT;
    }

    public void rage() {
        attackBonus = RAGE_ATTACK_BONUS;
    }

    public int getMaxHealth(){
        return maxHealth;
    }

    public void increaseStats(final int difficultyLevel) {
        health += difficultyLevel * HEALTH_INCREASE_PER_DIFFICULTY;
        attackPower += difficultyLevel * ATTACK_INCREASE_PER_DIFFICULTY;
        goldReward += difficultyLevel * GOLD_INCREASE_PER_DIFFICULTY;
    }

}
