package Listas;

import java.util.Vector;

public class ListaSimpleVector {
    private Vector<Integer> lista = new Vector<>();

    public void insertar(int valor) {
        lista.add(valor);
    }

    public void mostrar() {
        for (int v : lista) {
            System.out.print(v + " -> ");
        }
        System.out.println("null");
    }
}