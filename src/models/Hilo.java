package models;

import java.util.concurrent.Semaphore;

public class Hilo extends Thread{
    private Suma suma;
    private Semaphore mutex;
    public Hilo(Suma suma, Semaphore mutex){
        this.suma = suma;
        this.mutex = mutex;
    }
    @Override
    public void run(){
        try {
            mutex.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        suma.sumar();
        mutex.release();
    }
}
