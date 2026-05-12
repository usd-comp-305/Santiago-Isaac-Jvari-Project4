package edu.sandiego.comp305;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopTest {

    @Test
    void testBuyWeaponBoostWithEnoughGold() {
        final Shop shop = new Shop();
        final Player player = new Player("Test", 100, 20, 5);

        final boolean result = shop.buyWeaponBoost(player);

        assertTrue(result);
        assertTrue(player.getGold() < 20);
        assertNotNull(player.weapon);
        assertTrue(player.weapon.getAttackBoost() > 0);
    }

    @Test
    void testBuyWeaponBoostWithoutEnoughGold() {
        final Shop shop = new Shop();
        final Player player = new Player("Test", 100, 0, 5);

        final boolean result = shop.buyWeaponBoost(player);

        assertFalse(result);
        assertEquals(0, player.getGold());
    }

    @Test
    void testBuyArmorUpgradeWithEnoughGold() {
        final Shop shop = new Shop();
        final Player player = new Player("Test", 100, 20, 5);

        final int defenseBefore = player.getDefense();

        final boolean result = shop.buyArmorUpgrade(player);

        assertTrue(result);
        assertTrue(player.getGold() < 20);
        assertTrue(player.getDefense() > defenseBefore);
    }

    @Test
    void testBuyArmorUpgradeWithoutEnoughGold() {
        final Shop shop = new Shop();
        final Player player = new Player("Test", 100, 0, 5);

        final int defenseBefore = player.getDefense();

        final boolean result = shop.buyArmorUpgrade(player);

        assertFalse(result);
        assertEquals(0, player.getGold());
        assertEquals(defenseBefore, player.getDefense());
    }

    @Test
    void testBuyHealthPotionWithEnoughGold() {
        final Shop shop = new Shop();
        final Player player = new Player("Test", 100, 20, 5);
        final Potion potion = ItemFactory.createPotion(PotionType.HEALTH);

        final boolean result = shop.buyPotion(player, potion);

        assertTrue(result);
        assertTrue(player.getGold() < 20);
        assertEquals(1, player.inventory.size());
        assertTrue(player.inventory.get(0) instanceof HealthPotion);
    }

    @Test
    void testBuyStrengthPotionWithEnoughGold() {
        final Shop shop = new Shop();
        final Player player = new Player("Test", 100, 20, 5);
        final Potion potion = ItemFactory.createPotion(PotionType.STRENGTH);

        final boolean result = shop.buyPotion(player, potion);

        assertTrue(result);
        assertTrue(player.getGold() < 20);
        assertEquals(1, player.inventory.size());
        assertTrue(player.inventory.get(0) instanceof StrengthPotion);
    }

    @Test
    void testBuyPotionWithoutEnoughGold() {
        final Shop shop = new Shop();
        final Player player = new Player("Test", 100, 0, 5);
        final Potion potion = ItemFactory.createPotion(PotionType.HEALTH);

        final boolean result = shop.buyPotion(player, potion);

        assertFalse(result);
        assertEquals(0, player.getGold());
        assertEquals(0, player.inventory.size());
    }

    @Test
    void testWeaponPriceIncreasesAfterPurchase() {
        final Shop shop = new Shop();
        final Player player = new Player("Test", 100, 100, 5);

        final int priceBefore = shop.getWeaponPrice();

        shop.buyWeaponBoost(player);

        assertTrue(shop.getWeaponPrice() > priceBefore);
    }

    @Test
    void testArmorPriceIncreasesAfterPurchase() {
        final Shop shop = new Shop();
        final Player player = new Player("Test", 100, 100, 5);

        final int priceBefore = shop.getArmorPrice();

        shop.buyArmorUpgrade(player);

        assertTrue(shop.getArmorPrice() > priceBefore);
    }
}
