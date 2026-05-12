package edu.sandiego.comp305;

public class Armor extends Item implements Equippable {

    private static final int MAX_DEFENSE_BOOST = 30;

    private int defenseBoost;


    public int getDefenseBoost() {
        return defenseBoost;
    }

    public void setDefenseBoost(final int defenseBoost) {

        this.defenseBoost = defenseBoost;
    }

    public int getMaxDefenseBoost() {
        return MAX_DEFENSE_BOOST;
    }

    public boolean isMaxed(){
        return defenseBoost >= MAX_DEFENSE_BOOST;
    }

    public void increaseDefense(final int amonut){
        this.defenseBoost = Math.min(this.defenseBoost
                + amonut, MAX_DEFENSE_BOOST);
    }

    @Override
    public void equip(final Player player){
        player.equipArmor(this);
    }

}
