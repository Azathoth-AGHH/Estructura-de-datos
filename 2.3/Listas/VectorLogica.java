import java.util.Vector;

public class VectorLogica {

    public void ejecutar() {

        Vector<String> v = new Vector<>();

        v.add("One");
        v.add("Two");
        v.add("Three");

        System.out.println("Element: " + v.get(1));

        v.remove(0);

        System.out.println("Size: " + v.size());
        System.out.println(v);
    }
}