package at.fhj.iit;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


@DisplayName("Testing SimpleDrink implementation")
public class SimpleDrinkTest {
    private SimpleDrink soda, shot;
    private Liquid water, schnapps;

    /**
     * inits liquids and simpleDrinks before each test
     */
    @BeforeEach
    void setup() {
        // SETUP PHASE
        water = new Liquid("Wasser", 0.3, 0);
        schnapps = new Liquid("Wodka", 0.05, 39.90);
        soda = new SimpleDrink("Soda", water);
        shot = new SimpleDrink("Shot", schnapps);

    }

    /**
     * Tests volume
     */

    @Test
    @DisplayName("Testing volume")
    public void testVolumeGetter() {
        assertEquals(soda.getVolume(), 0.3, 0.001);
    }

    /**
     * Tests alcohol percent"
     */
    @Test
    @DisplayName("Testing alcohol percent")
    public void testAlcoholPercent() {
        assertEquals(soda.getAlcoholPercent(), 0, 0.001);
    }

    /**
     * Tests alcohol percent"
     */
    @Test
    @DisplayName("Testing is alcoholic")
    public void testIsAlcoholic() {
        assertTrue(shot.isAlcoholic());
        assertFalse(soda.isAlcoholic());
    }
}
