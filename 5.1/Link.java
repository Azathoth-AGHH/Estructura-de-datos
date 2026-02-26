class Link {
    public int iData;     // dato entero (puede representar una clave o ID)
    public double dData;  // dato decimal (valor asociado)
    
    public Link next;     // referencia al siguiente nodo (enlace)

    // Constructor
    public Link(int id, double dd) {
        iData = id;       // inicializamos el dato entero
        dData = dd;       // inicializamos el dato double
        // next se inicializa automáticamente a null
    }

    // Método para mostrar el contenido de este nodo
    public void displayLink() {
        System.out.print("{" + iData + ", " + dData + "} ");
    }
}