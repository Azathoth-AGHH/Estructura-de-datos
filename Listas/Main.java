package Listas;

public class Main {
    public static void main(String[] args){
        PilaArrayList pila = new PilaArrayList();
        pila.push(10);
        pila.push(20);
        System.out.println(pila.pop());

        ColaLista cola = new ColaLista();
        cola.enqueue(1);
        cola.enqueue(2);
        System.out.println(cola.dequeue());

        ListaSimplearrayList lista = new ListaSimpleArrayList();
        lista.insertar(5);
        lista.insertar(10);
        lista.mostrar();

        ListaDobleLista listaDoble = new ListaDobleLista();
        listaDoble.insertar(100);
        listaDoble.insertar(200);
        listaDoble.mostrar();
    }
}