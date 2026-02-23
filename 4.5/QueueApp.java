// QueueApp.java
// Programa de prueba para la clase Queue

class QueueApp {
    public static void main(String[] args) {
        Queue laCola = new Queue(5);  // capacidad para 5 elementos

        System.out.println("Insertando elementos...");
        laCola.insert(10);
        laCola.insert(20);
        laCola.insert(30);
        laCola.insert(40);
        laCola.insert(50);

        if (laCola.isFull()) {
            System.out.println("La cola está llena (como debe estar)");
        }

        System.out.println("\nRemoviendo elementos:");
        while (!laCola.isEmpty()) {
            long valor = laCola.remove();
            System.out.print(valor + " ");
        }
        System.out.println("\n");

        // Segunda prueba - comportamiento circular
        System.out.println("Segunda ronda (prueba circular):");
        laCola.insert(100);
        laCola.insert(200);
        laCola.insert(300);

        System.out.println("Frente actual: " + laCola.peekFront());
        System.out.println("Tamaño actual: " + laCola.size());

        System.out.println("Removiendo lo que queda:");
        while (!laCola.isEmpty()) {
            System.out.print(laCola.remove() + " ");
        }
        System.out.println();
    }
}