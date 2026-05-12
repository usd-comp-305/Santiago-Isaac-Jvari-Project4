package edu.sandiego.comp305;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopTest {

    @Test
    void displayItems() {
    }

    @Test
    void buyWeaponUpgrade() {
        final Shop shop = new Shop();
        final ShopService shopService = new ShopService(shop);
        final Player player = new Player("Isaac", 10, 10, 10);

        final Weapon sword = ItemFactory.createSwordWeapon(1);
        player.equipWeapon(sword);

        final boolean result = shopService.buyWeaponBoost(player,10,10);

        assertTrue(result);
        assertEquals(0, player.getGold());
        assertEquals(20, player.getWeapon().getAttackBoost());
    }

    @Test
    void buyWeaponUpGradeNoWeapon() {
        final Shop shop = new Shop();
        final ShopService shopService = new ShopService(shop);
        final Player player = new Player("Isaac", 10, 10, 10);
        assertTrue(player.getGold() == 10);
        assertFalse(shopService.buyWeaponBoost(player,10,10));
        assertTrue(player.getGold() == 10);
    }

    @Test
    void buyArmorUpGrade() {
        final Shop shop = new Shop();
        final ShopService shopService = new ShopService(shop);
        final Player player = new Player("Isaac", 10, 10, 10);
        final Armor armor = ItemFactory.createArmor(1);
        shopService.buyArmorUpgrade(player, armor, 10);
    }

    @Test
    void buyPotionHealth() {
        final Shop shop = new Shop();
        final ShopService shopService = new ShopService(shop);
        final Player player = new Player("Isaac", 10, 10, 10);
        final Potion health = ItemFactory.createPotion(PotionType.HEALTH);
        shop.addItem(health);
        shopService.buyItem(player, health);
    }

}
