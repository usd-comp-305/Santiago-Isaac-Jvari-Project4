package edu.sandiego.comp305;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopTest {

    @Test
    void displayItems() {
        Shop shop = new Shop();
        shop.displayItems();
    }

    @Test
    void buyWeaponUpgrade() {
        Shop shop = new Shop();
        Player player = new Player();
        var sword = ItemFactory.createSwordWeapon(0);
        player.buyItem(sword,10);
    }

    @Test
    void buyArmorUpgrade() {
    }

    @Test
    void buyPotion() {
    }
}