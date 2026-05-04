package edu.sandiego.comp305;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HintSystemTests {

    @Test
    public void testGetHintForEnemyNotNull() {
        HintSystem hintSystem = new HintSystem();
        Enemy enemy = new Slime();

        String result = hintSystem.getHintForEnemy(enemy, Direction.FORWARD);

        assertNotNull(result);
    }

    @Test
    public void testGetHintIncludesEnemyHint() {
        HintSystem hintSystem = new HintSystem();
        Enemy enemy = new Skeleton();

        String result = hintSystem.getHintForEnemy(enemy, Direction.OUT);

        assertTrue(result.contains(enemy.getHint()));
    }

    @Test
    public void testGetHintIncludesDirection() {
        HintSystem hintSystem = new HintSystem();
        Enemy enemy = new Zombie();

        String result = hintSystem.getHintForEnemy(enemy, Direction.RIGHT);

        assertTrue(result.toLowerCase().contains("east"));
    }

    @Test
    public void testDirectionalMessage() {
        HintSystem hintSystem = new HintSystem();

        String result = hintSystem.getDirectionalMessage(Direction.LEFT, "groaning");

        assertEquals("To the west: groaning", result);
    }
}
