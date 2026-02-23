// BracketChecker.java
// Clase que verifica si los delimitadores están balanceados

class BracketChecker {
    private String input;   // cadena de entrada a verificar

    // Constructor
    public BracketChecker(String in) {
        input = in;
    }

    // Método principal: verifica los delimitadores
    public void check() {
        int stackSize = input.length();          // tamaño máximo posible de la pila
        StackX theStack = new StackX(stackSize); // creamos la pila

        for (int j = 0; j < input.length(); j++) {   // recorremos cada carácter
            char ch = input.charAt(j);               // carácter actual

            switch (ch) {
                case '{':    // delimitadores de apertura
                case '[':
                case '(':
                    theStack.push(ch);               // empujamos a la pila
                    break;

                case '}':    // delimitadores de cierre
                case ']':
                case ')':
                    if (!theStack.isEmpty()) {       // si la pila no está vacía
                        char chx = theStack.pop();   // extraemos el último abierto

                        // Verificamos si coinciden los tipos
                        if ((ch == '}' && chx != '{') ||
                            (ch == ']' && chx != '[') ||
                            (ch == ')' && chx != '(')) {
                            System.out.println("Error: '" + ch + "' en la posición " + j);
                            return;
                        }
                    } else {  // pila vacía → cierre sin apertura correspondiente
                        System.out.println("Error: '" + ch + "' en la posición " + j + " - sin apertura correspondiente");
                        return;
                    }
                    break;

                default:    // ignoramos cualquier otro carácter
                    break;
            } // fin switch
        } // fin for

        // Al terminar, la pila debe estar vacía para estar balanceado
        if (!theStack.isEmpty()) {
            System.out.println("Error: faltan delimitadores de cierre");
        } else {
            System.out.println("Los delimitadores están balanceados correctamente.");
        }
    }
}