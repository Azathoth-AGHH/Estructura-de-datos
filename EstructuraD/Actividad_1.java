import java.util.Scanner;

public class Actividad_1 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("\n--- MENÚ DE OPCIONES ---");
            System.out.println("1. Comparar 2 caracteres");
            System.out.println("2. Suma y multiplicación de arreglos unidimensionales");
            System.out.println("3. Suma y multiplicación de matrices Bidimensionales");
            System.out.println("4. Arreglo tridimensional");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1: Codigo_1(); break;
                case 2: Codigo_2(); break;
                case 3: Codigo_3(); break;
                case 4: Codigo_4(); break;
                case 5: System.out.println("Saliendo del programa..."); break;
                default: System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }

    // 1. Comparar 2 datos simples tipo carácter
    public static void Codigo_1() {
        System.out.print("Ingrese el primer carácter: ");
        char c1 = sc.next().charAt(0);
        System.out.print("Ingrese el segundo carácter: ");
        char c2 = sc.next().charAt(0);

        if (c1 > c2){
            System.out.println(c1+" es mayor que "+ c2);
        }else if (c1 < c2) {
            System.out.println(c1+ " es menor que "+c2);
        }else{
            System.out.println(c1+ " es igual "+c2);
        }
    }

    // 2. Suma y multiplicación de arreglos unidimensionales
    public static void Codigo_2() {
        System.out.print("Tamaño de los arreglos: ");
        int n = sc.nextInt();
        int[] Array_1 = new int[n];
        int[] Array_2 = new int[n];

        System.out.println("Llenar Arreglo 1:");
        for (int i=0; i<n; i++){
            Array_1[i] = sc.nextInt();
        }
        System.out.println("Llenar Arreglo 2:");
        for(int i=0; i<n; i++){
            Array_2[i] = sc.nextInt();
        }

        System.out.print("Suma: ");
        for(int i=0; i<n; i++){ 
            System.out.print((Array_1[i] + Array_2[i]) + " ");
        }
        System.out.print("\nMultiplicación: ");
        for(int i=0; i<n; i++) {
            System.out.print((Array_1[i] * Array_2[i]) + " ");
        }
    }

    // 3. Suma y multiplicación de arreglos bidimensionales
    public static void Codigo_3() {
        System.out.print("Dimensión n para matriz cuadrada (nxn): ");
        int n = sc.nextInt();
        int[][] Matriz_1 = new int[n][n];
        int[][] Matriz_2 = new int[n][n];

        System.out.println("Ingrese datos de la Matriz 1:");

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                Matriz_1[i][j] = sc.nextInt();
            }
        }
            
        
        System.out.println("Ingrese datos de la Matriz 2:");
                for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                Matriz_2[i][j] = sc.nextInt();
            }
        }

        System.out.println("\nSuma de Matrices:");
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++){
                System.out.print((Matriz_1[i][j] + Matriz_2[i][j]) + "\t");
            }
        }

        System.out.println("\nMultiplicación de Matrices:");
        int[][] Resultado = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    Resultado[i][j] += Matriz_1[i][k] * Matriz_2[k][j];
                }
                System.out.print(Resultado[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // 4. Arreglo Tridimensional 
    public static void Codigo_4() {
        System.out.println("Define las dimensiones del arreglo 3D:");
        System.out.print("Profundidad (X): "); int x = sc.nextInt();
        System.out.print("Filas (Y): "); int y = sc.nextInt();
        System.out.print("Columnas (Z): "); int z = sc.nextInt();
        
        int[][][] Arreglo_tridimensional = new int[x][y][z];

        // Llenado manual
        for(int i=0; i<x; i++) {
            for(int j=0; j<y; j++) {
                for(int k=0; k<z; k++) {
                    System.out.print("Ingresa valor para ["+i+"]["+j+"]["+k+"]: ");
                    int Valor_ing = sc.nextInt();
                    Arreglo_tridimensional[i][j][k] = Valor_ing + 5;
                }
            }
        }

        // Mostrar resultados
        System.out.println("\n--- Arreglo + 5 ---");
        for(int i=0; i<x; i++) {
            System.out.println("Capa " + i + ":");
            for(int j=0; j<y; j++) {
                for(int k=0; k<z; k++) {
                    System.out.print(Arreglo_tridimensional[i][j][k] + "\t");
                }
                System.out.println();
            }
        }
    }
}