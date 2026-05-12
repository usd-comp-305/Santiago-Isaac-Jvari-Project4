package edu.sandiego.comp305;

public abstract class Potion extends Item{
    private int effectValue;

    public abstract void applyEffect(Player player );

    public int getEffectValue() {
        return effectValue;
    }

    protected void setEffectValue(final int effectValue) {
        this.effectValue = effectValue;
    }

}

