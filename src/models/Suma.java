package models;

public class Suma {
    static private int count=0;

    public void sumar(){
        for (int i=1;i<=10000;i++)
            count++;
    }

    public int getCount() {
        return count;
    }
}
