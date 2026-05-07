package edu.sandiego.comp305;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopFactoryTest {
    @Test
    void createdefualtShop() {
        final Shop defualtShop = ShopFactory.createDefualtShop();
        assertEquals(7, defualtShop.displayItems().size());

    }

}
