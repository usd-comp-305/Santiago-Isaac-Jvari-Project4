package edu.sandiego.comp305;

public abstract class Potion extends Item{
    int effectValue;
    public abstract void applyEffect(Player player );
}

