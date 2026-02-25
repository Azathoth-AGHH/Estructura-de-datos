package Listas;

public class Main {
    public static void main(String[] args){

        // ===== LISTAS SIMPLES =====
        System.out.println("\n=== Lista Simple - ArrayList ===");
        ListaSimpleArrayList listaSA = new ListaSimpleArrayList();
        listaSA.insertar(5);
        listaSA.insertar(10);
        listaSA.mostrar();

        System.out.println("\n=== Lista Simple - Arreglo ===");
        ListaSimpleArreglo listaSArr = new ListaSimpleArreglo(10);
        listaSArr.insertar(15);
        listaSArr.insertar(20);
        listaSArr.mostrar();

        System.out.println("\n=== Lista Simple - LinkedList ===");
        ListaSimpleLista listaSL = new ListaSimpleLista();
        listaSL.insertar(25);
        listaSL.insertar(30);
        listaSL.mostrar();

        System.out.println("\n=== Lista Simple - Vector ===");
        ListaSimpleVector listaSV = new ListaSimpleVector();
        listaSV.insertar(35);
        listaSV.insertar(40);
        listaSV.mostrar();


        // ===== LISTAS DOBLES =====
        System.out.println("\n=== Lista Doble - ArrayList ===");
        ListaDobleArrayList listaDA = new ListaDobleArrayList();
        listaDA.insertar(100);
        listaDA.insertar(200);
        listaDA.mostrar();

        System.out.println("\n=== Lista Doble - Arreglo ===");
        ListaDobleArreglo listaDArr = new ListaDobleArreglo(10);
        listaDArr.inserter(300);   // OJO: el método se llama inserter
        listaDArr.inserter(400);
        listaDArr.mostrar();

        System.out.println("\n=== Lista Doble - LinkedList ===");
        ListaDobleLista listaDL = new ListaDobleLista();
        listaDL.insertar(500);
        listaDL.insertar(600);
        listaDL.mostrar();

        System.out.println("\n=== Lista Doble - Vector ===");
        ListaDobleVector listaDV = new ListaDobleVector();
        listaDV.insertar(700);
        listaDV.insertar(800);
        listaDV.mostrar();
    }
}