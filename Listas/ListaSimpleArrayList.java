package Listas;

import java.util.ArrayList;
import java.util.List;

public class ListaSimpleArrayList {
    private List<Integer> lista = new ArrayList<>();

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