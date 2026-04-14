import java.util.ArrayList;
import java.util.Iterator;

public class GeneralCollections {

    public void ejecutar() {

        // Se crea una lista dinámica
        ArrayList<String> list = new ArrayList<>();

        // Se agregan elementos
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        // Tamaño de la lista
        System.out.println("Size: " + list.size());

        // Verifica si existe un elemento
        System.out.println("Contains Banana: " + list.contains("Banana"));

        // Recorrer la lista con iterador
        Iterator<String> it = list.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        // Eliminar elemento
        list.remove("Banana");

        // Verificar si está vacía
        System.out.println("Is empty: " + list.isEmpty());

        // Limpiar lista
        list.clear();

        System.out.println("After clear: " + list.size());
    }
}