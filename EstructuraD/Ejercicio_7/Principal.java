public class Principal {

    public static void main(String[] args) {
        
        FibonacciRecursivo fib = new FibonacciRecursivo();

        // Imprimimos los primeros 12 números
        System.out.println("Serie de Fibonacci (primeros 12 términos):");
        for (int i = 0; i < 12; i++) {
            System.out.print(fib.calcular(i));
            if (i < 11) {
                System.out.print(" -");
            }
        }
        System.out.println("\n");

        // Ejemplo de un valor específico
        int posicion = 15;
        System.out.println("Fibonacci en la posición " + posicion + " = " 
                          + fib.calcular(posicion));
    }
}
