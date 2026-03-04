class Nodo {
    int dato;          // Valor que guarda el nodo
    Nodo siguiente;    // Referencia al siguiente nodo (o null si es el último)

    /**
     * Constructor del nodo
     * @param valor el dato que se almacenará en este nodo
     */
    public Nodo(int valor) {
        this.dato = valor;
        this.siguiente = null;
    }
}