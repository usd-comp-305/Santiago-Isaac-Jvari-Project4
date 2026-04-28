import edu.sandiego.comp305.*;
import org.junit.jupiter.api.Test;
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
    void createWeapon_AttackBoost(int tier, int expectedBoost) {
        Weapon w = ItemFactory.createSwordWeapon(tier);
        assertEquals(expectedBoost,w.attackBoost);
    }
    @ParameterizedTest
    @CsvSource({
            "1,10",
            "2,20",
            "3,30",

    })
    void createArmor_DefenseBoost(int tier, int expectedBoost) {
        Armor a = ItemFactory.createArmor(tier);
        assertEquals(expectedBoost,a.defenseBoost);
    }
    @ParameterizedTest
    @CsvSource({
            "HEALTH,10",
            "STRENGTH,10",

    })
    void createPotion_HasCorrectEffect(PotionType type, int expectedEffect) {
        Potion p = ItemFactory.createPotion(type);
        assertEquals(expectedEffect, p.cost);

    }
    void createPotion_HasCorrectCost(PotionType type, int expectedCost) {
        Potion p = ItemFactory.createPotion(type);
        assertEquals(expectedCost, p.cost);
    }
}