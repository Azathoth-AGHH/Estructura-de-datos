// BracketsApp.java
// Programa principal para probar el verificador de delimitadores
// Usa una pila para comprobar que (), [], {} estén balanceados

import java.io.*;

class BracketsApp {

   public static void main(String[] args) throws IOException {
      String input;

      while (true) {
            System.out.print("Ingrese una cadena con delimitadores (Enter vacío para salir): ");
            System.out.flush();
            input = getString();               // leemos la entrada

            // Salimos si el usuario solo presiona Enter
            if (input.equals("")) {
               break;
            }

            // Creamos el verificador y lo ejecutamos
            BracketChecker theChecker = new BracketChecker(input);
            theChecker.check();
            System.out.println();  // línea en blanco para separar pruebas
      }
      System.out.println("Programa terminado.");
   }

   // Método auxiliar para leer una línea desde el teclado
   public static String getString() throws IOException {
      InputStreamReader isr = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(isr);
      String s = br.readLine();
      return s;
   }
}