package edu.sandiego.comp305;

public class Armor extends Item{
    private final int defenseBoost;

    public Armor(final int defenseBoost) {
        this.defenseBoost = defenseBoost;
    }

    public int getDefenseBoost() {
        return defenseBoost;
    }
}

