import Animal.AbstractAnimal;
import Animal.MammalAnimal;
import Species.Wolf;
import Zoo.Employee;
import Zoo.Zoo;

public class Main {
    public static void main(String[] main){
        Employee employee0 = new Employee("Zop Guadian", AbstractAnimal.SEX.MALE, 30);
        Zoo zop = new Zoo("Zop", employee0);
        zop.start();
    }
}
