package Zoo;

import Enclosure.Enclosure;

public class Visitors extends Thread{
    private String name;
    public int money = 10;

    public Visitors(String name, int money) {
        this.name = name;
        this.money = money;
    }
    public void Visit(Zoo zoo){
        zoo.setMoney(zoo.money + this.money);
    }
    public void seeEnclosure(Enclosure enclosure) throws InterruptedException {
        System.out.println("wow quel bel " + enclosure.getName());
        Thread.sleep(10000);

    }
}
