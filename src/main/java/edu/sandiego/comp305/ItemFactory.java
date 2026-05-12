package edu.sandiego.comp305;


public final class ItemFactory {

    private ItemFactory() {
        throw new UnsupportedOperationException();
    }

    public static Weapon createSwordWeapon(final int tier){
        final Weapon sword = new Weapon();
        if (tier == 1){
            sword.name = "Wood Sword";
            sword.cost = 10;
            sword.setAttackBoost(10);
            sword.setTier(1);
        } else if (tier == 2){
            sword.name = "Steel Sword";
            sword.cost = 20;
            sword.setAttackBoost(20);
            sword.setTier(2);
        } else if (tier == 3) {
            sword.name = "Diamond Sword";
            sword.cost = 30;
            sword.setAttackBoost(30);
            sword.setTier(3);
        }
        return sword;
    }

    public static Armor createArmor(final int tier){
        final Armor armor = new Armor();
        if (tier == 1){
            armor.name = "Wood Armor";
            armor.cost = 10;
            armor.setDefenseBoost(armor.getDefenseBoost() + 10);
        } else if (tier == 2){
            armor.name = "Steel Armor";
            armor.cost = 20;
            armor.setDefenseBoost(armor.getDefenseBoost() + 20);
        }  else if (tier == 3) {
            armor.name = "Diamond Armor";
            armor.cost = 30;
            armor.setDefenseBoost(armor.getDefenseBoost() + 30);
        }
        return armor;
    }

    public static Potion createPotion(final PotionType type){
        switch (type){
            case HEALTH -> {
                final Potion potion = new HealthPotion();
                potion.name = "Healing Potion";
                potion.cost = 10;
                potion.setEffectValue(30);
                return potion;


            }
            case STRENGTH -> {
                final Potion potion = new StrengthPotion();
                potion.name = "Strength Potion";
                potion.cost = 10;
                potion.setEffectValue(10);
                return potion;
            }
            default -> {
                return null;
            }
        }
    }
}
