package Animal;

import Enclosure.Aviary;

public class Animal extends AbstractAnimal {
    public Animal(Animal origin)
    {
        this.setSleeping  (origin.isSleeping());
        this.setHealth    (origin.getRawHealth());
        this.setHunger    (origin.getRawHunger());
        this.setName      (origin.getName());
        this.setSex       (origin.getSex());
        this.setSize      (origin.getSize());
        this.setAge       (origin.getAge());
        this.setWeight    (origin.getWeight());
    }

    public Animal(String name, SEX sex, int size) {
        super(name, (Math.random()>0.5)? SEX.FEMALE : SEX.MALE, size);
    }

    public Egg layEgg() {
        if (this.getSex() == this.getBirthGiver())
        {
            Animal newChild = new Animal(
                    this.getName() + " Jr.",
                    (Math.random()>0.5)? SEX.FEMALE : SEX.MALE,
                    (int) (this.getSize()*0.1)
            );
            newChild.setWeight((int) (this.getWeight()*0.1));
            newChild.setHunger((byte)8);
            newChild.setHealth((byte)8);

            Egg newEgg  = new Egg(newChild);
            return newEgg;
        }
        else
        {
            return null;
        }
    }
}
