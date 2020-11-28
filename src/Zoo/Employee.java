package Zoo;

import Animal.AbstractAnimal;
import Enclosure.AbstractEnclosure;

import java.awt.desktop.ScreenSleepEvent;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Employee extends AbstractAnimal{
    public double salary=0.0;

    public Employee(String name, SEX sex, int age){
        this.setName(name);
        this.setSex(sex);
        this.setAge(age);
    }

    public int getSalary() { return (int) salary; }

    public void setSalary(double salary) { this.salary = salary; }

    public void EarnSalary(Zoo zoo){
        this.monthsPasses(1);
        this.setSalary(getSalary() + (zoo.money*0.1));
    }

    public void inspect(AbstractEnclosure enclosure){
        System.out.println(this.getName() + " inspects enclosure named \""+ enclosure.getName() +"\"...");
        System.out.println("Enclosure type : " + enclosure.getType());
        System.out.println("Total Population : " + enclosure.getPopulation());
        enclosure.begin();
        while(enclosure.hasNext()){
            System.out.println( enclosure.getResident().toString());
        }
    }

    public void cleanup(AbstractEnclosure enclosure){
        try{
            enclosure.maintenance();
        }
        catch (Exception e){
            System.out.println("The enclosure \"" + enclosure.getName()+ "\" must be empty AND messy to be cleaned");
        }
    }

    public void feedAnimals(AbstractEnclosure enclosure){
        enclosure.begin();
        while(enclosure.hasNext())
        {
            AbstractAnimal currentAnimal = enclosure.getResident();
            try
            {
                currentAnimal.wake();
                currentAnimal.feed();
            }
            catch (Exception e)
            {
                // Shouldn't Ever happend ! As we wake them first, we can (normally) feed them
                e.printStackTrace();
            }
        }
    }

    public void transferOne(AbstractEnclosure from, AbstractEnclosure to, int index){
        if (to.getPopulation() + 1 <= to.getMaximalPopulation()){
            to.addResident(from.getResident(index));
            from.removeResident(index);
        }
        else
        {
            System.out.println( to.getName() + " cannot handle " + from.getName() + " animal (not enough space !)");
        }
    }

    public void transferAll(AbstractEnclosure from, AbstractEnclosure to){
        if (from.getType().equals(to.getType()))
        {
            if (to.getMaximalPopulation() - to.getPopulation() >= from.getPopulation()){
                from.begin();
                while(from.hasNext()){
                    to.addResident(from.pullResident());
                }
                System.out.println("Enclosure transferred");
            }
            else
            {
                System.out.println( to.getName() + " cannot handle " + from.getName() + " animals (not enough space !)");
            }
        }
        else
        {
            System.out.println( from.getName() + " and " + to.getName() + " do not handle the same type of animals");
        }
    }

    /**
     * MENU / INTERACTIONS
     */

    public void startMenu(ArrayList<AbstractEnclosure> enclosures, int actionNumber){
        while(actionNumber > 0){
            System.out.println("--- Employee : " + this.getName() + " ---");
            System.out.println(" 1 - Inspect");
            System.out.println(" 2 - Cleanup");
            System.out.println(" 3 - Feed Animals");
            System.out.println(" 4 - Transfert");
            int choice = -1;
            Scanner in = new Scanner(System.in);
            while(!(choice >= 1 && choice <=4)){
                System.out.print(" > ");
                choice = in.nextInt();
            }
            System.out.println("");
            switch (choice){
                case 1:
                    System.out.println("Enclosure to inspect : ");
                    this.inspect(enclosureChoice(enclosures));
                    break;
                case 2:
                    System.out.println("Enclosure to Cleanup : ");
                    this.cleanup(enclosureChoice(enclosures));
                    break;
                case 3:
                    System.out.println("Enclosure to feed animals in : ");
                    this.feedAnimals(enclosureChoice(enclosures));
                    break;
                case 4:
                    System.out.println("Enclosure to transfer from : ");
                    AbstractEnclosure from = enclosureChoice(enclosures);
                    System.out.println("Enclosure to transfer to: ");
                    AbstractEnclosure to = enclosureChoice(enclosures);
                    transferAll(from, to);
                    break;
            }
            actionNumber--;
        }
    }

    public AbstractEnclosure enclosureChoice(ArrayList<AbstractEnclosure> enclosures){
        for(int i=0; i<enclosures.size(); i++){
            System.out.println(" " + (i+1) + " - " + enclosures.get(i).getName() +
                    "("+
                    "Population : " + (enclosures.get(i).getPopulation()) + ", "+
                    "Health : " + (enclosures.get(i).getAverageHealth())+"/15, "+
                    "Hunger : " + (enclosures.get(i).getAverageHealth())+"/15"+
                    ")"
            );
        }
        int choice = -1;
        Scanner in = new Scanner(System.in);
        while(!(choice >= 1 && choice <=enclosures.size())){
            System.out.print(" > ");
            choice = in.nextInt();
        }
        return enclosures.get(choice-1);
    }
}
