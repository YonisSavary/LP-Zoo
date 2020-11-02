package Enclosure;

import Animal.AbstractAnimal;
import Animal.Marin;

public class Aquarium<AnimalType extends AbstractAnimal & Marin> extends AbstractEnclosure{
    private short depth = 5;
    private short salinity = 0;

    public Aquarium(String name, int surface, int maximalPopulation) {
        super(name, surface, maximalPopulation);
        this.setType("Aquarium");
    }
}
