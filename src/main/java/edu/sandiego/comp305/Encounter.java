package edu.sandiego.comp305;

public class Encounter {

    private final Enemy enemy;

    private final boolean bossEncounter;

    public Encounter(final Enemy enemy, final boolean bossEncounter) {
        this.enemy = enemy;
        this.bossEncounter = bossEncounter;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public boolean isBossEncounter() {
        return bossEncounter;
    }
}

