class LinkList {
    private Link first;   // primer nodo de la lista

    // Constructor
    public LinkList() {
        first = null;
    }

    // Inserta al inicio de la lista
    public void insertFirst(int id, double dd) {
        Link newLink = new Link(id, dd);
        
        newLink.next = first;     // el nuevo apunta al que era primero
        first = newLink;          // ahora el nuevo es el primero
    }

    // Busca un nodo por su clave (iData)
    public Link find(int key) {
        Link current = first;
        
        while (current != null && current.iData != key) {
            current = current.next;
        }
        
        return current;  // null si no se encontró
    }

    // Elimina el nodo con la clave indicada
    public Link delete(int key) {
        Link current = first;
        Link previous = first;

        // Caso especial: lista vacía
        if (first == null) {
            return null;
        }

        // Buscamos el nodo
        while (current.iData != key) {
            if (current.next == null) {
                return null;           // no encontrado
            }
            previous = current;
            current = current.next;
        }

        // Lo encontramos → lo eliminamos
        if (current == first) {
            first = first.next;        // era el primero
        } else {
            previous.next = current.next;  // saltamos el nodo
        }

        return current;  // devolvemos el nodo eliminado
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