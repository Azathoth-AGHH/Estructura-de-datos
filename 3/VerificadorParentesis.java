import java.util.Stack;

public class VerificadorParentesis {

    public boolean esBalanceado(String codigo) {
        Stack<Character> pila = new Stack<>();

        for (int i = 0; i < codigo.length(); i++) {
            char c = codigo.charAt(i);

            // Si es un símbolo de apertura, lo agregamos a la pila
            if (c == '(' || c == '{' || c == '[') {
                pila.push(c);
            } 
            // Si es un símbolo de cierre, verificamos el tope de la pila
            else if (c == ')' || c == '}' || c == ']') {
                if (pila.isEmpty()) {
                    return false; // Hay un cierre sin apertura
                }

                char tope = pila.pop();
                if (!esPareja(tope, c)) {
                    return false; // El cierre no coincide con la última apertura
                }
            }
        }
        // Si la pila está vacía al final, todo está correcto
        return pila.isEmpty();
    }

    private boolean esPareja(char abre, char cierra) {
        return (abre == '(' && cierra == ')') ||
               (abre == '{' && cierra == '}') ||
               (abre == '[' && cierra == ']');
    }
}
