import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calcular_Fibonacci fib = new Calcular_Fibonacci();// Crea una instancia de la clase Calcular_Fibonacci para usar su método calcular
        
        System.out.println("Ingrese el numero de terminos de Fibonacci que desea ver: ");
        int limite = sc.nextInt();
        
        System.out.println("\nSecuencia de Fibonacci: ");// Imprime los términos de la secuencia de Fibonacci hasta el límite especificado
        for(int i = 0; i < limite; i++){// Itera desde 0 hasta el límite ingresado por el usuario
            System.out.print(fib.calcular(i) + " ");// Llama al método calcular para obtener el término i de la secuencia de Fibonacci y lo imprime seguido de un espacio
        }

        sc.close();
    }
}
