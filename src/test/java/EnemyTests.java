import edu.sandiego.comp305.Enemy;
import edu.sandiego.comp305.Player;
import edu.sandiego.comp305.Slime;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EnemyTests {

    @Test
    public void testTakeDamageReducesHealth() {
        final Enemy slime = new Slime();

        slime.takeDamage(10);

        assertEquals(20, slime.getHealth());
    }

    @Test
    public void enemyDiesWhenHealthZero() {
        final Enemy slime = new Slime();

        slime.takeDamage(30);

        assertFalse(slime.isAlive());
    }

    @Test
    public void enemyAliveWhenHealthAboveZero() {
        final Enemy slime = new Slime();

        slime.takeDamage(10);

        assertTrue(slime.isAlive());
    }

    @Test
    public void enemyHint() {
        final Enemy slime = new Slime();

        assertEquals("sloshing", slime.getHint());
    }

    @Test
    public void enemyGoldReward() {
        final Enemy slime = new Slime();

        assertEquals(10, slime.getGoldReward());
    }

    @Test
    public void rageIncreasesAttackDamage() {
        final Enemy slime = new Slime();
        final Player player = new Player("Test", 100, 0, 5);

        slime.rage();
        slime.attack(player);

        assertEquals(90, player.getHealth());
    }
    @Test
    public void increaseStatsRaisesEnemyStats() {
        final Enemy slime = new Slime();

        slime.increaseStats(3);

        assertEquals(60, slime.getHealth());
        assertEquals(14, slime.getAttackPower());
        assertEquals(25, slime.getGoldReward());
    }




}
