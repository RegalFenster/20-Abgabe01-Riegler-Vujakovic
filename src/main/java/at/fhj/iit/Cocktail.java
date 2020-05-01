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
     * The total volume of the cocktail
     */
    private double cocktailVolume = 0;

    /**
     * The total volume of the cocktail's alcohol
     */
    private double alcoholVolume = 0;

    /**
     * Pours a liquid into the cocktail
     *
     * @param liquidToAdd the liquid to add
     */
    public Cocktail pour(Liquid liquidToAdd) {

        double volumeOfLiquid = liquidToAdd.getVolume();
        double alcoholOfLiquid = liquidToAdd.getAlcoholPercent() * volumeOfLiquid / 100;

        cocktailVolume += volumeOfLiquid;
        alcoholVolume += alcoholOfLiquid;

        return this;
    }

    /**
     * Calculates and returns volume of drink
     *
     * @return the volume of drink in liter
     */
    @Override
    public double getVolume() {
        return cocktailVolume;
    }

    /**
     * Calculates and returns the alcohol percentage
     *
     * @return alcohol volume percent (e.g. 50)
     */
    @Override
    public double getAlcoholPercent() {

        if (cocktailVolume == 0) {
            return 0;
        }

        double alcoholRatio = alcoholVolume / cocktailVolume;

        return alcoholRatio * 100;
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
