class ClassDataArray {
    private Person[] a;
    private int nElems;

    public ClassDataArray(int max) {
        a = new Person[max];
        nElems = 0;
    }

    // Búsqueda exacta 
    public Person find(String searchName) {
        int j;
        for(j=0; j<nElems; j++)
            if(a[j].getLast().equals(searchName))
                break;
        if(j == nElems) return null;
        else return a[j];
    }

    // NUEVO MÉTODO: Búsqueda por fragmentos
    public Person findPartial(String searchPart) {
        int j;
        String buscado = searchPart.toLowerCase(); 
        for(j = 0; j < nElems; j++) {
            String apellido = a[j].getLast().toLowerCase();
            String nombre = a[j].getFirst().toLowerCase();
            // Verifica si el fragmento existe en apellido o nombre
            if(apellido.indexOf(buscado) != -1 || nombre.indexOf(buscado) != -1)
                break; 
        }
        if(j == nElems) return null;
        else return a[j];
    }

    public void insert(String last, String first, int age) {
        a[nElems] = new Person(last, first, age);
        nElems++;
    }

    public boolean delete(String searchName) {
        int j;
        for(j=0; j<nElems; j++)
            if(a[j].getLast().equals(searchName)) break;
        if(j==nElems) return false;
        else {
            for(int k=j; k<nElems-1; k++) a[k] = a[k+1];
            nElems--;
            return true;
        }
    }

    public void displayA() {
        for(int j=0; j<nElems; j++)
            a[j].displayPerson();
    }
}