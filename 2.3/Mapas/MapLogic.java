import java.util.HashMap;

public class MapLogic {

    public void ejecutar() {

        HashMap<String, Integer> map = new HashMap<>();

        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        System.out.println("Value A: " + map.get("A"));

        System.out.println("Has key B: " + map.containsKey("B"));
        System.out.println("Has value 3: " + map.containsValue(3));

        System.out.println("Keys: " + map.keySet());
        System.out.println("Values: " + map.values());

        map.remove("B");

        System.out.println("Final: " + map);
    }
}