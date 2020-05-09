package at.fhj.iit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CocktailTest {

    private Liquid water, vodka, cream, mangoJuice;
    private Cocktail fullCocktail, emptyCocktail;

    /**
     * Inits a cocktail witch liquids before each test
     */

    @BeforeEach
    void setUp() {
        // SETUP PHASE
        water = new Liquid("Wasser", 0.03, 0);
        vodka = new Liquid("Wodka", 0.005, 39.90);
        cream = new Liquid("Obers", 0.02, 0);
        mangoJuice = new Liquid("Mangosaft", 0.05, 0.01);

        fullCocktail = new Cocktail("cocktail 1", 0.5);
        emptyCocktail = new Cocktail("cocktail 2", 0.5);

        fullCocktail.pour(water);
        fullCocktail.pour(vodka);
        fullCocktail.pour(cream);
        fullCocktail.pour(mangoJuice);

    }

    /**
     * Tests if empty cocktail has zero volume
     */
    @Test
    @DisplayName("Testing if empty cocktail has zero volume")
    public void testEmptyCocktailIsEmpty() {
        assertEquals(0, emptyCocktail.getVolume());
    }

    /**
     * Tests if empty cocktail has zero alcohol
     */
    @Test
    @DisplayName("Testing if empty cocktail has zero alcohol")
    public void testEmptyCocktailHasNoAlcohol() {
        assertEquals(0, emptyCocktail.getAlcoholPercent());
    }

    /**
     * Tests pour method
     */
    @Test
    @DisplayName("Testing pour method")
    public void testPourMethod() {
        assertEquals(fullCocktail.pour(water), fullCocktail);
    }

    /**
     * Tests alcohol percent of full cocktail
     */
    @Test
    @DisplayName("Testing alcohol percent of cocktail")
    public void testAlcoholPercentOfCocktail() {
        assertEquals(fullCocktail.getAlcoholPercent(), 1.9047619047619049);
    }

    /**
     * Tests if full cocktail is alcoholic
     */
    @Test
    @DisplayName("Testing if cocktail is alcoholic")
    public void testIsCocktailAlcohol() {
        assertTrue(fullCocktail.isAlcoholic());
    }

    /**
     * Tests volume of full cocktail
     */
    @Test
    @DisplayName("Testing volume of full cocktail")
    public void testIsCocktailVolume() {
        assertEquals(fullCocktail.getVolume(), 0.105);
    }


    /**
     * Tests to drop ice cube in empty cocktail
     */
    @Test
    @DisplayName("Testing to drop ice cube in cocktail")
    public void testDropIceCube() {
        IceCube icecube = new IceCube(0.5);
        assertEquals(emptyCocktail.dropIceCube(icecube), emptyCocktail);
    }

    /**
     * Tests if CocktailOverflowException is thrown when pouring juice
     */
    @Test
    @DisplayName("Testing if CocktailOverflowException is thrown when pouring juice")
    public void testCocktailOverflowsWithJuice() {
        assertThrows(CocktailOverflowException.class, () -> {
            fullCocktail.pour(mangoJuice).pour(mangoJuice).pour(mangoJuice)
                    .pour(mangoJuice).pour(mangoJuice).pour(mangoJuice)
                    .pour(mangoJuice).pour(mangoJuice).pour(mangoJuice)
                    .pour(mangoJuice).pour(mangoJuice).pour(mangoJuice);
        });
    }

    /**
     * Tests if CocktailOverflowException is thrown when a ice cubes is dropped in full cocktail
     */
    @Test
    @DisplayName("Testing if CocktailOverflowException is thrown when dropping ice cubes")
    public void testCocktailOverflowsWithIceCubes() {
        assertThrows(CocktailOverflowException.class, () -> {
            IceCube icecube = new IceCube(0.5);
            fullCocktail.dropIceCube(icecube);
        });
    }
}