package Enclosure;

import Animal.AbstractAnimal;
import Species.Wolf;
import Species.WolfPack;

import java.util.ArrayList;

public class WolfColonny extends AbstractEnclosure{
    private boolean special = true;
    private int residents = 0;
    private int packCursor = 0;
    private int wolfCursor = 0;
    ArrayList<WolfPack> packs = new ArrayList<WolfPack>();

    public WolfColonny(String name, int surface, int maximalPopulation) {
        super(name, surface, maximalPopulation);
    }

    @Override
    public void monthsPasses(float monthsNumber) {
        for(WolfPack wp: this.packs){
            wp.monthPasses(monthsNumber);
        }
    }

    @Override
    public int getPopulation() {
        return residents;
    }

    public void addPack(WolfPack newPack){
        if (residents+newPack.getResidents() <= maximalPopulation){
            packs.add(newPack);
            residents+=newPack.getResidents();
        }
    }
    public void removePack(int index){
        packs.remove(index);
    }
    public void getPack(int index){
        packs.get(index);
    }


    public void begin(){
        packCursor = 0;
        wolfCursor = 0;
    }

    public boolean hasNext() {
        if (wolfCursor < packs.get(packCursor).getResidents()-1) {
            wolfCursor++;
            return true;
        } else if (wolfCursor == packs.get(packCursor).getResidents()-1){
            if (packCursor < packs.size()-1)
            {
                packCursor++;
                wolfCursor=0;
                return true;
            } else if (packCursor == packs.size()-1){
                return false;
            }
        }
        return false;
    }

    public AbstractAnimal getResident(){
        return packs.get(packCursor).getWolf(wolfCursor);
    }
}
