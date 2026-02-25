package Colas_y_listas;
import java.util.LinkedList;

public class PilaLista {
    private LinkedList<Integer> pila = new LinkedList<>();

    public void push(int dato){
        pila.addFirst(dato);
    }

    public int pop(){
        if (pila.isEmpty()) {
            System.out.println("Pila vacía");
            return -1;
        } else {
            return pila.removeFirst();
        }
    }
}
