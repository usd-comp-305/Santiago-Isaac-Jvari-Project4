package edu.sandiego.comp305;


public final class ItemFactory {

    private ItemFactory() {
        throw new UnsupportedOperationException();
    }

    public static Weapon createSwordWeapon(final int tier){
        final SwordTier base = SwordTier.fromInt(tier);
        final Weapon sword = new Weapon();
        sword.setName(base.getName());
        sword.setCost(base.getCost());
        sword.setAttackBoost(base.getAttackBoost());
        sword.setTier(base.getTier());
        return sword;
    }

    public static Armor createArmor(final int tier){
        final ArmorTier baseArmor = ArmorTier.fromInt(tier);
        final Armor armor = new Armor();
        armor.setName(baseArmor.getName());
        armor.setCost(baseArmor.getCost());
        armor.setDefenseBoost(baseArmor.getDefenseBoost());
        return armor;
    }

    public static Potion createPotion(final PotionType type){
        final Potion potion = type.createPotion();
        potion.setName(type.getName());
        potion.setCost(type.getCost());
        potion.setEffectValue(type.getEffectValue());
        return potion;
    }
}
