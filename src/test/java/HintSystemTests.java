package edu.sandiego.comp305;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HintSystemTests {

    @Test
    public void testGetHintForEnemyNotNull() {
       final HintSystem hintSystem = new HintSystem();
        final Enemy enemy = new Slime();

        final String result = hintSystem.getHintForEnemy(
                enemy,
                Direction.FORWARD);

        assertNotNull(result);
    }

    @Test
    public void testGetHintIncludesEnemyHint() {
        final HintSystem hintSystem = new HintSystem();
        final Enemy enemy = new Skeleton();

        final String result = hintSystem.getHintForEnemy(
                enemy,
                Direction.OUT);

        assertTrue(result.contains(enemy.getHint()));
    }

    @Test
    public void testGetHintIncludesDirection() {
        final HintSystem hintSystem = new HintSystem();
        final Enemy enemy = new Zombie();

        final String result = hintSystem.getHintForEnemy(
                enemy,
                Direction.RIGHT);

        assertTrue(result.toLowerCase().contains("right"));
    }

    @Test
    public void testDirectionalMessage() {
        final HintSystem hintSystem = new HintSystem();

        final String result = hintSystem.getDirectionalMessage(
                Direction.LEFT,
                "groaning");

        assertEquals(
                "To the left you hear groaning",
                result);
    }
}


