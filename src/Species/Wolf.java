package Species;

import Animal.MammalAnimal;
import Animal.Wanderer;

public class Wolf extends MammalAnimal implements Wanderer{
    public Wolf(MammalAnimal origin) {
        super(origin);
        this.sound = "Ahwoo";
    }
    public Wolf() { super("Wolf", SEX.MALE, 150); }

    @Override
    public String wander() { return this.doAction("wander"); }

    @Override
    public String rest() { return this.doAction("is resting"); }
}
