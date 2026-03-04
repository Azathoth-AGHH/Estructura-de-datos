class ListaEnlazada {
    
    private Nodo primero;   // Referencia al primer nodo de la lista (cabeza/head)

    /**
     * Constructor de la lista
     * Inicializa la lista como vacía
     */
    public ListaEnlazada() {
        this.primero = null;
    }

    /**
     * Inserta un nuevo elemento al inicio de la lista (cabeza)
     * Complejidad: O(1)
     * 
     * @param valor El número entero que se desea insertar al principio
     */
    public void insertarAlInicio(int valor) {
        // 1. Creamos el nuevo nodo con el valor recibido
        Nodo nuevo = new Nodo(valor);
        
        // 2. Hacemos que el nuevo nodo apunte al nodo que antes era el primero
        nuevo.siguiente = primero;
        
        // 3. Ahora el nuevo nodo pasa a ser el primero de la lista
        primero = nuevo;
    }

    /**
     * Inserta un elemento al final de la lista
     * @param valor El número entero que se desea insertar al final
     */
    public void insertarAlFinal(int valor) {
        Nodo nuevo = new Nodo(valor);

        // Caso especial: lista vacía
        if (primero == null) {
            primero = nuevo;
            return;
        }

        // Recorremos hasta el último nodo
        Nodo actual = primero;
        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }

        // Enlazamos el nuevo nodo al final
        actual.siguiente = nuevo;
    }

    /**
     * Muestra la lista de forma clara y visualmente agradable en consola
     */
    public void imprimir() {
        if (primero == null) {
            System.out.println("Lista vacía → []");
            return;
        }

        System.out.print("Lista:  ");

        Nodo actual = primero;
        while (actual != null) {
            // Imprimimos el valor
            System.out.print(actual.dato);
            
            // Si hay siguiente nodo, ponemos flecha
            if (actual.siguiente != null) {
                System.out.print(" → ");
            }
            
            actual = actual.siguiente;
        }
        
        System.out.println();  // salto de línea final
    }

    /**
     * Versión alternativa de impresión con numeración de posición
     * Útil para depuración o para entender mejor la estructura
     */
    public void imprimirConPosiciones() {
        if (primero == null) {
            System.out.println("Lista vacía → []");
            return;
        }

        System.out.println("Lista con posiciones:");
        Nodo actual = primero;
        int posicion = 0;

        while (actual != null) {
            System.out.printf("  [%d] → %d%n", posicion, actual.dato);
            actual = actual.siguiente;
            posicion++;
        }
        System.out.println("  → null (fin)");
    }

    /**
     * Método auxiliar para saber si la lista está vacía
     * @return true si no hay elementos, false en caso contrario
     */
    public boolean estaVacia() {
        return primero == null;
    }
    public void insertarDespuesDe(int datoBuscado, int nuevoValor) {
    
    Nodo actual = primero;

    // 1. Buscar el nodo con el dato 10 (o el que indiquemos)
    while (actual != null && actual.dato != datoBuscado) {
        actual = actual.siguiente;
    }

    // 2. Si no se encontró el dato
    if (actual == null) {
        System.out.println("Elemento no encontrado.");
        return;
    }

    // 3. Crear nuevo nodo
    Nodo nuevo = new Nodo(nuevoValor);

    // 4. Ajustar enlaces (doblemente enlazado)
    nuevo.siguiente = actual.siguiente;
    nuevo.anterior = actual;

    if (actual.siguiente != null) {
        actual.siguiente.anterior = nuevo;
    }

    actual.siguiente = nuevo;
}
}
