import java.util.ArrayList;

public class ArrayListLogica {

    public void ejecutar() {

        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println("Element: " + list.get(0));

        list.set(0, 10);
        list.remove(1);

        System.out.println("Size: " + list.size());
        System.out.println(list);
    }
}