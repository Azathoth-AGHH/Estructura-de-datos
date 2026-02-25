package Colas_y_listas;

import java.util.LinkedList;

public class ColaLista {
    private LinkedList<Integer> cola = new LinkedList<>();

    public void enqueue(int dato){
        cola.add(dato);
    }

    public int dequeue(){
        if(cola.isEmpty()){
            System.out.println("Cola vacía");
            return -1;
        } else {
            return cola.removeFirst();
        }
    }
}
