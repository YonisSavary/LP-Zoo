package Species;

import Animal.Animal;
import Animal.Marin;

public class ClownFish extends Animal implements Marin {
    public ClownFish(Animal origin) {
        super(origin);
        this.sound = "gloup gloup";
        this.power = 1;
    }
    public ClownFish() {
        super("ClownFish", SEX.MALE, 5);
    }

    @Override
    public String swim() {
        return this.doAction("is swiming");
    }

    @Override
    public String land() {
        return this.doAction("landed");
    }
}
