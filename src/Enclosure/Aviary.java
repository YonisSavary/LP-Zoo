package Enclosure;

import Animal.AbstractAnimal;
import Animal.Flying;

/**
 * Basically a Enclosure, but only for Flying animals !
 * @param <AnimalType>
 */
public class Aviary<AnimalType extends AbstractAnimal & Flying> extends AbstractEnclosure {
    private short height = 7;

    public Aviary(String name, int surface, int maximalPopulation) {
        super(name, surface, maximalPopulation);
        this.setType(ENCLOSURE_TYPE.AVIARY);
    }
}
