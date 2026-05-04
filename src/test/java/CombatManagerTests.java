import edu.sandiego.comp305.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CombatManagerTests {

    @Test
    public void testPlayerTurnReduceEnemyHealth() {
        final CombatManager combatManager = new CombatManager();
        final Player player = new Player();
        final Enemy slime = new Slime();

        combatManager.playerTurn(player, slime);

        assertTrue(slime.getHealth() < 30);
    }

    @Test
    public void testEnemyTurnReducesPlayerHealth() {
        final CombatManager combatManager = new CombatManager();
        final Player player = new Player();
        final Enemy slime = new Slime();

        combatManager.enemyTurn(slime, player);

        assertTrue(player.getHealth() < 100);
    }

    @Test
    public void testCombatEndsWhenEnemyDies() {
        final CombatManager combatManager = new CombatManager();
        final Player player = new Player();
        final Enemy slime = new Slime();

        combatManager.startCombat(player, slime);

        assertFalse(slime.isAlive());
    }

    @Test
    public void testResolveVictoryAddsGold() {
        final CombatManager combatManager = new CombatManager();
        final Player player = new Player();
        final Enemy slime = new Slime();

        combatManager.resolveVictory(player, slime);

        assertEquals(slime.getGoldReward(), player.getGold());
    }
}