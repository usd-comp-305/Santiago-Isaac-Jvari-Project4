package edu.sandiego.comp305;

public class Dungeon {

    int difficultyLevel;

    int roomsExplored;

    double bossEncounterChance;

    boolean playerInside;

    EnemyFactory enemyFactory;

    HintSystem hintSystem;

    public Dungeon() {
        this.difficultyLevel = 1;
        this.roomsExplored = 0;
        this.bossEncounterChance = 0.1;
        this.enemyFactory = new EnemyFactory();
        this.hintSystem = new HintSystem();
        this.playerInside = false;
    }

    public Encounter exploreDirection(final Direction direction) {
        // TODO: implement
        return null;
    }


    public void increaseDifficulty() {
        difficultyLevel +=1;
        bossEncounterChance= bossEncounterChance / 2 + bossEncounterChance;
    }


    public boolean rollBossEncounter() {
        // TODO: implement
        return false;
    }

    public String getHint(final Direction direction) {
        return hintSystem.getDirectionalMessage(direction, null);
    }

    public int getRoomsExplored() {
        return roomsExplored;
    }

    public EnemyFactory getEnemyFactory() {
        return enemyFactory;
    }

    public boolean inDungeon() {
        playerInside = !playerInside;
        return playerInside;
    }
}
