package at.fhj.iit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CocktailTest {

    private Liquid water, vodka, cream, mangoJuice;
    private Cocktail fullCocktail, emptyCocktail;

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

    @Test
    @DisplayName("Testing if empty cocktail has zero volume")
    public void testEmptyCocktailIsEmpty() {
        assertEquals(0, emptyCocktail.getVolume());
    }

    @Test
    @DisplayName("Testing if empty cocktail has zero alcohol")
    public void testEmptyCocktailHasNoAlcohol() {
        assertEquals(0, emptyCocktail.getAlcoholPercent());
    }


    @Test
    @DisplayName("Testing pour method")
    public void testPourMethod() {
        assertEquals(fullCocktail.pour(water), fullCocktail);
    }


    @Test
    @DisplayName("Testing alcohol percent of cocktail")
    public void testAlcoholPercentOfCocktail() {
        assertEquals(fullCocktail.getAlcoholPercent(), 1.9047619047619049);
    }

    @Test
    @DisplayName("Testing if cocktail is alcoholic")
    public void testIsCocktailAlcohol() {
        assertTrue(fullCocktail.isAlcoholic());
    }

    @Test
    @DisplayName("Testing to drop icecube in cocktail")
    public void testDropIceCube() {
        IceCube icecube = new IceCube(0.5);
        assertEquals(emptyCocktail.dropIceCube(icecube), emptyCocktail);
    }

    /**
     * Testing if CocktailOverflowException is thrown when pouring juice
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
     * Testing if CocktailOverflowException is thrown when dropping ice cubes
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