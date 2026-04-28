package edu.sandiego.comp305;

public class StrengthPotion extends Potion{
    @Override
    public void applyEffect(Player player ) {
        player.weapon.attackBoost += effectValue;
    }
}
