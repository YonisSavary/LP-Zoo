package Species;

import Animal.Animal;
import Animal.Marin;

public class Shark extends Animal implements Marin {
    public Shark(Animal origin) {
        super(origin);
        this.sound = "Ahah yes.";
    }
    public Shark() { super("Shark", SEX.MALE, 200); }

    @Override
    public String swim() {
        return this.doAction("is swiming");
    }

    @Override
    public String land() {
        return this.doAction("has landed");
    }
}
