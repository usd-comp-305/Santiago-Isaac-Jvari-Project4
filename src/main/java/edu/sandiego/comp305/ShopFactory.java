package edu.sandiego.comp305;


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
        return shop;
    }

    

    public static Shop emptyShop(){
        final Shop shop = new Shop();
        return shop;
    }

}
