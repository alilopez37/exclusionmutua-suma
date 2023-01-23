import models.Hilo;
import models.Suma;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Suma s1 =  new Suma();
        Semaphore mutex = new Semaphore(1);
        Hilo h1 =  new Hilo(s1, mutex);
        Hilo h2 = new Hilo(s1, mutex);
        Hilo h3 = new Hilo(s1, mutex);

        h1.start();
        h2.start();
        h3.start();

        try {
            h1.join();
            h2.join();
            h3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Count: "+ s1.getCount());
    }}
