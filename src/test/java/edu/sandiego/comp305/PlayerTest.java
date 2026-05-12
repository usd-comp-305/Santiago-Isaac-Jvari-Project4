package edu.sandiego.comp305;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @Test
    void attack() {
        final Player player = new Player("Isaac", 10, 0, 30);
        final EnemyFactory factory = new EnemyFactory();
        final Enemy enemy = factory.createEnemy("slime",0);
        assertEquals(30,enemy.health);
        player.attack(enemy);
        assertEquals(0,enemy.health);
    }

    @Test
    void takeDamage() {
        final Player player = new Player();
        player.setHealth(100);
        player.takeDamage(5);
        assertEquals(95, player.getHealth());
    }


    @Test
    void heal() {
        final Player player = new Player("Isaac", 10, 0,10);
        player.heal(5);
        assertEquals(15, player.getHealth());

    }

    @Test
    void testGetGold() {
        final int gold = 10;
        final Player player = new Player("Isaac", 10, gold,10);
        assertEquals(gold, player.getGold());

    }

    @Test
    void testIncreaseGold() {
        final Player player = new Player("Isaac", 10, 0,10);
        player.increaseGold(10);
        assertEquals(10, player.getGold());
    }

    @Test
    void testDecreaseGold() {
        final Player player = new Player("Isaac", 10, 10,10);
        player.decreaseGold(10);
        assertEquals(0, player.getGold());
    }


    @Test
    void useHealthPotion() {
        final Player player = new Player("Isaac", 10, 0,10);
        final Potion health = ItemFactory.createPotion(PotionType.HEALTH);
        final int expectedHealth = 40;
        player.usePotion(health);
        assertEquals(expectedHealth, player.getHealth());
    }

    @Test
    void addToInventory() {
        final Player player = new Player("Isaac", 10, 0,10);
        final Potion health = ItemFactory.createPotion(PotionType.HEALTH);
        player.addToInventory(health);
        assertTrue(player.hasInInventory(health));
    }

    @Test
    void equipWeapon() {
        final Player player = new Player("Isaac", 10, 0,10);
        final Weapon sword = ItemFactory.createSwordWeapon(1);
        player.equipWeapon(sword);
        assertEquals(sword.getAttackBoost(),
                player.getWeapon().getAttackBoost());
        assertEquals(sword.getTier(),
                player.getWeapon().getTier());
    }

    @Test
    void equipArmor() {
        final Player player = new Player("Isaac", 10, 0,10);
        final Armor armor = ItemFactory.createArmor(1);
        player.equipArmor(armor);
        assertEquals(armor.getDefenseBoost(),
                player.getArmor().getDefenseBoost());
    }

    @Test
    void getArmor() {
        final Player player = new Player("Isaac", 10, 0,10);
        final Armor armor = ItemFactory.createArmor(1);
        player.equipArmor(armor);
        assertEquals(armor.getDefenseBoost(),
                player.getArmor().getDefenseBoost());
    }

    @Test
    void setAttackStrategy() {
        final Player player = new Player("Isaac", 10, 0,10);
        final AttackStrategy strategy = new BasicAttack();
        player.setAttackStrategy(strategy);
        assertEquals(strategy, player.getAttackStrategy());

    }

    @Test
    void getAttackStrategy(){
        final Player player = new Player("Isaac", 10, 0,10);
        final AttackStrategy strategy = new BasicAttack();
        player.setAttackStrategy(strategy);
        assertTrue(strategy == player.getAttackStrategy());
    }

    @Test
    void isAliveTrue() {
        final Player player = new Player();
        assertEquals(100, player.getHealth());
        assertTrue(player.isAlive());
    }

    @Test
    void isAliveFalse() {
        final Player player = new Player();
        player.takeDamage(100);
        assertFalse(player.isAlive());
    }
}
