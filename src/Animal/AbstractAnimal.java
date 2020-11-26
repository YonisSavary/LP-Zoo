package Animal;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Abstract Class for Animals (All Kind, Marin, Earthly...etc)
 *
 * @author Yonis SAVARY
 * @version 1.0
 */
public abstract class AbstractAnimal {
    // Enums
    public enum SEX {MALE, FEMALE}
    /**
     * Both hunger and health are stored in byte variables
     * every four units represent a step in these array :
     * For example :
     *  00 => 03 : STARVING (index : 00/4 = 0)
     *  04 => 07 : HUNGRY   (index : 04/4 = 1)
     *  08 => 11 : FEED     (index : 08/4 = 2)
     *  12 => 15 : FILLED   (index : 12/4 = 3)
     *
     *  getHealth and getHunger return both a string that
     *  represent a health state for the animal, to get
     *  the numeral value, you can call getRawHealth() or
     *  getRawHunger()
     */
    public static String[] HUNGER = {"STARVING", "HUNGRY", "FEED" ,"FILLED"};
    public static String[] HEALTH = {"DEAD", "DISEASED", "OKAY", "HEALTHY"};
    // Props
    private String      name = "Animal";
    private SEX         sex = SEX.MALE;
    private SEX         birthGiver = SEX.FEMALE;
    private int         weight = 0;             // Weight in Kg
    private int         size = 0;               // Height or Width in Cm
    private float       age = 1;
    protected String    sound = "roar";

    // An animal is independent if it can feed itself and maintain itself in good health
    protected boolean dependant = true;
    // Health Situation
    protected byte      health = 8; // OKAY BY DEFAULT
    protected byte      hunger = 8; // FEED BY DEFAULT
    protected boolean   sleeping = false;
    protected boolean   dead = false;

    // Used for graphical
    protected String color = "#C5FF00";

    public AbstractAnimal(){}

    /**
     * Basic Constructor for Animals
     * @param name Animal Specie (or nickname)
     * @param sex Either SEX.MALE or SEX.FEMALE
     * @param size Size in Centimeters
     */
    public AbstractAnimal(String name, SEX sex, int size)
    {
        this.setName(name);
        this.setHealth((byte) 12);
        this.setSex(sex);
        this.setSize(size);
        this.setSleeping(false);
    }

    public void emit()  { if (!this.dead) this.doAction("do a " + this.sound); }

    public void heal()  { if (!this.dead) this.setHealth((byte)12);}

    public void sleep() { setSleeping(true); }
    public void wake()  { if (!this.dead) setSleeping(false); }

    // Basic setters
    public void     setName(String name)            { this.name = name; }
    protected void  setSex(SEX sex)                 { this.sex = sex; }
    protected void  setWeight(int weight)           { this.weight = weight; }
    protected void  setSize(int size)               { this.size = size; }
    protected void  setSleeping(boolean sleeping)   { this.sleeping = sleeping;}
    protected void  setHunger(byte hunger)          { this.health = hunger;}
    protected void  setHealth(byte health)          { this.health = health;}
    public void     setAge(float age)               { this.age = age; }
    public void     setBirthGiver(SEX birthGiver)   { this.birthGiver = birthGiver; }
    public void     setSound(String newSound)       { this.sound = newSound;}
    public void     die()                           { this.dead = true; this.health = 0; }
    // Basic getters
    public String   getName()                       { return name; }
    public SEX      getSex()                        { return sex; }
    public int      getWeight()                     { return weight; }
    public int      getSize()                       { return size; }
    public boolean  isSleeping()                    { return sleeping;}
    public float    getAge()                        { return age; }
    public SEX      getBirthGiver()                 { return birthGiver; }
    public String   getHealth()                     { return HEALTH[health/4];}
    public byte     getRawHealth()                  { return health; }
    public String   getHunger()                     { return HUNGER[hunger/4];}
    public byte     getRawHunger()                  { return hunger; }
    public boolean  isDependant()                   { return dependant;}
    public boolean  isDead()                        { return dead;}

    public void     setColor(String newC)           { this.color = newC; }
    public String   getColor()                      { return color; }

    /**
     * @param action action description
     * @return a string with this format " * <animal_name>: <given_action> * "
     */
    public String doAction (String action)
    {
        if (!this.dead) return this.getName() +" is still dead. Bro momento";
        return " * " + this.getName() + ": " + action + " * ";
    }

    public void monthsPasses(){
        this.monthsPasses(1);
    }

    public void monthsPasses(float monthsNumber){
        this.setAge( age + (monthsNumber/12) );
        if(this.isDependant())
        {
            //Randomly subtract 1 to 4 to both hunger and health status
            this.setHealth((byte) (health-((int) Math.floor(Math.random()*2*monthsNumber)))  );
            this.setHunger((byte) (hunger-((int) Math.floor(Math.random()*2*monthsNumber)))  );
        }
    }

    public void feed(){
        if (!this.isSleeping()) this.hunger += (this.hunger >= 13)? 0 : 2;
    }


    @Override
    public String toString() {
        return "Animal : " +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", weight=" + weight +
                ", size=" + size +
                ", age=" + age +
                ", hunger=" + hunger +
                ", sleeping=" + sleeping +
                ", health=" + health;
    }
}
