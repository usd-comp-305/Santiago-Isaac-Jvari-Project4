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

    public Player(String name, int health, int gold) {
        this.name = name;
        this.health = health;
        this.gold = gold;
    }
    public Player() {
        this.name = "Player";
        this.health = 100;
        this.gold = 0;
    }
    public void attack(Enemy enemy, int damage){
//        enemy.takeDamage(damage);
    }
    public void takeDamage(int damage){
        this.health -= damage;
    }
    public void heal (int amount){
        this.health += amount;
    }
    public void buyItem(Item item){

    }
    public void usePotion(Potion potion){
    }
    public void equipWeapon(Weapon weapon){

    }
    public void equipArmor(Armor armor){

    }
    public void setAttackStrategy(AttackStrategy strategy){

    }
    public boolean isAlive(){
        if (health <= 0){
            return false;
        }
        return true;
    }

}