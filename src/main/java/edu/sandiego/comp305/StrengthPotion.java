package edu.sandiego.comp305;

public class StrengthPotion extends Potion{
    @Override
    public void applyEffect(final Player player ) {
        player.boostWeapon(getEffectValue());
    }
}
