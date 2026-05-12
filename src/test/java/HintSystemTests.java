package edu.sandiego.comp305;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HintSystemTests {

    @Test
    public void getHintForEnemyNotNull() {
        final HintSystem hintSystem = new HintSystem();
        final Enemy enemy = new Slime();

        final String result = hintSystem.getHintForEnemy(
                enemy,
                Direction.FORWARD);

        assertNotNull(result);
    }

    @Test
    public void getHintIncludesEnemyHint() {
        final HintSystem hintSystem = new HintSystem();
        final Enemy enemy = new Skeleton();

        final String result = hintSystem.getHintForEnemy(
                enemy,
                Direction.OUT);

        assertTrue(result.contains(enemy.getHint()));
    }

    @Test
    public void getHintIncludesDirection() {
        final HintSystem hintSystem = new HintSystem();
        final Enemy enemy = new Zombie();

        final String result = hintSystem.getHintForEnemy(
                enemy,
                Direction.RIGHT);

        assertTrue(result.toLowerCase().contains("right"));
    }

    @Test
    public void directionalMessage() {
        final HintSystem hintSystem = new HintSystem();

        final String result = hintSystem.getDirectionalMessage(
                Direction.LEFT,
                "groaning");

        assertEquals(
                "To the left you hear groaning",
                result);
    }
}


