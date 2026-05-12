package edu.sandiego.comp305;

public class StrengthPotion extends Potion{
    private static final int STRENGTH_EFFECT = 5;

    @Override
    public void applyEffect(final Player player) {
        player.weapon.setAttackBoost(
                player.weapon.getAttackBoost() + STRENGTH_EFFECT
        );
    }
}
