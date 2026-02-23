// StackX.java
// Pila (stack) simple para caracteres - implementación array-based

class StackX {
    private int maxSize;          // tamaño máximo de la pila
    private char[] stackArray;    // contenedor de los elementos
    private int top;              // índice del elemento en la cima (-1 = vacía)

    // Constructor
    public StackX(int s) {
        maxSize = s;
        stackArray = new char[maxSize];
        top = -1;                 // pila inicialmente vacía
    }

    // Inserta un elemento en la cima de la pila
    public void push(char j) {
        stackArray[++top] = j;    // primero incrementa top, luego asigna
    }

    // Extrae y devuelve el elemento de la cima
    public char pop() {
        return stackArray[top--]; // devuelve y luego decrementa top
    }

    // Devuelve el elemento de la cima sin extraerlo
    public char peek() {
        return stackArray[top];
    }

    // True si la pila está vacía
    public boolean isEmpty() {
        return (top == -1);
    }
}