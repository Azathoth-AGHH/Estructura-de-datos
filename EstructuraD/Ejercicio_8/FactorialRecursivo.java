public class FactorialRecursivo {

    /**
     * Calcula n! de manera recursiva.
     * 
     * @param n número entero >= 0
     * @return resultado de n!
     * @throws IllegalArgumentException si n < 0
     */
    public long calcular(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("No se puede evaluar factorial de números negativos");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * calcular(n - 1);
    }
}