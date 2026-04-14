import java.util.LinkedList;

public class LinkedListLogica {

    public void ejecutar() {

        LinkedList<Integer> list = new LinkedList<>();

        list.add(2);
        list.add(3);

        list.addFirst(1);
        list.addLast(4);

        System.out.println(list);

        System.out.println("Element: " + list.get(2));

        list.removeFirst();
        list.removeLast();

        System.out.println("Final: " + list);
    }
}