package edu.sandiego.comp305;

import java.util.ArrayList;

public final class ShopFactory {
    private ShopFactory() {
        throw new UnsupportedOperationException();
    }

    public static Shop createDefualtShop(){
        final Shop shop = new Shop();
        for(int i = 1; i < 4; i++){
            shop.addItem(ItemFactory.createSwordWeapon(i));
            shop.addItem(ItemFactory.createArmor(i));
        }
        shop.addItem(ItemFactory.createPotion(PotionType.HEALTH));
        shop.addItem(ItemFactory.createPotion(PotionType.STRENGTH));
        return shop;
    }

    public static Shop createArmorShop(){
        final Shop shop = new Shop();
        for(int i = 1; i < 4; i++){
            shop.addItem(ItemFactory.createArmor(i));
        }
        return shop;
    }

    public static Shop createPotionShop(){
        final Shop shop = new Shop();
        for(PotionType type : PotionType.values()){
            shop.addItem(ItemFactory.createPotion(type));
        }
        return shop;
    }

    public static Shop createSwordShop(){
        final Shop shop = new Shop();
        for(int i = 1; i < 4; i++){
            shop.addItem(ItemFactory.createSwordWeapon(i));
        }
        return shop;
    }

    public static Shop createNextTierShop(final int tier){
        final Shop shop = new Shop();
        int current = tier + 1;
        while (current < 4){
            shop.addItem(ItemFactory.createSwordWeapon(current));
            shop.addItem(ItemFactory.createArmor(current));
            current++;
        }
        return shop;
    }

    public static Shop createcustomShop(final ArrayList<Item> itemList){
        final Shop shop = new Shop();
        for(Item item : itemList){
            shop.addItem(item);
        }
        return shop;
    }

    public static Shop emptyShop(){
        final Shop shop = new Shop();
        return shop;
    }

}
