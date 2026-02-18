public class Calcular_Fibonacci {
    public int calcular(int n){// Método recursivo para calcular el término n de la secuencia de Fibonacci
        if(n <= 1){// Caso base: los primeros dos términos de la secuencia son 0 y 1
            return n;// Si n es 0, devuelve 0; si n es 1, devuelve 1
        } else {// Caso recursivo: el término n es la suma de los dos términos anteriores
            return calcular(n - 1) + calcular(n - 2); // Llamada recursiva para calcular el término n-1 y n-2
        }
    }
}
