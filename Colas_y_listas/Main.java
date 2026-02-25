package Colas_y_listas;

public class Main {
    public static void main(String[] args) {

        System.out.println("========== PILA ==========");
        PilaArreglo pila = new PilaArreglo(5);
        pila.push(10);
        pila.push(20);
        System.out.println(pila.pop());

        System.out.println("\n========== COLA ==========");
        ColaLista cola = new ColaLista();
        cola.enqueue(1);
        cola.enqueue(2);
        System.out.println(cola.dequeue());

        System.out.println("\n====== LISTA SIMPLE ======");
        ListaSimple listaSimple = new ListaSimple();
        listaSimple.insertar(5);
        listaSimple.insertar(10);
        listaSimple.mostrar();

        System.out.println("\n====== LISTA DOBLE ======");
        ListaDoble listaDoble = new ListaDoble();
        listaDoble.insertar(100);
        listaDoble.insertar(200);
        listaDoble.mostrar();
    }
}