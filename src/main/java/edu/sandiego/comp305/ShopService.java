package edu.sandiego.comp305;

public class ShopService {
    private final Shop shop;

    public ShopService(final Shop shop) {
        this.shop = new Shop(shop);
    }

    public boolean buyItem(final Player player,
                           final Item item) {
        if (!shop.hasItem(item) ||
                !canAfford(player, item.getCost())
                || player.hasInInventory(item)) {
            return false;
        }
        player.decreaseGold(item.getCost());
        player.addToInventory(item);
        shop.removeItem(item);
        return true;
    }

    public boolean buyWeaponBoost(final Player player,
                                  final int boostAmount,
                                  final int price) {
        if (player.getWeapon() == null || !canAfford(player, price)) {
            return false;
        }
        player.boostWeapon(boostAmount);
        player.decreaseGold(price);
        return true;
    }

    public boolean buyArmorUpgrade(final Player player,
                                   final Armor armor,
                                   final int price) {
        if (!canAfford(player, price) || armor.isMaxed()) {
            return false;
        }
        player.decreaseGold(price);
        armor.increaseDefense(10);
        return true;
    }

    private boolean canAfford(final Player player, final int price) {
        return player.getGold() >= price;

    }

}

