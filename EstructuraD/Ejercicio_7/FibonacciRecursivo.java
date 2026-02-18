public class FibonacciRecursivo {

    public long calcular(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n no puede ser negativo");
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return calcular(n - 1) + calcular(n - 2);
    }
}