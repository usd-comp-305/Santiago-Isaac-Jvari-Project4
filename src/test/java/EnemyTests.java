import edu.sandiego.comp305.Enemy;
import edu.sandiego.comp305.Slime;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EnemyTests {

    @Test
    public void testTakeDamageReducesHealth() {
        Enemy slime = new Slime();

        slime.takeDamage(10);

        assertEquals(20, slime.getHealth());
    }

    @Test
    public void testEnemyDiesWhenHealthZero() {
        Enemy slime = new Slime();

        slime.takeDamage(30);

        assertFalse(slime.isAlive());
    }




}