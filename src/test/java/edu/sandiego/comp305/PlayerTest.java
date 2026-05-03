package edu.sandiego.comp305;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void attack() {
    }

    @Test
    void takeDamage() {
        final Player player = new Player();
        player.health = 100;
        player.takeDamage(5);
        assertEquals(95, player.health);
    }


    @Test
    void heal() {
        final Player player = new Player("Isaac", 10, 0);
        player.heal(5);
        assertEquals(15, player.health);

    }

    @Test
    void buyItem() {
    }

    @Test
    void usePotion() {
    }

    @Test
    void equipWeapon() {
    }

    @Test
    void equipArmor() {
    }

    @Test
    void setAttackStrategy() {
    }

    @Test
    void isAliveTrue() {
        final Player player = new Player();
        assertEquals(100, player.health);
        assertTrue(player.isAlive());
    }

    @Test
    void isAliveFalse() {
        final Player player = new Player();
        player.takeDamage(100);
        assertFalse(player.isAlive());
    }
}
