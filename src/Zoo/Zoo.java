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

    public Zoo(String name){
        this.name = name;
        this.enclosures.add(new Aquarium<Shark>("Aquarium", 30, 6));
        this.enclosures.add(new Enclosure<Bear>("Enclos Classique", 30, 6))  ;
        this.enclosures.add(new Aviary<Eagle>("Volière", 30, 6)  );
        for(int i=0; i<5; i++)
        {
            this.enclosures.get(0).addResident(new Shark());
            this.enclosures.get(0).getResident(i).setName(Names.names[(int)Math.floor(Math.random()*15)]);

            this.enclosures.get(1).addResident(new Bear());
            this.enclosures.get(1).getResident(i).setName(Names.names[(int)Math.floor(Math.random()*15)]);

            this.enclosures.get(2).addResident(new Eagle());
            this.enclosures.get(2).getResident(i).setName(Names.names[(int)Math.floor(Math.random()*15)]);
        }


        this.enclosures.add(new Aquarium<Shark>("Aquarium (Temporaire)", 30, 6)  );
        this.enclosures.add(new Enclosure<Bear>("Enclos Classique (Temporaire)", 30, 6)  );
        this.enclosures.add(new Aviary<Eagle>("Volière (Temporaire)", 30, 6)  );

        this.employee = new Employee(this.name + " Employee", (Math.random()>0.5)? AbstractAnimal.SEX.FEMALE : AbstractAnimal.SEX.MALE, 20);
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

            for(int i=0; i<this.enclosures.size(); i++){
                this.enclosures.get(i).begin();
                while(this.enclosures.get(i).hasNext()){
                    //System.out.println("Month passes for " + this.enclosures.get(i).getResident().getName());
                    this.enclosures.get(i).getResident().monthsPasses(this.timeSpeed);
                }
            }

            this.monthCount += this.timeSpeed;
        }

    }

}
