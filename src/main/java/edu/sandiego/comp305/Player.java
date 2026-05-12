package edu.sandiego.comp305;

import java.util.ArrayList;

public class Player {

    private static final int MAX_HEALTH = 100;

    private static final String DEFAULT_NAME = "Player";

    private static final int DEFAULT_HEALTH = 100;

    private static final int DEFAULT_GOLD = 0;

    private static final int DEFAULT_ATTACK_POWER = 5;

    private static final int DEFAULT_DEFENSE = 0;

    private static final int NO_BONUS = 0;

    private static final int MIN_HEALTH = 0;

    String name;

    int gold;

    int health;

    Weapon weapon;

    int defense;

    ArrayList<Item> inventory = new ArrayList<>();

    AttackStrategy attackStrategy;

    int attackPower;

    public Player(final String name,
                  final int health,
                  final int gold,
                  final int attackPower) {
        this.name = name;
        this.health = health;
        this.gold = gold;
        this.attackPower = attackPower;
        this.defense = DEFAULT_DEFENSE;
    }

    public Player() {
        this.name = DEFAULT_NAME;
        this.health = DEFAULT_HEALTH;
        this.gold = DEFAULT_GOLD;
        this.attackPower = DEFAULT_ATTACK_POWER;
    }


    public void attack(final Enemy enemy) {
        int damage = attackPower;

        if (weapon != null) {
            damage += weapon.getAttackBoost();
        }

        if (attackStrategy != null) {
            damage = attackStrategy.executeAttack(damage);
        }
        enemy.takeDamage(damage);

    }

    public void takeDamage(final int damage){
        int reducedDamage = damage - defense;

        if (reducedDamage < NO_BONUS) {
            reducedDamage = NO_BONUS;
        }

        health -= reducedDamage;

        if (health < MIN_HEALTH) {
            health = MIN_HEALTH;
        }
    }

    public void heal (final int amount){
        health += amount;

        if (health > MAX_HEALTH) {
            health = MAX_HEALTH;
        }
    }

    public void addToInventory(final Item item){
        inventory.add(item);
    }

    public void usePotion(final Potion potion){
        if (potion == null) {
            return;
        }

        potion.applyEffect(this);
        inventory.remove(potion);
    }

    public void equipWeapon(final Weapon weapon){
        final Weapon copy = new Weapon();
        copy.setAttackBoost(weapon.getAttackBoost());
        this.weapon = copy;

    }

    public void setAttackStrategy(final AttackStrategy strategy){
        this.attackStrategy = strategy;
    }

    public int getGold() {
        return gold;
    }

    public void increaseGold(final int amount){
        this.gold += amount;
    }

    public void  decreaseGold(final int amount){
        this.gold -= amount;
    }

    public void increaseDefense(final int amount) {
        defense += amount;
    }

    public int getDefense() {
        return defense;
    }

    public AttackStrategy getAttackStrategy() {
        return attackStrategy;
    }

    public boolean isAlive(){
        if (health <= MIN_HEALTH){
            return false;
        }
        return true;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackPower() {
        return attackPower;
    }
}

