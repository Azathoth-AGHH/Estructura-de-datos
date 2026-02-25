package Colas_y_listas;

// 1. Pila usando Arreglo (Tamaño fijo)
class PilaArreglo {
    private final int[] datos;
    private int tope;

    public PilaArreglo(int capacidad) {
        this.datos = new int[capacidad];
        this.tope = -1;
    }

    public void push(int valor) {
        if (tope == datos.length - 1) {
            System.out.println("Pila Arreglo: ¡Desbordamiento! (Llena)");
        } else {
            datos[++tope] = valor;
            System.out.println("Arreglo -> Push: " + valor);
        }
    }

    public int pop() {
        if (tope < 0) {
            System.out.println("Pila Arreglo: Vacía");
            return -1;
        }
        return datos[tope--];
    }
}