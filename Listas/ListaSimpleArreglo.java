package Listas;

public class ListaSimpleArreglo {
    private int[] datos;
    private int tamaño;

    public ListaSimpleArreglo(int capacidad) {
        datos = new int[capacidad];
        tamaño = 0;
    }

    public void insertar(int valor) {
        if (tamaño == datos.length) return;
        datos[tamaño++] = valor;
    }

    public void mostrar() {
        for (int i = 0; i < tamaño; i++) {
            System.out.print(datos[i] + " -> ");
        }
        System.out.println("null");
    }
}