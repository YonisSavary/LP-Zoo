package Species;

import Animal.MammalAnimal;
import Animal.Marin;

public class Whale extends MammalAnimal implements Marin {
    public Whale(MammalAnimal origin) {
        super(origin);
        this.sound = "WOOOOOOOOOOOOOOOOOO";
    }
    public Whale() { super("Whale", SEX.MALE, 5000); }

    @Override
    public String swim() {
        return this.doAction("is swiming");
    }

    @Override
    public String land() {
        return this.doAction("has landed");
    }
}
