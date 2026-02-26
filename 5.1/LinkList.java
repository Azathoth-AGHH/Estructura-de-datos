class LinkList {
    private Link first;   // referencia al primer nodo de la lista

    // Constructor
    public LinkList() {
        first = null;     // al inicio la lista está vacía
    }

    // ¿La lista está vacía?
    public boolean isEmpty() {
        return (first == null);
    }

    // Inserta un nuevo nodo al inicio de la lista
    public void insertFirst(int id, double dd) {
        Link newLink = new Link(id, dd);   // creamos el nuevo nodo
        
        newLink.next = first;              // el nuevo nodo apunta al que antes era el primero
        first = newLink;                   // ahora el primero es el nuevo nodo
    }

// Elimina y devuelve el primer nodo de la lista
    public Link deleteFirst() {
        // Se asume que la lista NO está vacía (debe verificarse antes)
        Link temp = first;          // guardamos referencia al nodo que vamos a eliminar
        first = first.next;         // el siguiente nodo pasa a ser el primero
        return temp;                // devolvemos el nodo eliminado
    }

    // Muestra todos los elementos de la lista
    public void displayList() {
        System.out.print("List (first-->last): ");
        
        Link current = first;       // empezamos desde el primer nodo
        
        while (current != null) {   // mientras no lleguemos al final
            current.displayLink();  // mostramos el nodo actual
            current = current.next; // avanzamos al siguiente
        }
        System.out.println("");     // salto de línea al final
    }
}





