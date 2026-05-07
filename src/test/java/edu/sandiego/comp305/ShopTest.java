package edu.sandiego.comp305;

import org.junit.jupiter.api.Test;

import java.net.FileNameMap;

import static org.junit.jupiter.api.Assertions.*;

class ShopTest {

    @Test
    void displayItems() {

    }

    @Test
    void buyWeaponUpgrade() {
        final Shop shop = new Shop();
        final Player player = new Player("Isaac",10,10);

        final Weapon sword = ItemFactory.createSwordWeapon(1);
        player.equipWeapon(sword);

        final boolean result = shop.buyWeaponBoost(10, 10, player);

        assertTrue(result);
        assertEquals(0, player.getGold());
        assertEquals(20, player.weapon.attackBoost);
    }

    @Test
    void buyWeaponUpGradeNoWeapon(){
        final Shop shop = new Shop();
        final Player player = new Player("Isaac",10,10);
        assertTrue(player.gold == 10);
        assertFalse(shop.buyWeaponBoost(10,10,player));
        assertTrue(player.gold == 10);
    }

    @Test
    void buyNewWeapon(){
        final Shop shop = new Shop();
        final Player player = new Player("Isaac",10,20);
        final Weapon sword = ItemFactory.createSwordWeapon(1);
        System.out.println(sword.name); // wood
        player.equipWeapon(sword);
        shop.buyNewWeapon(player,sword);
    }

    @Test
    void buyArmorUpGrade(){
        final Shop shop = ShopFactory.createDefualtShop();;
        final Player player = new Player("Isaac",10,10);
        final Armor armor = ItemFactory.createArmor(1);
        shop.buyArmorUpgrade(player,10,armor);
        assertTrue(armor.defenseBoost == 20);
        assertEquals(0, player.getGold());


    }

    @Test
    void buyPotionHealth(){
        final Shop shop = new Shop();
        final Player player = new Player("Isaac",10,10);
        final Potion health = ItemFactory.createPotion(PotionType.HEALTH);
        final int price = 10;
        shop.addItem(health);
        assertTrue(shop.displayItems().contains(health));
        shop.buyPotion(player,price,health);
        assertTrue(player.inventory.contains(health));
        assertEquals(0, player.getGold());
    }

    @Test
    void buyPotion() {
    }


}
