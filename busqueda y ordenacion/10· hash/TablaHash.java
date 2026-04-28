/**
 * Tabla Hash con encadenamiento para manejo de colisiones
 * Mapea claves a indices mediante funcion hash
 * Complejidad promedio: O(1)
 */
public class TablaHash {
    // Clase interna para almacenar pares clave-valor
    class Entrada {
        int clave;
        String valor;
        Entrada siguiente;
        
        Entrada(int clave, String valor) {
            this.clave = clave;
            this.valor = valor;
            this.siguiente = null;
        }
    }
    
    private Entrada[] tabla;
    private int capacidad;
    
    public TablaHash(int capacidad) {
        this.capacidad = capacidad;
        this.tabla = new Entrada[capacidad];
    }
    
    // Funcion hash: modulo de la clave
    private int hash(int clave) {
        return Math.abs(clave) % capacidad;
    }
    
    /**
     * Inserta un par clave-valor
     * Si la clave existe, actualiza el valor
     */
    public void insertar(int clave, String valor) {
        int indice = hash(clave);
        Entrada nueva = new Entrada(clave, valor);
        
        // Si la posicion esta vacia, inserta directamente
        if (tabla[indice] == null) {
            tabla[indice] = nueva;
            return;
        }
        
        // Recorre la lista enlazada en esa posicion
        Entrada actual = tabla[indice];
        while (actual != null) {
            // Si encuentra la clave, actualiza el valor
            if (actual.clave == clave) {
                actual.valor = valor;
                return;
            }
            // Si llego al final, agrega al final (encadenamiento)
            if (actual.siguiente == null) {
                actual.siguiente = nueva;
                return;
            }
            actual = actual.siguiente;
        }
    }
    
    /**
     * Busca un valor por su clave
     * Retorna el valor o null si no existe
     */
    public String buscar(int clave) {
        int indice = hash(clave);
        Entrada actual = tabla[indice];
        
        // Recorre la lista enlazada en esa posicion
        while (actual != null) {
            if (actual.clave == clave) {
                return actual.valor;
            }
            actual = actual.siguiente;
        }
        
        return null;  // No encontrado
    }
    
    public void mostrar() {
        for (int i = 0; i < capacidad; i++) {
            System.out.print("Indice " + i + ": ");
            Entrada actual = tabla[i];
            if (actual == null) {
                System.out.println("vacio");
            } else {
                while (actual != null) {
                    System.out.print("[" + actual.clave + "->" + actual.valor + "] ");
                    actual = actual.siguiente;
                }
                System.out.println();
            }
        }
    }
}