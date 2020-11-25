import Animal.AbstractAnimal;
import Zoo.Employee;
import Zoo.Zoo;
import Animal.Names;
import Enclosure.WolfColonny;
import Species.Wolf;
import Species.WolfPack;

public class Main {
    public static void main(String[] main){
        Wolf[] wolves = new Wolf[10];
        WolfPack wp0 = new WolfPack();
        for(int i=0; i<10; i++){
            wolves[i] = new Wolf();
            int nameIndex = (int) Math.floor(Math.random()*15);
            wolves[i].setName( Names.names[nameIndex]);
            wp0.addWolf(wolves[i]);
        }

        WolfColonny wc0 = new WolfColonny("colonnie 1", 200, 100);
        wc0.addPack(wp0);

        Employee employee0 = new Employee("Zop Guadian", AbstractAnimal.SEX.MALE, 30);
        Zoo zop = new Zoo("Zop", employee0);
        zop.addEnclosure(wc0);
        zop.start();
    }
}
