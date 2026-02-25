package Listas;

import java.util.LinkedList;

public class ListaSimpleLista {
    private LinkedList<Integer> lista = new LinkedList<>();

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