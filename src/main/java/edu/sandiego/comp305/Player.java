package edu.sandiego.comp305;

import java.util.ArrayList;

public class Player {

    String name;

    int gold;

    int health;

    Weapon weapon;

    Armor armor;

    ArrayList<Item> inventory = new ArrayList<>();

    AttackStrategy attackStrategy;

    int attackPower;

    public Player(final String name, final int health, final int gold) {
        this.name = name;
        this.health = health;
        this.gold = gold;
        this.attackPower = 5;
    }

    public Player() {
        this.name = "Player";
        this.health = 100;
        this.gold = 0;
        this.attackPower = 5;
    }

    public void attack(final Enemy enemy) {
        int damage = attackPower;

        if (weapon != null) {
            damage += weapon.attackBoost;
        }

        if (attackStrategy != null) {
            damage = attackStrategy.executeAttack(damage);
        }

        enemy.takeDamage(damage);
    }

    public void takeDamage(final int damage){
        this.health -= damage;
    }

    public void heal (final int amount){
        this.health += amount;
    }

    public void addToInventory(final Item item){
        inventory.add(item);
    }

    public void usePotion(final Potion potion){
        potion.applyEffect(this);
    }

    public void equipWeapon(final Weapon weapon){
        this.weapon = weapon;
    }

    public void equipArmor(final Armor armor){
        this.armor = armor;
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

    public Armor getArmor() {
        return armor;
    }

    public AttackStrategy getAttackStrategy() {
        return attackStrategy;
    }

    public boolean isAlive(){
        if (health <= 0){
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

