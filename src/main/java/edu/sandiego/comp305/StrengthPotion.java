package edu.sandiego.comp305;

public class StrengthPotion extends Potion{
    @Override
    public void applyEffect(final Player player ) {

        player.getWeapon().setAttackBoost(
                player.getWeapon().getAttackBoost() + getEffectValue()
        );
    }
}
