class FirstLastList {
    private Link first;    // primer nodo de la lista
    private Link last;     // último nodo de la lista

    // Constructor
    public FirstLastList() {
        first = null;
        last  = null;
    }

    // ¿La lista está vacía?
    public boolean isEmpty() {
        return (first == null);
    }

    // Inserta un nuevo elemento al inicio de la lista
    public void insertFirst(long dd) {
        Link newLink = new Link(dd);

        if (isEmpty()) {
            // Si la lista está vacía, el nuevo es también el último
            last = newLink;
        } else {
            // El nuevo apunta al que era el primero
            newLink.next = first;
        }
        first = newLink;  // El nuevo se convierte en el primero
    }

    // Inserta un nuevo elemento al final de la lista
    public void insertLast(long dd) {
        Link newLink = new Link(dd);

        if (isEmpty()) {
            // Si está vacía, el nuevo es primero y último
            first = newLink;
        } else {
            // El último actual apunta al nuevo
            last.next = newLink;
        }
        last = newLink;   // El nuevo se convierte en el último
    }

    // Elimina y retorna el valor del primer elemento
    public long deleteFirst() {
        // Asume que la lista NO está vacía (debería verificarse antes)
        long temp = first.dData;

        if (first.next == null) {
            // Era el único elemento → lista queda vacía
            last = null;
        }
        first = first.next;   // Avanzamos el primero

        return temp;
    }

    // Muestra toda la lista
    public void displayList() {
        System.out.print("List (first-->last): ");
        
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}