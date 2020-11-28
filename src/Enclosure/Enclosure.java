package Enclosure;

import Animal.AbstractAnimal;

public class Enclosure<AnimalType extends AbstractAnimal> extends AbstractEnclosure{
    public Enclosure(String name, int surface, int maximalPopulation) {
        super(name, surface, maximalPopulation);
        this.setType(ENCLOSURE_TYPE.NORMAL);
    }
}
