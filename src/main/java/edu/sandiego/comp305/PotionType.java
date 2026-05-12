package edu.sandiego.comp305;

public enum PotionType {
    HEALTH("Healing Potion", 10, 30) {
        @Override
        public Potion createPotion() {
            return new Potion() {
                @Override
                public void applyEffect(final Player player) {
                    player.heal(getEffectValue());
                }
            };
        }
    },
    STRENGTH("Strength Potion", 10, 10) {
        @Override
        public Potion createPotion() {
            return new Potion() {
                @Override
                public void applyEffect(final Player player) {
                    player.boostWeapon(getEffectValue());
                }
            };
        }
    };

    private final String name;

    private final int cost;

    private final int effectValue;

    PotionType(final String name,
               final int cost,
               final int effectValue){
        this.name = name;
        this.cost = cost;
        this.effectValue = effectValue;
    }

    public String getName(){
        return name;

    }

    public int getCost(){
        return cost;
    }

    public int getEffectValue(){
        return effectValue;

    }

    public abstract Potion createPotion();

}
