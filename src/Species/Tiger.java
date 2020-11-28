package Species;

import Animal.MammalAnimal;
import Animal.Wanderer;

public class Tiger extends MammalAnimal implements Wanderer{
    public Tiger(MammalAnimal origin) {
        super(origin);
        this.sound = "roar";
        this.power = 8;
    }
    public Tiger() { super("Tiger", SEX.MALE, 150); }

    @Override
    public String wander() { return this.doAction("wander"); }

    @Override
    public String rest() { return this.doAction("is resting"); }
}
