package at.fhj.iit;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("Testing SimpleDrink implementation")
public class SimpleDrinkTest {
    private SimpleDrink soda;
    private Liquid water;

    @BeforeEach
    void setup() {
        // SETUP PHASE
        water = new Liquid("Wasser", 0.3, 0);
        soda = new SimpleDrink("Soda", water);
    }

    @Test
    @DisplayName("Testing volume")
    public void testVolumeGetter() {
        assertEquals(soda.getVolume(), 0.3, 0.001);
    }

    @Test
    @DisplayName("Testing alcohol percent")
    public void testAlcoholPercent() {
        assertEquals(soda.getAlcoholPercent(), 0, 0.001);
    }
}
