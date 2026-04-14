import java.util.Arrays;

public class ArraysExampleLogic {

    public void ejecutar() {

        // Declaración del arreglo
        int[] numbers = {5, 3, 8, 1};

        // Ordenar
        Arrays.sort(numbers);
        System.out.println("Sorted: " + Arrays.toString(numbers));

        // Buscar elemento
        int index = Arrays.binarySearch(numbers, 3);
        System.out.println("Index of 3: " + index);

        // Copiar arreglo
        int[] copy = Arrays.copyOf(numbers, 6);
        System.out.println("Copy: " + Arrays.toString(copy));

        // Llenar arreglo
        Arrays.fill(copy, 9);
        System.out.println("Filled: " + Arrays.toString(copy));

        // Comparar arreglos
        System.out.println("Equals: " + Arrays.equals(numbers, copy));
    }
}