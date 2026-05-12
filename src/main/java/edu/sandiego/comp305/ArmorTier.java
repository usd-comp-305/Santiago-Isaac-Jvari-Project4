package edu.sandiego.comp305;


public enum ArmorTier {
    WOOD(1,  "Wood Armor",    10, 10),
    STEEL(2, "Steel Armor",   20, 20),
    DIAMOND(3,"Diamond Armor",30, 30);

    private final int tier;

    private final String name;

    private final int cost;

    private final int defenseBoost;

    ArmorTier(final int tier,
              final String name,
              final int cost,
              final int defenseBoost){
        this.tier = tier;
        this.name = name;
        this.cost = cost;
        this.defenseBoost = defenseBoost;
    }

    public int getTier() {
        return tier;
    }

    public String getName() {
        return name;
    }


    public int getCost() {
        return cost;
    }

    public int getDefenseBoost() {
        return defenseBoost;
    }

    public static ArmorTier fromInt(final int tier){
        for (ArmorTier armorTier : ArmorTier.values()){
            if (armorTier.tier == tier){
                return armorTier;
            }
        }
        throw new IllegalArgumentException("Unknown tier: " + tier);

    }


}
