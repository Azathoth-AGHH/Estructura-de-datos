package Colas_y_listas;

public class ListaSimple {
    private Nodo cabeza;

    public void insertar(int dato){
        Nodo nuevo = new Nodo(dato);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
    }

    public void mostrar(){
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " ->");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }
}
