package edu.sandiego.comp305;

public class Encounter {

    private final String enemyName;

    private final boolean bossEncounter;

    public Encounter(final String enemyName, final boolean bossEncounter) {
        this.enemyName = enemyName;
        this.bossEncounter = bossEncounter;
    }

    public String getEnemyName() {
        return enemyName;
    }

    public boolean isBossEncounter() {
        return bossEncounter;
    }
}

