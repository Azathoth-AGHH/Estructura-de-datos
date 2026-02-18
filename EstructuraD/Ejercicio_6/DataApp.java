class ClassDataApp {
    public static void main(String[] args) {
        ClassDataArray arr = new ClassDataArray(100);

        // Inserción de los 10 registros originales
        arr.insert("Evans", "Patty", 24);
        arr.insert("Smith", "Lorraine", 37);
        arr.insert("Yee", "Tom", 43);
        arr.insert("Adams", "Henry", 63);
        arr.insert("Hashimoto", "Sato", 21);
        arr.insert("Stimson", "Henry", 29);
        arr.insert("Velasquez", "Jose", 72);
        arr.insert("Lamarque", "Henry", 54);
        arr.insert("Vang", "Minh", 22);
        arr.insert("Creswell", "Lucinda", 18);

        // --- 1. SECCIÓN ORIGINAL ---
        System.out.println("--- Resultado Original ---");
        arr.displayA();
        
        System.out.print("Found");
        Person found = arr.find("Stimson");
        if(found != null) found.displayPerson();

        System.out.println("Deleting Smith, Yee, and Creswell");
        arr.delete("Smith");
        arr.delete("Yee");
        arr.delete("Creswell");
        arr.displayA();

        // --- 2. SECCIÓN DE FRAGMENTOS (NUEVA) ---
        System.out.println("\n--- Nuevo Método (Fragmentos) ---");
        
        System.out.println("Buscando 'pat' (en minúsculas):");
        Person p1 = arr.findPartial("mOto");
        if(p1 != null) p1.displayPerson();
        else System.out.println("   Resultado: null (No encontrado)");

        System.out.println("\nBuscando 'STIM' (en mayúsculas):");
        Person p2 = arr.findPartial("STIM");
        if(p2 != null) p2.displayPerson();
        else System.out.println("   Resultado: null (No encontrado)");

        // RESULTADO PARA 'rrain': Como Smith fue eliminada, aquí saldrá null
        System.out.println("\nBuscando fragmento 'rrain':");
        Person p3 = arr.findPartial("rrain");
        if(p3 != null) {
            p3.displayPerson();
        } else {
            System.out.println("   Resultado: null (No encontrado, probablemente fue eliminado)");
        }
    }
}