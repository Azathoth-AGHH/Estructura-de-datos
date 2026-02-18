public class Cacular_Factorial{
    public long calcular(int n){//Metodo recursivo para calcular el factorial de un numero
        if (n == 0 || n == 1){//El factorial de 0 y 1 es 1
            return 1;//Caso base
        } else {//Caso recursivo
            return n * calcular(n - 1);//El factorial de n es n multiplicado por el factorial de n-1
        }
    }
}