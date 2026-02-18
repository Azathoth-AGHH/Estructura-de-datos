import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        
        BusquedaBinaria bb = new BusquedaBinaria();
        Scanner scanner = new Scanner(System.in);
        
        // Arreglo ordenado 
        int[] numeros = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        
        System.out.println("Arreglo ordenado (10 elementos):");
        for (int num : numeros) {
            System.out.print(num + " ");
        }
        System.out.println("\n");
        
        System.out.println("Búsqueda binaria recursiva");
        System.out.println("---------------------------");
        System.out.println("Escribe números para buscar (escribe -1 para terminar):");
        
        while (true) {
            System.out.print("\nNúmero a buscar: ");
            int objetivo;
            
            // Validamos que sea un entero
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor ingresa un número entero.");
                scanner.next(); // descartamos lo inválido
                System.out.print("Número a buscar: ");
            }
            objetivo = scanner.nextInt();
            
            if (objetivo == -1) {
                System.out.println("¡Programa terminado!");
                break;
            }
            
            int indice = bb.buscar(numeros, objetivo);
            
            if (indice != -1) {
                System.out.println("- Encontrado en la posición: " + indice);
                System.out.println("   (valor: " + numeros[indice] + ")");
            } else {
                System.out.println("→ NO se encontró el número " + objetivo);
            }
        }
        
        scanner.close();
    }
}