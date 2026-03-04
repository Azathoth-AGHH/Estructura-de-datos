class Nodo {
    int dato;
    Nodo siguiente;
    Nodo anterior;   // ← nuevo enlace hacia atrás

    public Nodo(int valor) {
        this.dato = valor;
        this.siguiente = null;
        this.anterior = null;
    }
}
