package Species;

import Animal.Animal;
import Animal.Flying;

public class Eagle extends Animal implements Flying {
    public Eagle(Animal origin) {
        super(origin);
        this.sound = "REEE";
        this.power = 4;
    }
    public Eagle() { super("Eagle", SEX.MALE, 100); }

    @Override
    public String fly() {
        return this.doAction("now flying !");
    }

    @Override
    public String land() {
        return this.doAction("landed");
    }
}
