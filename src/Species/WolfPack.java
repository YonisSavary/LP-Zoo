package Species;

import Animal.AbstractAnimal;

import java.util.ArrayList;

public class WolfPack {
    private ArrayList<Wolf> members = new ArrayList<Wolf>();
    private String signal = "Eheh boi !";
    private Wolf alphaMale = null;
    private Wolf alphaFemale = null;
    private float monthCount = 0;
    private byte birthGiven = 0;

    public void addWolf(Wolf newWolf){
        if (alphaFemale == null && newWolf.getSex() == AbstractAnimal.SEX.FEMALE)   alphaFemale = newWolf;
        if (alphaMale == null   && newWolf.getSex() == AbstractAnimal.SEX.MALE)     alphaMale = newWolf;
        newWolf.setSound(this.signal);
        members.add(newWolf);
    }

    public void removeWolf(int index){
        members.get(index).setSound("Awooh");
        members.remove(index);
    }

    public int getResidents(){
        return this.members.size();
    }

    public Wolf getWolf(int index){
        return members.get(index);
    }

    public void monthPasses(float monthsNumber){
        monthCount+=monthsNumber;
        for(Wolf w : this.members){
            w.monthsPasses(monthsNumber);
            w.setDominationFactor((byte) (monthsNumber*0.2));
        }

        //Utilisation d'un Bubble sort | en assumant qu'une meute aura
        //grand max une trentaine de loups, c'est pas bien grâve
        boolean toSort = true;
        Wolf tempWolf, actual, previous = null;
        while(toSort){
            toSort = false ;
            for(int i=1; i<this.members.size(); i++){
                actual = this.members.get(i);
                previous = this.members.get(i-1);
                if (actual.getDominationFactor() < previous.getDominationFactor()){
                    tempWolf = actual;
                    actual = previous;
                    previous = tempWolf;
                    toSort = true;
                }
            }
        }

        alphaFemale = null;
        alphaMale = null;
        for (Wolf w : this.members){
            if (alphaFemale == null && w.getSex() == AbstractAnimal.SEX.FEMALE) {
                alphaFemale = w;
                alphaFemale.aggressiveEmit();
            }
            if (alphaMale == null   && w.getSex() == AbstractAnimal.SEX.MALE){
                alphaMale = w;
                alphaFemale.aggressiveEmit();
            }

            if (Math.random()>0.75){
                w.emit();
            }
        }

        if (monthCount > 6 && birthGiven<14){
            int litter = (int) Math.floor(Math.random()*7.0);
            for (int i=0; i<litter; i++){
                this.addWolf(new Wolf(alphaFemale.giveBirth()));
            }
        }

        if (monthCount > 12) {
            birthGiven = 0;
            monthCount = 0;
        }
    }

    @Override
    public String toString() {
        return "WolfPack{" +
                "members=" + members.size() +
                ", signal='" + signal + '\'' +
                ", alphaMale=" + alphaMale.getName() +
                ", alphaFemale=" + alphaFemale.getName() +
                '}';
    }

    public void describeWolf(int index){
        System.out.println(this.getWolf(index).toString());
    }
}
