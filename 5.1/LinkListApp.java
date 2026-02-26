class LinkListApp {
    public static void main(String[] args) {
        LinkList theList = new LinkList();   // creamos una nueva lista enlazada

        // Insertamos 4 elementos al inicio (se insertan en orden inverso)
        theList.insertFirst(22, 2.99);
        theList.insertFirst(44, 4.99);
        theList.insertFirst(66, 6.99);
        theList.insertFirst(88, 8.99);

        theList.displayList();   // mostramos la lista completa

        // Eliminamos elementos uno por uno hasta vaciar la lista
        while (!theList.isEmpty()) {
            Link aLink = theList.deleteFirst();   // eliminamos el primero
            
            System.out.print("Deleted ");
            aLink.displayLink();                  // mostramos el que eliminamos
            System.out.println("");
            
            theList.displayList();                // mostramos cómo quedó la lista
        }
    }
}