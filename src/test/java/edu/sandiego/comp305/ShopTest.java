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
        final Player player = new Player("Isaac", 10, 10, 10);

        final Weapon sword = ItemFactory.createSwordWeapon(1);
        player.equipWeapon(sword);

        final boolean result = shop.buyWeaponBoost(10, 10, player);

        assertTrue(result);
        assertEquals(0, player.getGold());
        assertEquals(20, player.getWeapon().getAttackBoost());
    }

    @Test
    void buyWeaponUpGradeNoWeapon() {
        final Shop shop = new Shop();
        final Player player = new Player("Isaac", 10, 10, 10);
        assertTrue(player.getGold() == 10);
        assertFalse(shop.buyWeaponBoost(10, 10, player));
        assertTrue(player.getGold() == 10);
    }

    @Test
    void buyArmorUpGrade() {
        final Shop shop = new Shop();
        final Player player = new Player("Isaac", 10, 10, 10);
        final Armor armor = ItemFactory.createArmor(1);
        shop.buyArmorUpgrade(player, 10, armor);
    }

    @Test
    void buyPotionHealth() {
        final Shop shop = new Shop();
        final Player player = new Player("Isaac", 10, 10, 10);
        final Potion health = ItemFactory.createPotion(PotionType.HEALTH);
        shop.buyPotion(player, 10, health);
    }

    @Test
    void buyArmorUpgrade() {
    }

    @Test
    void buyPotion() {
    }

}
