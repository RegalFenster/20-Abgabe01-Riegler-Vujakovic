package at.fhj.iit;

public class Cocktail extends Drink {

    /**
     * Creates a Drink object with given name
     *
     * @param name name of the drink
     */
    public Cocktail(String name) {
        super(name);
    }

    /**
     * Calculates and returns volume of drink
     *
     * @return the volume of drink in liter
     */
    @Override
    public double getVolume() {
        return 0;
    }

    /**
     * Calculates and returns the alcohol percentage
     *
     * @return alcohol volume percent (e.g. 50)
     */
    @Override
    public double getAlcoholPercent() {
        return 0;
    }

    /**
     * Gives information if drink is alcoholic or not
     *
     * @return true when alcoholic liquids are present, otherwise false
     *         An exception is made for liquids such as apple juice,
     *         which contain a negligible amount of alcohol.
     */
    @Override
    public boolean isAlcoholic() {
        return getAlcoholPercent() <= 0.1;
    }
}
