package at.fhj.iit;

import java.util.ArrayList;
import java.util.List;

public class Cocktail extends Drink {

    /**
     * Creates a Drink object with given name
     *
     * @param name name of the drink
     */
    public Cocktail(String name, double maxVolume) {
        super(name);
        this.maxVolume = maxVolume;
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
     * Creating ArrayList with ice cubes
     */
    List<IceCube> iceCubes = new ArrayList<IceCube>();

    /**
     * The max volume of the cocktail including ice
     */
    private double maxVolume;

    /**
     * Pours a liquid into the cocktail
     *
     * @param liquidToAdd the liquid to add
     *
     * @throws CocktailOverflowException if the cocktail has overflowed
     *
     * @return the Cocktail object on which the method was called
     */
    public Cocktail pour(Liquid liquidToAdd) {

        double volumeOfLiquid = liquidToAdd.getVolume();
        double alcoholOfLiquid = liquidToAdd.getAlcoholPercent() * volumeOfLiquid / 100;

        cocktailVolume += volumeOfLiquid;
        alcoholVolume += alcoholOfLiquid;

        if(getVolume() > maxVolume) {
            throw new CocktailOverflowException();
        }

        return this;
    }

    /**
     * Adds an ice cube to the cocktail mix
     *
     * @param iceCube the ice cube to add
     *
     * @throws CocktailOverflowException if the cocktail has overflowed
     *
     * @return the Cocktail object on which the method was called
     */
    public Cocktail dropIceCube(IceCube iceCube) {

        iceCubes.add(iceCube);

        if(getVolume() > maxVolume) {
            throw new CocktailOverflowException();
        }

        return this;
    }

    /**
     * Calculates and returns volume of drink
     *
     * @return the volume of drink including ice cubes in liters
     */
    @Override
    public double getVolume() {

        double  iceCubeVolume = 0;

        for(IceCube iceCube : iceCubes) {
            iceCubeVolume += iceCube.getVolume();
        }

        return iceCubeVolume + cocktailVolume;
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

        double alcoholRatio = alcoholVolume / getVolume();

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
        return getAlcoholPercent() >= 0.1;
    }

}
