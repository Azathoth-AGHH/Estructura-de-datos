public class StackX
{
    private int maxSize;       // tamaño del arreglo
    private long[] stackArray; // arreglo donde se guardan los datos
    private int top;           // índice del tope

    //--------------------------------------------------------------
    public StackX(int s)       // constructor
    {
        maxSize = s;
        stackArray = new long[maxSize];
        top = -1;              // pila vacía
    }

    //--------------------------------------------------------------
    public void push(long j)   // insertar elemento
    {
        stackArray[++top] = j;
    }

    //--------------------------------------------------------------
    public long pop()          // eliminar elemento
    {
        return stackArray[top--];
    }

    //--------------------------------------------------------------
    public long peek()         // ver elemento superior
    {
        return stackArray[top];
    }

    //--------------------------------------------------------------
    public boolean isEmpty()   // verificar si está vacía
    {
        return (top == -1);
    }

    //--------------------------------------------------------------
    public boolean isFull()    // verificar si está llena
    {
        return (top == maxSize - 1);
    }
}