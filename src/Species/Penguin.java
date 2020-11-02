package Species;

import Animal.Animal;
import Animal.Flying;
import Animal.Marin;

public class Penguin extends Animal implements Flying, Marin {
    public Penguin(Animal origin) {
        super(origin);
        this.sound = "screeching";
    }
    public Penguin() { super("Penguin", SEX.MALE, 30); }

    @Override
    public String fly() {
        return this.doAction("begin to fly");
    }

    @Override
    public String swim() {
        return this.doAction("is swiming");
    }

    @Override
    public String land() {
        return this.doAction("has landed");
    }
}
