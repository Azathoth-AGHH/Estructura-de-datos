class LinkList2App {
    public static void main(String[] args) {
        LinkList theList = new LinkList();

        // Insertamos elementos (se agregan al inicio → aparecen en orden inverso)
        theList.insertFirst(22, 2.99);
        theList.insertFirst(44, 4.99);
        theList.insertFirst(66, 6.99);
        theList.insertFirst(88, 8.99);

        System.out.println("Lista inicial:");
        theList.displayList();

        // Buscar un elemento
        int claveBuscada = 44;
        Link encontrado = theList.find(claveBuscada);
        
        if (encontrado != null) {
            System.out.print("Found link with key " + encontrado.iData + ": ");
            encontrado.displayLink();
            System.out.println("");
        } else {
            System.out.println("Can't find link with key " + claveBuscada);
        }

        // Eliminar un elemento
        int claveEliminar = 66;
        Link eliminado = theList.delete(claveEliminar);
        
        if (eliminado != null) {
            System.out.print("Deleted link with key " + eliminado.iData + ": ");
            eliminado.displayLink();
            System.out.println("");
        } else {
            System.out.println("Can't delete link with key " + claveEliminar);
        }

        System.out.println("Lista después de la eliminación:");
        theList.displayList();
    }
}