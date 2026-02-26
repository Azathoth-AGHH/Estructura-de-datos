class FirstLastListApp {
    public static void main(String[] args) {
        FirstLastList theList = new FirstLastList();

        // Insertamos al inicio
        theList.insertFirst(22);
        theList.insertFirst(44);
        theList.insertFirst(66);

        // Insertamos al final
        theList.insertLast(11);
        theList.insertLast(33);
        theList.insertLast(55);

        System.out.println("Lista inicial:");
        theList.displayList();

        // Eliminamos los dos primeros elementos
        theList.deleteFirst();
        theList.deleteFirst();

        System.out.println("Después de eliminar los dos primeros:");
        theList.displayList();
    }
}