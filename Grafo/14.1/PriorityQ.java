import java.util.*;

public class PriorityQ {
    private final int SIZE = 20;
    private AristaPonderada[] queArray;
    private int size;

    public PriorityQ() {
        queArray = new AristaPonderada[SIZE];
        size = 0;
    }

    // Inserta manteniendo orden (menor peso al final)
    public void insert(AristaPonderada item) {
        int j;
        for (j = 0; j < size; j++)
            if (item.distance >= queArray[j].distance)
                break;
        for (int k = size - 1; k >= j; k--)
            queArray[k + 1] = queArray[k];
        queArray[j] = item;
        size++;
    }

    public AristaPonderada removeMin() {
        return queArray[--size];
    }

    public void removeN(int n) {
        for (int j = n; j < size - 1; j++)
            queArray[j] = queArray[j + 1];
        size--;
    }

    public AristaPonderada peekMin() {
        return queArray[size - 1];
    }

    public AristaPonderada peekN(int n) {
        return queArray[n];
    }

    public int find(int findDex) {
        for (int j = 0; j < size; j++)
            if (queArray[j].destVert == findDex)
                return j;
        return -1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }
}