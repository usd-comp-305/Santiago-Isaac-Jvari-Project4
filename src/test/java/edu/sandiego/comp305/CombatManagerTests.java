package edu.sandiego.comp305;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
// need these in order to run tests
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

public class CombatManagerTests {

    @Test
    public void testPlayerTurnReducesEnemyHealth() {
        final String input = "1\n";
        //simulates an input of 1
        System.setIn(new ByteArrayInputStream(
                input.getBytes(StandardCharsets.UTF_8)));

        final Dungeon dungeon = new Dungeon();
        final CombatManager combatManager = new CombatManager(dungeon);

        final Player player = new Player();
        final Enemy slime = new Slime();

        final int healthBefore = slime.getHealth();

        combatManager.playerTurn(player, slime);

        assertTrue(slime.getHealth() < healthBefore);
    }

    @Test
    public void testEnemyTurnReducesPlayerHealth() {
        final Dungeon dungeon = new Dungeon();
        final CombatManager combatManager = new CombatManager(dungeon);

        final Player player = new Player();
        final Enemy slime = new Slime();

        final int healthBefore = player.getHealth();

        combatManager.enemyTurn(slime, player);

        assertTrue(player.getHealth() < healthBefore);
    }

    @Test
    public void testCombatEndsWhenEnemyDies() {
        final String input = "1\n";
        System.setIn(new ByteArrayInputStream(
                input.getBytes(StandardCharsets.UTF_8)));

        final Dungeon dungeon = new Dungeon();
        final CombatManager combatManager = new CombatManager(dungeon);

        final Player player = new Player("Test", 100, 0, 100);
        final Enemy slime = new Slime();

        combatManager.startCombat(player, slime);

        assertFalse(slime.isAlive());
        assertTrue(player.isAlive());
    }

    @Test
    public void testResolveVictoryAddsGold() {
        final Dungeon dungeon = new Dungeon();
        final CombatManager combatManager = new CombatManager(dungeon);

        final Player player = new Player();
        final Enemy slime = new Slime();

        final int goldBefore = player.getGold();

        combatManager.resolveVictory(player, slime);

        assertEquals(goldBefore + slime.getGoldReward(), player.getGold());
    }

    @Test
    public void testBossVictoryIncreasesDifficulty() {
        final Dungeon dungeon = new Dungeon();
        final CombatManager combatManager = new CombatManager(dungeon);

        final Player player = new Player();
        final Enemy boss = new BossEnemy("Test Boss", 40, 10, 20, "boss hint");

        final int difficultyBefore = dungeon.getDifficultyLevel();

        combatManager.resolveVictory(player, boss);

        assertEquals(difficultyBefore + 1, dungeon.getDifficultyLevel());
    }
}
