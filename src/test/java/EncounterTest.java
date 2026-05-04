package edu.sandiego.comp305;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EncounterTest {

    @Test
    public void testEncounterStoresEnemy() {
        final Enemy slime = new Slime();

        final Encounter encounter = new Encounter(slime, false);

        assertEquals(slime, encounter.getEnemy());
    }

    @Test
    public void testRegularEncounterIsNotBossEncounter() {
        final Enemy slime = new Slime();

        final Encounter encounter = new Encounter(slime, false);

        assertFalse(encounter.isBossEncounter());
    }

    @Test
    public void testBossEncounterIsBossEncounter() {
        final Enemy lich = new Lich();

        final Encounter encounter = new Encounter(lich, true);

        assertTrue(encounter.isBossEncounter());
    }
}
