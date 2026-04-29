package edu.sandiego.comp305;


public class ItemFactory {
    public static Weapon createSwordWeapon(int tier){
        Weapon sword = new Weapon();
        if (tier == 1){
            sword.name = "Wood Sword";
            sword.cost = 10;
            sword.attackBoost = 10;
        }
        else if (tier == 2){
            sword.name = "Steal Sword";
            sword.cost = 20;
            sword.attackBoost = 20;
        } else if (tier == 3) {
            sword.name = "Diamond Sword";
            sword.cost = 30;
            sword.attackBoost = 30;
        }
        return sword;
    }
    public static Armor createArmor(int tier){
        Armor armor = new Armor();
        if (tier == 1){
            armor.name = "Wood Armor";
            armor.cost = 10;
            armor.defenseBoost = 10;
        }
        else if (tier == 2){
            armor.name = "Steal Armor";
            armor.cost = 20;
            armor.defenseBoost = 20;
        }  else if (tier == 3) {
            armor.name = "Diamond Armor";
            armor.cost = 30;
            armor.defenseBoost = 30;
        }
        return armor;
    }
    public static Potion createPotion(PotionType type){
        switch (type){
            case HEALTH -> {
                Potion potion = new HealthPotion();
                potion.name = "Healing Potion";
                potion.cost = 10;
                potion.effectValue = 30;
                return potion;


            }
            case STRENGTH -> {
                Potion potion = new StrengthPotion();
                potion.name = "Strength Potion";
                potion.cost = 10;
                potion.effectValue = 10;
                return potion;
            }
            default -> {return null;}
        }
    }
}
