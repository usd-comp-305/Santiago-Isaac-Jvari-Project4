package edu.sandiego.comp305;

public class HealthPotion extends Potion {

    private static final int HEAL_AMOUNT = 25;

    @Override
    public void applyEffect(final Player player) {
        player.heal(HEAL_AMOUNT);
    }
}
