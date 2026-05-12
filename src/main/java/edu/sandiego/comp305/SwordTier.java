package edu.sandiego.comp305;

public enum SwordTier {
    WOOD(1,  "Wood Sword",    10, 10),
    STEEL(2, "Steel Sword",   20, 20),
    DIAMOND(3,"Diamond Sword",30, 30);

    private final int tier;

    private final String name;

    private final int cost;

    private final int attackBoost;

    SwordTier(final int tier,
              final String name,
              final int cost,
              final int attackBoost) {
        this.tier = tier;
        this.name = name;
        this.cost = cost;
        this.attackBoost = attackBoost;
    }


    public int getTier(){
        return tier; }

    public String getName(){
        return name; }

    public int getCost(){
        return cost; }

    public int getAttackBoost() {
        return attackBoost;
    }

    public static SwordTier fromInt(final int tier) {
        for(SwordTier s: SwordTier.values()){
            if(s.getTier() == tier){
                return s;
            }
        }
        throw new IllegalArgumentException("Unknown tier: " + tier);
    }

}
