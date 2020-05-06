package at.fhj.iit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CocktailTest {

    private Liquid water, vodka, cream, mangoJuice;
    private Cocktail c1, c2;

    @BeforeEach
    void setUp() {
        // SETUP PHASE
        water = new Liquid("Wasser", 0.3, 0);
        vodka = new Liquid("Wodka", 0.05, 39.90);
        cream = new Liquid("Obers", 0.2, 0);
        mangoJuice = new Liquid("Mangosaft", 0.5, 0.01);

        c1 = new Cocktail("cocktail 1");
        c2 = new Cocktail("cocktail 2");

        c1.pour(water);
        c1.pour(vodka);
        c1.pour(cream);
        c1.pour(mangoJuice);
    }

    @Test
    @DisplayName("Testing if empty cocktail has zero volume")
    public void testEmptyCocktailIsEmpty() {
        assertEquals(0, c2.getVolume());
    }

    @Test
    @DisplayName("Testing if empty cocktail has zero alcohol")
    public void testEmptyCocktailHasNoAlcohol() {
        assertEquals(0, c2.getAlcoholPercent());
    }


    @Test
    @DisplayName("Testing pour method")
    public void testPourMethod() {
        assertEquals(c1.pour(water), c1);
    }
}