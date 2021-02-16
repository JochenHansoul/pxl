package demo;

public class TalkerApp {
    public static void main(String[] args) {
        Thread talker1 = new Thread(new Talker("A"));
        Thread talker2 = new Thread(new Talker("B"));
        Thread talker3 = new Thread(new Talker("C"));
        Thread talker4 = new Thread(new Talker("D"));
        Thread talker5 = new Thread(new Talker("E"));
        Thread talker6 = new Thread(new Talker("F"));
        talker1.start();
        talker2.start();
        talker3.start();
        talker4.start();
        talker5.start();
        talker6.start();
        System.out.println("MAIN METHOD TALKING YEET");
    }
}