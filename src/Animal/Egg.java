package Animal;

public class Egg{
    private Animal content;
    boolean hatched = false;

    public Egg (Animal child)
    {
        this.content = child;
    }

    public Animal hatch()
    {
        this.hatched = true;
        return this.content;
    }

}
