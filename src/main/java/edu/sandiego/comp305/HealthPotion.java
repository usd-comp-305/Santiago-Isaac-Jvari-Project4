package edu.sandiego.comp305;

public class HealthPotion extends Potion {
    @Override
    public void applyEffect(Player player ) {
        player.health += effectValue;

    }
}
