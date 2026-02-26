class Link {
    public int iData;      // clave o identificador (entero)
    public double dData;   // valor asociado (double)
    
    public Link next;      // enlace al siguiente nodo

    // Constructor
    public Link(int id, double dd) {
        iData = id;
        dData = dd;
        // next = null automáticamente
    }

    // Muestra este nodo
    public void displayLink() {
        System.out.print("{" + iData + ", " + dData + "} ");
    }
}