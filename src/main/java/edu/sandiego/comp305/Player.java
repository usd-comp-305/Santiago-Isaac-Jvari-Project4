package edu.sandiego.comp305;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Player {

    private String name;

    private int gold;

    private int health;

    private Weapon weapon;

    private Armor armor;

    private ArrayList<Item> inventory = new ArrayList<>();

    private AttackStrategy attackStrategy;

    private int attackPower;

    public Player(final String name,
                  final int health,
                  final int gold,
                  final int attackPower) {
        this.name = name;
        this.health = health;
        this.gold = gold;
        this.attackPower = attackPower;
    }

    public Player() {
        this.name = "Player";
        this.health = 100;
        this.gold = 0;
        this.attackPower = 5;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
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
        this.health -= damage;
    }

    public void heal (final int amount){
        this.health += amount;
    }

    public void addToInventory(final Item item){
        inventory.add(item);
    }

    public boolean hasInInventory(final Item item){
        return inventory.contains(item);
    }

    public List<Item> getInventory(){
        return Collections.unmodifiableList(inventory);
    }

    public void usePotion(final Potion potion){
        potion.applyEffect(this);
    }

    public void equipWeapon(final Weapon weapon){
        final Weapon copy = new Weapon();
        copy.setAttackBoost(weapon.getAttackBoost());
        copy.setTier(weapon.getTier());
        this.weapon = copy;
    }

    public Weapon getWeapon() {
        if (weapon == null) {
            return null;
        }
        final Weapon copy = new Weapon();
        copy.setAttackBoost(weapon.getAttackBoost());
        copy.setTier(weapon.getTier());
        return copy;
    }

    public void equipArmor(final Armor armor){
        final Armor copy = new Armor();
        copy.setDefenseBoost(armor.getDefenseBoost());
        this.armor = copy;
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
        if (armor == null) {
            return null;
        }
        final Armor copy = new Armor();
        copy.setDefenseBoost(armor.getDefenseBoost());
        return copy;

    }

    public void boostWeapon(final int amount){
        if(weapon != null) {
            weapon.setAttackBoost(weapon.getAttackBoost() + amount);
        }
    }

    public AttackStrategy getAttackStrategy() {
        return attackStrategy;
    }

    public boolean isAlive(){
        return health > 0;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(final int health) {
        this.health = health;
    }

    public int getAttackPower() {
        return attackPower;
    }
}

