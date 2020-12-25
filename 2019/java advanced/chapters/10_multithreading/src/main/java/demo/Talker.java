package demo;

import static java.lang.Thread.sleep;
//Implements runnable
//of
//extends Thread
//Runnable --> new Thread() , in constructor het object dat parallel moet runnen,
//en dan .start()

public class Talker implements Runnable {
    private String id;

    public Talker(String id){
        this.id=id;
    }

    @Override
    public void run() {
        for (int i = 0; i <10; i++){
            System.out.println("Thread " + id + " is talking");
        }
    }
}