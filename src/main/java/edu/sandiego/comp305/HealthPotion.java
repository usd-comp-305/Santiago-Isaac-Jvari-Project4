package edu.sandiego.comp305;

public class HealthPotion extends Potion {
    @Override
    public void applyEffect(final Player player ) {
        player.heal(getEffectValue());
    }
}
