package Animal;

public class MammalAnimal extends AbstractAnimal{
    public MammalAnimal(MammalAnimal origin)
    {
        this.setSleeping    (origin.isSleeping());
        this.setHealth      (origin.getRawHealth());
        this.setHunger      (origin.getRawHunger());
        this.setName        (origin.getName());
        this.setSex         (origin.getSex());
        this.setSize        (origin.getSize());
        this.setAge         (origin.getAge());
        this.setWeight      (origin.getWeight());
    }

    public MammalAnimal(String name, SEX sex, int size) {
        super(name, (Math.random()>0.5)? SEX.FEMALE : SEX.MALE, size);
    }

    /**
     * Create a new Animal as this object children with theses props:
     * - 10% of the animal size
     * - 10% of the animal weight
     * - 50% chance for the children to be MALE/FEMALE
     * - 50/255 health
     * - Name as "<animal_name> Jr."
     * @throws CloneNotSupportedException throwed if java can't clone this animal into a new object
     */
    public MammalAnimal giveBirth() {
        if (this.getSex() == this.getBirthGiver())
        {
            MammalAnimal newChild = new MammalAnimal(
                    this.getName() + " Jr.",
                    (Math.random()>0.5)? SEX.FEMALE : SEX.MALE,
                    (int) (this.getSize()*0.1)
            );
            newChild.setWeight((int) (this.getWeight()*0.1));
            newChild.setHunger((byte)8);
            newChild.setHealth((byte)8);

            return newChild;
        }
        else
        {
            return null;
        }
    }
}
