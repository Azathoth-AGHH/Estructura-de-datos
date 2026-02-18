public class Busqueda_Binaria {

    public static void main(String[] args) {

        int[] datos = {3, 7, 12, 18, 25, 31, 42, 56, 63, 77};// Arreglo ordenado

        Busqueda b = new Busqueda();

        int numeroBuscar = 100; // Número que queremos encontrar

        int resultado = b.buscar(datos, 0, datos.length - 1, numeroBuscar);// Llamada al método de búsqueda binaria

        if (resultado != -1) {// Si el resultado no es -1, significa que se encontró el elemento
            System.out.println("Elemento encontrado en la posición: " + resultado);// Imprime la posición del elemento encontrado
        } else {// Si el resultado es -1, significa que no se encontró el elemento
            System.out.println("Elemento no encontrado.");// Imprime un mensaje indicando que el elemento no se encontró
        }
    }
}