package Enclosure;

import Animal.AbstractAnimal;
import java.util.ArrayList;

public abstract class AbstractEnclosure <AnimalType extends AbstractAnimal> {
    public static enum CLEANLINESS {CLEAN, NORMAL, MESSY};
    String name;
    int surface = 10; // Surface in meter square
    int maximalPopulation = 10;
    int population = 0;
    int cursor = 0;
    String type="Classical";
    public CLEANLINESS cleanliness = CLEANLINESS.NORMAL;
    ArrayList<AnimalType> residents = new ArrayList<AnimalType>();

    public AbstractEnclosure(String name, int surface, int maximalPopulation){
        this.setName(name);
        this.setSurface(surface);
        this.setMaximalPopulation(maximalPopulation);
    }

    // Getters
    public String getName()                                 { return this.name; }
    public int getSurface()                                 { return this.surface; }
    public int getMaximalPopulation()                       { return this.maximalPopulation; }
    public int getPopulation()                              { return this.population; }
    public CLEANLINESS getCleanliness()                     { return this.cleanliness; }
    public String getType()                                 { return this.type; }
    // Setters
    public void setType(String type)                        { this.type = type; }
    public void setName(String name)                        { this.name = name; }
    public void setSurface(int surface)                     { this.surface = surface; }
    public void setMaximalPopulation(int maximalPopulation) { this.maximalPopulation = maximalPopulation; }
    //public void setPopulation(int population)             { this.population = population; }
    protected void setCleanliness(CLEANLINESS cleanliness)     { this.cleanliness = cleanliness; }

    public int getCursor(){
        return this.cursor;
    }

    public void begin(){
        this.cursor = this.residents.size()-1;
    }

    public void update()
    {
        this.population = this.residents.size();
    }

    public boolean hasNext(){
        return (this.cursor >= 0);
    }

    public AbstractAnimal pullResident(){
        AbstractAnimal pulled = this.residents.get(this.cursor);
        this.residents.remove(this.cursor);
        this.cursor--;
        this.update();
        return pulled;
    }

    public AbstractAnimal getResident(){
        return this.residents.get(this.cursor--);
    }

    public AbstractAnimal getResident(int index){
        return this.residents.get(index);
    }

    public void addResident(AnimalType newAnimal){
        this.residents.add(newAnimal);
        this.update();
    }

    public void removeResident(int index){
        this.residents.remove(index);
        this.update();
    }

    public float getAverageHealth(){
        if(this.residents.size()==0) return (float) 15.0;
        float total = 0;
        for(int i=0; i<this.residents.size(); i++){
            total += this.residents.get(i).getRawHealth();
        }
        return total/this.residents.size();
    }

    public float getAverageHunger(){
        if(this.residents.size()==0) return (float) 15.0;
        float total = 0;
        for(int i=0; i<this.residents.size(); i++){
            total += this.residents.get(i).getRawHunger();
        }
        return total/this.residents.size();
    }

    public void maintenance() throws Exception {
        if (this.population==0 && this.cleanliness==CLEANLINESS.MESSY)
        {
            this.cleanliness=CLEANLINESS.CLEAN;
        }
        else
        {
            throw new Exception("This Enclosure still have animals inside or isn't enough messy !");
        }
    }
}
