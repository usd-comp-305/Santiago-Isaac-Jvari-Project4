package edu.sandiego.comp305;

public class Weapon extends Item{
    private int attackBoost;

    private int tier;

    public int getTier(){
        return tier;
    }

    public void setTier(final int tier){
        this.tier = tier;
    }

    public void setAttackBoost(final int attackBoost){
        this.attackBoost = attackBoost;
    }

    public int getAttackBoost(){
        return attackBoost;
    }
}

