package Colas_y_listas;

public class ListaDoble {
    private NodoDoble cabeza;

    public void insertar(int dato){
        NodoDoble nuevo = new NodoDoble(dato);
        if (cabeza != null) {
            cabeza.anterior = nuevo;
            nuevo.siguiente = cabeza;
        }
        cabeza = nuevo;
    }

    public void mostrar(){
        NodoDoble actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " <-> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }
}