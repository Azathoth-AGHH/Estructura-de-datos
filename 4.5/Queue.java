// Queue.java
// Implementación de una cola circular (circular queue) usando arreglo
// Versión sin contador de elementos (nItems), detecta lleno/vacío por patrones de front y rear

class Queue {
    private int maxSize;       // tamaño máximo del arreglo (1 más que la capacidad real)
    private long[] queArray;   // arreglo que contiene los elementos
    private int front;         // índice del frente de la cola (donde se sacan elementos)
    private int rear;          // índice del final de la cola (donde se insertan elementos)

    // Constructor
    public Queue(int s) {
        maxSize = s + 1;                // arreglo 1 celda más grande que la capacidad solicitada
        queArray = new long[maxSize];   // crea el arreglo
        front = 0;                      // inicialmente vacío
        rear = -1;                      // inicialmente vacío
    }

    // Inserta un elemento al final (rear) de la cola
    public void insert(long j) {
        // Si rear llega al final del arreglo, da la vuelta (circular)
        if (rear == maxSize - 1) {
            rear = -1;
        }
        // Incrementa rear y coloca el elemento
        queArray[++rear] = j;
    }

    // Remueve y devuelve el elemento del frente (front) de la cola
    public long remove() {
        long temp = queArray[front++];  // guarda el valor y avanza front

        // Si front llega al final del arreglo, da la vuelta
        if (front == maxSize) {
            front = 0;
        }
        return temp;
    }

    // Devuelve el elemento del frente sin removerlo (peek)
    public long peekFront() {
        return queArray[front];
    }

    // True si la cola está vacía
    public boolean isEmpty() {
        // Dos formas equivalentes de detectar vacío
        return (rear + 1 == front) || (front + maxSize - 1 == rear);
        // Forma más común y clara:
        // return (rear + 1 == front) || (front == 0 && rear == maxSize - 1);
    }

    // True si la cola está llena
    public boolean isFull() {
        // Dos formas equivalentes de detectar lleno
        return (rear + 2 == front) || (front + maxSize - 2 == rear);
        // Forma más común y clara:
        // return (rear + 1 == front - 1) || (rear == maxSize - 1 && front == 0);
    }

    // Devuelve el número actual de elementos en la cola
    // (Asume que la cola no está vacía cuando se llama)
    public int size() {
        if (rear >= front) {
            // Secuencia contigua (sin dar vuelta)
            return rear - front + 1;
        } else {
            // Secuencia partida (dio la vuelta)
            return (maxSize - front) + (rear + 1);
        }
    }
}