import java.util.Scanner;

public class Factorial{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cacular_Factorial fact = new Cacular_Factorial();

        System.out.println("Ingresa un numero para calcular su factorial: ");
        int n = sc.nextInt();

        if (n < 0){
            System.out.println("El factorial no sirve para numeros indefinidos");
        } else {
            long resultado = fact.calcular(n);//Llamamos al metodo recursivo para calcular el factorial
            System.out.println("El factorial de " +n+ " es: "+resultado);
        }
        sc.close();
    }
}