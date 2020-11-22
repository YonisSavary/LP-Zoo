package Zoo;

import Animal.AbstractAnimal;
import Animal.Names;
import Enclosure.*;
import Species.*;

import java.util.ArrayList;

public class Zoo {
    public static int MAXIMAL_ENCLOSURE_NUMBER = 6;
    private String name;
    private Employee employee;
    private ArrayList<AbstractEnclosure> enclosures = new ArrayList<AbstractEnclosure>();
    private int monthCount = 1 ;
    private int timeSpeed = 1; // How many months passes each turns ?
    private int turnDuration = 4 ; // How many action the employee can before the end of turn

    public Zoo(String name, Employee employee){
        this.name = name;
        this.employee = employee;
    }

    public AbstractEnclosure getEnclosure(int id) throws Exception {
        try {
            return this.enclosures.get(id);
        } catch (Exception e) {
            throw new Exception("Bad id");
        }
    }

    public void addEnclosure(AbstractEnclosure enc){
        this.enclosures.add(enc);
    }

    public void removeEnclosure(int id) throws Exception {
        try {
            this.enclosures.remove(id);
        } catch (Exception e){
            throw new Exception("Bad Id");
        }
    }

    public int getResidentNumber(){
        int total = 0;
        for(AbstractEnclosure current : this.enclosures){
            total += current.getPopulation();
        }
        return total;
    }

    public void start(){
        while(this.getResidentNumber() > 0)
        {
            System.out.println("\n---------------------------------------------------------");
            System.out.println("  Zoo \"" + this.name + "\" (Mois " + this.monthCount + ")");
            System.out.println("  Animals (Total) : " + this.getResidentNumber());
            System.out.println("---------------------------------------------------------\n");

            this.employee.startMenu(this.enclosures, turnDuration);

            for (AbstractEnclosure enclosure : this.enclosures) {
                enclosure.begin();
                while (enclosure.hasNext()) {
                    //System.out.println("Month passes for " + this.enclosures.get(i).getResident().getName());
                    enclosure.getResident().monthsPasses(this.timeSpeed);
                }
            }

            this.monthCount += this.timeSpeed;
        }

    }

}
