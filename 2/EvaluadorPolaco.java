import java.util.Stack;

public class EvaluadorPolaco {

    // Método que realiza la evaluación usando una PILA
    public double evaluar(String expresion) throws Exception {
        Stack<Double> pila = new Stack<>();
        String[] elementos = expresion.split(" ");

        for (String e : elementos) {
            if (esNumero(e)) {
                // Si es número, push a la pila
                pila.push(Double.parseDouble(e));
            } else {
                // Si es operador, pop a los últimos dos operandos
                if (pila.size() < 2) throw new Exception("Expresión incompleta");
                
                double num2 = pila.pop();
                double num1 = pila.pop();
                pila.push(operar(num1, num2, e));
            }
        }
        
        if (pila.size() != 1) throw new Exception("Sobran operandos");
        return pila.pop();
    }

    private boolean esNumero(String s) {
        return s.matches("-?\\d+(\\.\\d+)?");
    }

    private double operar(double a, double b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
            default: return 0;
        }
    }
}