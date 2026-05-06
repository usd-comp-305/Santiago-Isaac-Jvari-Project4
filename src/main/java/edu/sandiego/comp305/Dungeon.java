package edu.sandiego.comp305;

import java.util.HashMap;
import java.util.Map;

public class Dungeon {

    int difficultyLevel;

    int roomsExplored;

    double bossEncounterChance;

    boolean playerInside;

    EnemyFactory enemyFactory;

    HintSystem hintSystem;

    Map<Direction, Encounter> currentEncounters;

    public Dungeon() {
        this.difficultyLevel = 0;
        this.roomsExplored = 0;
        this.bossEncounterChance = 0.1;
        this.enemyFactory = new EnemyFactory();
        this.hintSystem = new HintSystem();
        this.playerInside = false;
        this.currentEncounters = new HashMap<>();
    }

    public Encounter exploreDirection(final Direction direction) {
        roomsExplored++;

        final Encounter chosenEncounter = currentEncounters.get(direction);

        currentEncounters = generateDirectionEncounters();

        return chosenEncounter;
    }

    public Map<Direction, Encounter> generateDirectionEncounters() {
        final Map<Direction, Encounter> encounters = new HashMap<>();

        final Direction[] directions = {
                Direction.LEFT,
                Direction.FORWARD,
                Direction.RIGHT
        };

        for (final Direction direction : directions) {
            if (rollEncounter()) {
                encounters.put(direction, createEncounter());
            }
        }

        return encounters;
    }


    public void increaseDifficulty() {
        difficultyLevel += 1;
        bossEncounterChance= bossEncounterChance / 2 + bossEncounterChance;
    }


    public boolean rollBossEncounter() {

        return Math.random() < bossEncounterChance;
    }

    public String getHint(final Direction direction) {
        final Enemy enemy = enemyFactory.createEnemy(
                getRandomEnemyType(), difficultyLevel);

        return hintSystem.getHintForEnemy(enemy, direction);
    }

    public int getRoomsExplored() {
        return roomsExplored;
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }

    public EnemyFactory getEnemyFactory() {
        return enemyFactory;
    }

    public boolean inDungeon() {
        playerInside = !playerInside;
        return playerInside;
    }

    private Encounter createEncounter() {
        final boolean bossEncounter = rollBossEncounter();

        final Enemy enemy;

        if (bossEncounter) {
            enemy = enemyFactory.createBoss(getRandomBossType());
        } else {
            enemy = enemyFactory.createEnemy(
                    getRandomEnemyType(),
                    difficultyLevel);
        }

        return new Encounter(enemy, bossEncounter);
    }

    private String getRandomEnemyType() {
        final String[] enemies = {"slime", "zombie", "skeleton"};

        final int index = (int) (Math.random() * enemies.length);

        return enemies[index];
    }

    private String getRandomBossType() {
        final String[] bossTypes = {"Lich", "Minotaur", "ZombieKing"};

        final int index = (int) (Math.random() * bossTypes.length);

        return bossTypes[index];
    }

    public boolean rollEncounter() {
        return Math.random() < 0.6;
    }
}



