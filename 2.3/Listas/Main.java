public class Main {
    public static void main(String[] args) {

        System.out.println("\n--- ArrayList --- \n");
        ArrayListLogica obj = new ArrayListLogica();
        obj.ejecutar();
        System.out.println("\n--- LinkedList --- \n");
        LinkedListLogica obj2 = new LinkedListLogica();
        obj2.ejecutar();
        System.out.println("\n--- Vector --- \n");
        VectorLogica obj3 = new VectorLogica();
        obj3.ejecutar();
    }
}