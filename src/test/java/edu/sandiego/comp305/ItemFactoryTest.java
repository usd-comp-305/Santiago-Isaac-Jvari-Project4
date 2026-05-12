package edu.sandiego.comp305;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemFactoryTest {

    @Test
    void testCreateHealthPotionReturnsHealthPotion() {
        final Potion potion = ItemFactory.createPotion(PotionType.HEALTH);

        assertNotNull(potion);
        assertTrue(potion instanceof HealthPotion);
    }

    @Test
    void testCreateStrengthPotionReturnsStrengthPotion() {
        final Potion potion = ItemFactory.createPotion(PotionType.STRENGTH);

        assertNotNull(potion);
        assertTrue(potion instanceof StrengthPotion);
    }

    @Test
    void testHealthPotionHasCorrectEffect() {
        final Player player = new Player("Test", 50, 0, 5);
        final Potion potion = ItemFactory.createPotion(PotionType.HEALTH);

        final int healthBefore = player.getHealth();

        potion.applyEffect(player);

        assertTrue(player.getHealth() > healthBefore);
    }

    @Test
    void testStrengthPotionHasCorrectEffect() {
        final Player player = new Player("Test", 100, 0, 5);
        final Potion potion = ItemFactory.createPotion(PotionType.STRENGTH);

        if (player.weapon == null) {
            player.equipWeapon(new Weapon());
        }

        final int attackBoostBefore = player.weapon.getAttackBoost();

        potion.applyEffect(player);

        assertTrue(player.weapon.getAttackBoost() > attackBoostBefore);
    }

    @Test
    void testHealthPotionDoesNotCreateStrengthPotion() {
        final Potion potion = ItemFactory.createPotion(PotionType.HEALTH);

        assertFalse(potion instanceof StrengthPotion);
    }

    @Test
    void testStrengthPotionDoesNotCreateHealthPotion() {
        final Potion potion = ItemFactory.createPotion(PotionType.STRENGTH);

        assertFalse(potion instanceof HealthPotion);
    }
}

