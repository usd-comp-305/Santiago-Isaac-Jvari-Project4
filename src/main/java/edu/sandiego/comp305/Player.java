package edu.sandiego.comp305;

import java.util.ArrayList;

public class Player {

    String name;

    int health;

    int gold;

    Weapon weapon;

    Armor armor;

    ArrayList<Item> inventory;

    AttackStrategy attackStrategy;

    public Player(final String name, final int health, final int gold) {
        this.name = name;
        this.health = health;
        this.gold = gold;
    }

    public Player() {
        this.name = "Player";
        this.health = 100;
        this.gold = 0;
    }

    public void attack(final Enemy enemy, final int damage){
//        enemy.takeDamage(damage);
    }

    public void takeDamage(final int damage){
        this.health -= damage;
    }

    public void heal (final int amount){
        this.health += amount;
    }

    public void buyItem(final Item item){

    }

    public void usePotion(final Potion potion){
    }

    public void equipWeapon(final Weapon weapon){

    }

    public void equipArmor(final Armor armor){

    }

    public void setAttackStrategy(final AttackStrategy strategy){

    }

    public boolean isAlive(){
        if (health <= 0){
            return false;
        }
        return true;
    }

}
