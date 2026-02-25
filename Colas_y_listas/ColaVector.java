package Colas_y_listas;

import java.util.Vector;

public class ColaVector{
    private Vector<Integer> cola = new Vector<>();

    public void enqueue(int dato){
        cola.add(dato);
    }

    public int dequeue(){
        if(cola.isEmpty()){
            System.out.println("Cola vacía");
            return -1;
        } else {
            return cola.remove(0);
        }
    }
}