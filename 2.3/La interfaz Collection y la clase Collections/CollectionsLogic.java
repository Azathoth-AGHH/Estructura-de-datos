import java.util.ArrayList;
import java.util.Collections;

public class CollectionsLogic {

    public void ejecutar() {

        ArrayList<Integer> list = new ArrayList<>();

        // Agregar elementos
        list.add(10);
        list.add(5);
        list.add(20);

        System.out.println("Size: " + list.size());
        System.out.println("Contains 5: " + list.contains(5));

        // Ordenar
        Collections.sort(list);
        System.out.println("Sorted: " + list);

        // Invertir
        Collections.reverse(list);
        System.out.println("Reversed: " + list);

        // Mezclar
        Collections.shuffle(list);
        System.out.println("Shuffled: " + list);

        // Máximo y mínimo
        System.out.println("Max: " + Collections.max(list));
        System.out.println("Min: " + Collections.min(list));

        // Búsqueda
        Collections.sort(list);
        System.out.println("Search 10: " + Collections.binarySearch(list, 10));

        // Eliminar y limpiar
        list.remove(Integer.valueOf(5));
        list.clear();

        System.out.println("Empty: " + list.isEmpty());
    }
}