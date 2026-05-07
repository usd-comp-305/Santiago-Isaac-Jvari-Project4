package edu.sandiego.comp305;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EncounterTest {

    @Test
    public void encounterStoresEnemyName() {
        final Encounter encounter = new Encounter(
                "slime", false);

        assertEquals("slime",
                encounter.getEnemyName());
    }

    @Test
    public void regularEncounterIsNotBossEncounter() {
        final Encounter encounter = new Encounter(
                "zombie", false);

        assertFalse(encounter.isBossEncounter());
    }

    @Test
    public void bossEncounterIsBossEncounter() {
        final Encounter encounter = new Encounter(
                "Lich", true);

        assertTrue(encounter.isBossEncounter());
    }
}
