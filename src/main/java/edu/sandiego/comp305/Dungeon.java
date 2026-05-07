package edu.sandiego.comp305;

import java.util.HashMap;
import java.util.Map;

public class Dungeon {
    private static final int STARTING_DIFFICULTY = 0;

    private static final int STARTING_ROOMS_EXPLORED = 0;

    private static final double STARTING_BOSS_CHANCE = 0.1;

    private static final double ENCOUNTER_CHANCE = 0.6;

    private static final double BOSS_CHANCE_INCREASE_MULTIPLIER = 1.5;

    int difficultyLevel;

    int roomsExplored;

    double bossEncounterChance;

    boolean playerInside;

    EnemyFactory enemyFactory;

    HintSystem hintSystem;

    Map<Direction, Encounter> currentEncounters;

    public Dungeon() {
        this.difficultyLevel = STARTING_DIFFICULTY;
        this.roomsExplored = STARTING_ROOMS_EXPLORED;
        this.bossEncounterChance = STARTING_BOSS_CHANCE;
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
        bossEncounterChance *=BOSS_CHANCE_INCREASE_MULTIPLIER;
    }


    public boolean rollBossEncounter() {

        return Math.random() < bossEncounterChance;
    }

    public String getHint(final Direction direction) {
        final Encounter encounter = currentEncounters.get(direction);

        if (encounter == null) {
            return "This path seems quiet.";
        }

        final Enemy enemy;

        if (encounter.isBossEncounter()) {
            enemy = enemyFactory.createBoss(encounter.getEnemyName());
        } else {
            enemy = enemyFactory.createEnemy(
                    encounter.getEnemyName(),
                    difficultyLevel);
        }

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
        return playerInside;
    }

    public void enterDungeon() {
        playerInside = true;
    }

    public void exitDungeon() {
        playerInside = false;
    }

    private Encounter createEncounter() {
        final boolean bossEncounter = rollBossEncounter();

        if (bossEncounter) {
            return new Encounter(getRandomBossType(), true);
        }

        return new Encounter(getRandomEnemyType(), false);
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
        return Math.random() < ENCOUNTER_CHANCE;
    }
}




