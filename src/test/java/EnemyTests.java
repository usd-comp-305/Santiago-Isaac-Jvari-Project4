import edu.sandiego.comp305.Enemy;
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
    public void testEnemyDiesWhenHealthZero() {
        final Enemy slime = new Slime();

        slime.takeDamage(30);

        assertFalse(slime.isAlive());
    }

    @Test
    public void testEnemyAliveWhenHealthAboveZero() {
        final Enemy slime = new Slime();

        slime.takeDamage(10);

        assertTrue(slime.isAlive());
    }

    @Test
    public void testEnemyHint() {
        final Enemy slime = new Slime();

        assertEquals("sloshing", slime.getHint());
    }




}
