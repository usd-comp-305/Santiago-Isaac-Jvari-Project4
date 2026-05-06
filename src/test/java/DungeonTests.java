import edu.sandiego.comp305.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class DungeonTests {

    @Test
    public void DungeonStartsAtDifficulty0() {
        final Dungeon dungeon = new Dungeon();

        assertEquals(0, dungeon.getDifficultyLevel());
    }

    @Test
    public void ExploreDirectionIncreasesRoomsExplored() {
        final Dungeon dungeon = new Dungeon();

        final int before = dungeon.getRoomsExplored();

        dungeon.exploreDirection(Direction.LEFT);

        assertEquals(before + 1, dungeon.getRoomsExplored());
    }

    @Test
    public void IncreaseDifficultyActuallyIncreases() {
        final Dungeon dungeon = new Dungeon();

        dungeon.increaseDifficulty();

        assertEquals(2, dungeon.getDifficultyLevel());
    }

    @Test
    public void GenerateDirectionEncountersReturnsMap() {
        final Dungeon dungeon = new Dungeon();

        assertNotNull(dungeon.generateDirectionEncounters());
    }






}
