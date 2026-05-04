import edu.sandiego.comp305.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EnemyFactoryTests {

    @Test
    public void createEnemyReturnsSlime() {
        final EnemyFactory factory = new EnemyFactory();

        final Enemy enemy = factory.createEnemy("slime",1);

        assertTrue(enemy instanceof Slime);
        assertEquals("sloshing", enemy.getHint());
    }

    @Test
    public void createEnemyReturnsSkeleton() {
        final EnemyFactory factory = new EnemyFactory();

        final Enemy enemy = factory.createEnemy("skeleton",1);

        assertTrue(enemy instanceof Skeleton);
        assertEquals("rattling", enemy.getHint());
    }

    @Test
    public void createBossReturnsBossEnemy() {
        final EnemyFactory factory = new EnemyFactory();

        final BossEnemy boss = (BossEnemy) factory.createBoss("Lich");

        assertNotNull(boss);
    }



}

