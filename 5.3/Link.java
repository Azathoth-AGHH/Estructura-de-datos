class Link {
    public long dData;     // dato (en este ejemplo solo long, sin clave separada)
    public Link next;      // siguiente nodo

    // Constructor
    public Link(long dd) {
        dData = dd;
        // next = null automáticamente
    }

    // Muestra este nodo
    public void displayLink() {
        System.out.print("{" + dData + "} ");
    }
}