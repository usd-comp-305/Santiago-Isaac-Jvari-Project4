package edu.sandiego.comp305;

import java.util.ArrayList;

public class Shop {
    private ArrayList<Item> avaliableItems = new ArrayList<>();

    public ArrayList<Item> displayItems(){
        return new ArrayList<>(avaliableItems);
    }

    public void addItem(final Item item){
        avaliableItems.add(item);
    }

    public void removeItem(final Item item){
        avaliableItems.remove(item);
    }

    public void addMultipleItems(final ArrayList<Item> items){
        avaliableItems.addAll(items);
    }

    public boolean buyWeaponBoost(
            final int boostAmount,
            final int price,
            final Player player){
        if (canPlayerAfford(player,price)){
            if (player.weapon != null){
                player.weapon.attackBoost += boostAmount;
                player.decreaseGold(price);
                return true;
            }else{
                return false;
            }
        }
        return false;
    }

    public void buyNewWeapon(final Player player, final Weapon weapon){
        final int weaponPrice = weapon.cost;
        if(!(player.inventory.contains(weapon))
                && canPlayerAfford(player, weaponPrice)
                && this.avaliableItems.contains(weapon)){
            player.inventory.add(weapon);
            player.decreaseGold(weaponPrice);
            this.removeItem(weapon);

        }
    }


    private boolean canPlayerAfford(final Player player, final int price){
        if (player.gold >= price) {
            return true;
        }
        return false;
    }

    public void buyArmorUpgrade(final Player player, final int price, final Armor armor){
        if (canPlayerAfford(player,price) && !isArmorMaxed(armor)){
            player.decreaseGold(price);
            armor.defenseBoost += 10;
        }

    }
    private boolean isArmorMaxed(final Armor armor){
        if (armor.defenseBoost >= armor.maxDefenseBoost){
            return true;
        }
        return false;
    }


    public void buyPotion(final Player player, final int price, final Potion potion){
        if(avaliableItems.contains(potion) && canPlayerAfford(player,price)){
            this.removeItem(potion);
            player.decreaseGold(price);
            player.addToInventory(potion);
        }
    }

}
