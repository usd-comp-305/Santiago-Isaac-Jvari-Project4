import edu.sandiego.comp305.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.junit.jupiter.api.Assertions.*;

class ItemFactoryTest {

    @ParameterizedTest
    @CsvSource({
        "1,10",
        "2,20",
        "3,30",

    })
    void createWeapon_AttackBoost(final int tier, final int expectedBoost) {
        final Weapon w = ItemFactory.createSwordWeapon(tier);
        assertEquals(expectedBoost,w.getAttackBoost());
    }

    @ParameterizedTest
    @CsvSource({
        "1,10",
        "2,20",
        "3,30",

    })
    void createArmor_DefenseBoost(final int tier, final int expectedBoost) {
        final Armor a = ItemFactory.createArmor(tier);
        assertEquals(expectedBoost,a.getDefenseBoost());
    }

    @ParameterizedTest
    @CsvSource({
        "HEALTH,10",
        "STRENGTH,10",

    })
    void createPotion_HasCorrectEffect(final PotionType type,
            final int expectedEffect) {
        final Potion p = ItemFactory.createPotion(type);
        assertEquals(expectedEffect, p.getCost());

    }

    void createPotion_HasCorrectCost(final PotionType type,
            final int expectedCost) {
        final Potion p = ItemFactory.createPotion(type);
        assertEquals(expectedCost, p.getCost());
    }
}
