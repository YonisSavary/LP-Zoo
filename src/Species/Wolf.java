package Species;

import Animal.MammalAnimal;
import Animal.Wanderer;
import Species.WolfPack;

public class Wolf extends MammalAnimal implements Wanderer{
    public enum ageEnum {YOUNG, ADULT, OLD};

    private ageEnum ageCategory = ageEnum.YOUNG;
    private byte strengh = 4;
    private byte dominationFactor = 4;
    private byte rankDomination = 4;
    private float level = 4;
    private byte impetuosity = 4;
    private WolfPack pack = null;

    // Selon internet, l'esperance de vie d'un loup en vie sauvage est de 6 à 8 ans*
    // Ici dans un zoo on considèrera qu'un loup vivra jusqu'à 10ans inclus (il meurt à 11)
    // [1-3] => young
    // [4-6] => adult
    // [8-10] => old

    public ageEnum getAgeCategory() { return ageCategory; }
    public byte getStrengh() { return strengh; }
    public byte getDominationFactor() { return dominationFactor; }
    public byte getRankDomination() { return rankDomination; }
    public byte getImpetuosity() { return impetuosity; }
    public float getLevel()      { return calculateLevel(); }

    public void setAgeCategory(ageEnum ageCategory) { this.ageCategory = ageCategory; }
    public void setStrengh(byte strengh) { this.strengh = strengh; }
    public void setDominationFactor(byte dominationFactor) { this.dominationFactor = dominationFactor; }
    public void setRankDomination(byte rankDomination) { this.rankDomination = rankDomination; }
    public void setImpetuosity(byte impetuosity) { this.impetuosity = impetuosity; }

    public void increaseImpetuosity() {
        this.impetuosity = (this.impetuosity < 7 )? (byte) (impetuosity + 1) : impetuosity;
        this.dominationFactor++;
    }

    public void decreaseImpetuosity() {
        this.impetuosity = (this.impetuosity < 7 )? (byte) (impetuosity - 1) : impetuosity;
        this.dominationFactor--;
    }

    public float calculateLevel(){
        byte levelAgeFactor = 3;
        switch ((int) this.getAge()){
            case 1,2,3 :
                levelAgeFactor = 1;
                break;
            case 4,5,6 :
                levelAgeFactor = 3;
                break;
            case 7,8,9,10:
                levelAgeFactor = 2;
                break;
        }
        this.level = ((rankDomination+dominationFactor+impetuosity)/3 + (levelAgeFactor));
        return this.level;
    }

    public void monthsPasses(float monthsNumber){
        super.monthsPasses(monthsNumber);
        switch ((int) this.getAge()){
            case 1,2,3 :
                ageCategory = ageEnum.YOUNG;
                break;
            case 4,5,6 :
                ageCategory = ageEnum.ADULT;
                break;
            case 7,8,9,10:
                ageCategory = ageEnum.OLD;
                break;
        }
        if (this.getAge() > 10.0) this.die();
    }

    public void challenge(Wolf opponent){
        if (opponent.getLevel() <= this.getLevel() ) {
            opponent.decreaseImpetuosity();
            opponent.peacefulEmit();
            this.increaseImpetuosity();
            this.aggressiveEmit();
        } else {
            opponent.increaseImpetuosity();
            opponent.aggressiveEmit();
            this.decreaseImpetuosity();
            this.peacefulEmit();
        }
    }

    public Wolf(MammalAnimal origin) {
        super(origin);
        this.sound = "Ahwoo";
    }
    public Wolf() { super("Wolf", (Math.random() > 0.5)? SEX.FEMALE: SEX.MALE, 150); }

    @Override
    public String wander() { return this.doAction("wander"); }

    @Override
    public String rest() { return this.doAction("is resting"); }

    public void dominateEmit()      { if (!this.dead) System.out.println("* try to dominate with some " + this.sound + " (level " + this.getLevel() + ") *"); }
    public void aggressiveEmit()    { if (!this.dead) System.out.println("* aggressively emit some " + this.sound + " (level " + this.getLevel() + ") *"); }
    public void peacefulEmit()      { if (!this.dead) System.out.println("* peacefully  emit some " + this.sound + " (level " + this.getLevel() + ") *"); }
    public void emit()              { if (!this.dead) System.out.println("* " + this.sound + " (level " + this.getLevel() + ") *"); }
    public void howl()              { this.emit(); }

    public boolean isLone() { return (this.pack == null); }
}
