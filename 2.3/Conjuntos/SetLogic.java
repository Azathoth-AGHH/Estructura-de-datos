import java.util.HashSet;

public class SetLogic {

    public void ejecutar() {

        HashSet<String> set = new HashSet<>();

        set.add("A");
        set.add("B");
        set.add("A"); // duplicado

        System.out.println("Size: " + set.size());

        System.out.println("Contains B: " + set.contains("B"));

        set.remove("B");

        System.out.println("Empty: " + set.isEmpty());

        System.out.println(set);
    }
}