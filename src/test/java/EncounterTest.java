package edu.sandiego.comp305;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EncounterTest {

    @Test
    public void testEncounterStoresEnemyName() {
        final Encounter encounter = new Encounter(
                "slime", false);

        assertEquals("slime",
                encounter.getEnemyName());
    }

    @Test
    public void testRegularEncounterIsNotBossEncounter() {
        final Encounter encounter = new Encounter(
                "zombie", false);

        assertFalse(encounter.isBossEncounter());
    }

    @Test
    public void testBossEncounterIsBossEncounter() {
        final Encounter encounter = new Encounter(
                "Lich", true);

        assertTrue(encounter.isBossEncounter());
    }
}
