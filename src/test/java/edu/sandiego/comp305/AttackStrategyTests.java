package edu.sandiego.comp305;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AttackStrategyTests {

    @Test
    public void testBasicAttackReturnsSamePower() {
        AttackStrategy strategy = new BasicAttack();

        int damage = strategy.executeAttack(10);

        assertEquals(10, damage);
    }

    @Test
    public void testHeavyAttackDoesMoreDamage() {
        AttackStrategy strategy = new HeavyAttack();

        int damage = strategy.executeAttack(10);

        assertTrue(damage > 10);
    }
}