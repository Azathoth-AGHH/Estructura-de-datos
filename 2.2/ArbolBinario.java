import java.util.LinkedList;
import java.util.Queue;

public class ArbolBinario {
    Nodo raiz;

    public void insertar(int dato) {
        raiz = insertarNivel(raiz, dato);
    }

    private Nodo insertarNivel(Nodo raiz, int dato) {
        if (raiz == null) return new Nodo(dato);

        Queue<Nodo> cola = new LinkedList<>();
        cola.add(raiz);

        while (!cola.isEmpty()) {
            Nodo actual = cola.poll();
            if (actual.izquierdo == null) {
                actual.izquierdo = new Nodo(dato);
                break;
            } else {
                cola.add(actual.izquierdo);
            }
            if (actual.derecho == null) {
                actual.derecho = new Nodo(dato);
                break;
            } else {
                cola.add(actual.derecho);
            }
        }
        return raiz;
    }

    public void preorden(Nodo nodo) {
        if (nodo == null) return;
        System.out.print(nodo.dato + " ");
        preorden(nodo.izquierdo);
        preorden(nodo.derecho);
    }

    public void inorden(Nodo nodo) {
        if (nodo == null) return;
        inorden(nodo.izquierdo);
        System.out.print(nodo.dato + " ");
        inorden(nodo.derecho);
    }

    public void postorden(Nodo nodo) {
        if (nodo == null) return;
        postorden(nodo.izquierdo);
        postorden(nodo.derecho);
        System.out.print(nodo.dato + " ");
    }
}