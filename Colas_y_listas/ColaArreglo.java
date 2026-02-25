package Colas_y_listas;

public class ColaArreglo{
    private int[] cola;
    private int frente, fin;

    public ColaArreglo(int capacidad){
        cola = new int[capacidad];
        frente = 0;
        fin = 0;
    }

    public void enqueue(int dato){
        if(fin == cola.length){
            System.out.println("Cola llena");
        } else {
            cola[fin++] = dato;
        }
    }

    public int dequeue(){
        if(frente == fin){
            System.out.println("Cola vacía");
            return -1;
        } else {
            return cola[frente++];
        }
    }
}