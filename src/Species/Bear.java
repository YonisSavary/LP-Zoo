package Species;

import Animal.MammalAnimal;

public class Bear extends MammalAnimal{
    public Bear(MammalAnimal origin) {
        super(origin);
        this.sound = "roar";
    }
    public Bear() {
        super("Bear", SEX.MALE, 200);
    }

}
