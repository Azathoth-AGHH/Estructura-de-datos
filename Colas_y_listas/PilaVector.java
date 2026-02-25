package Colas_y_listas;

import java.util.Vector;

public class PilaVector {
    private Vector<Integer> pila = new Vector<>();

    public void push(int dato){
        pila.add(dato);
    }

    public int pop(){
        if(pila.isEmpty()){
            System.out.println("Pila vacía");
            return -1;
        } else {
            return pila.remove(pila.size() - 1);
        }
    }
}
