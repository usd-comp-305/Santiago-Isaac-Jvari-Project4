package edu.sandiego.comp305;

public final class ItemFactory {

    private static final int HEALTH_POTION_COST = 10;

    private static final int STRENGTH_POTION_COST = 10;

    private ItemFactory() {
        throw new UnsupportedOperationException();
    }

    public static Potion createPotion(final PotionType type) {
        switch (type) {
            case HEALTH:
                return createHealthPotion();

            case STRENGTH:
                return createStrengthPotion();

            default:
                throw new IllegalArgumentException("Unknown potion.");
        }
    }

    private static Potion createHealthPotion() {
        final Potion potion = new HealthPotion();
        potion.name = "Health Potion";
        potion.cost = HEALTH_POTION_COST;
        return potion;
    }

    private static Potion createStrengthPotion() {
        final Potion potion = new StrengthPotion();
        potion.name = "Strength Potion";
        potion.cost = STRENGTH_POTION_COST;
        return potion;
    }
}
