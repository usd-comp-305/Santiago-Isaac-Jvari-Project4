import edu.sandiego.comp305.Enemy;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EnemyFactoryTests {

    @Test
    public void createEnemyReturnsSlime() {
        EnemyFactory factory = new EnemyFactory();

        Enemy enemy = factory.createEnemy("slime");

        assertTrue(enemy instanceof Slime);
        assertEquals("sloshing", enemy.getHint());
    }

    @Test
    public void createEnemyReturnsSkeleton() {
        EnemyFactory factory = new EnemyFactory();

        Enemy enemy = factory.createEnemy("skeleton");

        assertTrue(enemy instanceof Skeleton);
        assertEquals("rattling", enemy.getHint());
    }

    @Test
    public void createBossReturnsBossEnemy() {
        EnemyFactory factory = new EnemyFactory();

        BossEnemy boss = factory.createBoss();

        assertNotNull(boss);
        assertTrue(boss instanceof BossEnemy);
    }
}

