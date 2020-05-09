# Software Configuration Management #

## Drinks Template for Exercise ###

# 20-Abgabe01-Riegler-Vujakovic
first exercise Konfigurationsmanagement

## Overall plan for the excercise

- [x] First subclass Cocktail
- [x] Second subclass IceCube
- [x] JUnit Test for SimpleDrinkClass
- [X] JUnit Test for CocktailClass
- [X] Exceptions for CocktailClass
- [ ] Create the final report
- [ ] :partying_face:


## Plan for the first subclass Cocktail

The first subclass of the cocktail class will be able to hold 
mixed drinks from an infinite number of ingredients. 
It will calculate the alcohol content accordingly.

## Plan for the second subclass Icecube

The second subclass will allow to add simple icecubes to the cocktails with the plan to
use this class for the later used Overflow OverflowException.

The code snippet for the ice cube drop in the CoktailClass:
```java
public Cocktail dropIceCube(IceCube iceCube) {

        iceCubes.add(iceCube);

        if(getVolume() > maxVolume) {
            throw new CocktailOverflowException();
        }

        return this;
    }
```
## Plan for JUnit Tests

Implement JUnit Tests for subclass Cocktail and SimpleDrink and test for 100% coverage.
The existing methods in Cocktail and SimpleDrinks will be used.

## Plan for Exceptions in CocktailClass

Implement a list for the icecubes a cocktail can hold and try to catch an OverflowException when too much icecubes are dropped.

