class HighArray {
    private long[] a;           // ref to array a
    private int nElems;         // number of data items

    // constructor
    public HighArray(int max) {
        a = new long[max];      // create the array
        nElems = 0;             // no items yet
    }

    // find specified value
    public boolean find(long searchKey) {
        int j;
        for (j = 0; j < nElems; j++) {     // for each element,
            if (a[j] == searchKey) {       // found it?
                break;                     // exit loop before end
            }
        }
        if (j == nElems) {                 // gone to end?
            return false;                  // can't find it
        } else {
            return true;                   // found it
        }
    } // end find()

    // put element into array
    public void insert(long value) {
        a[nElems] = value;                 // insert it
        nElems++;                          // increment size
    }

    // delete element (if found)
    public boolean delete(long value) {
        int j;
        for (j = 0; j < nElems; j++) {     // look for it
            if (value == a[j]) {
                break;
            }
        }
        if (j == nElems) {                 // can't find it
            return false;
        } else {                           // found it
            for (int k = j; k < nElems - 1; k++) {   // move higher ones down
                a[k] = a[k + 1];
            }
            nElems--;                      // decrement size
            return true;
        }
    } // end delete()

    // displays array contents
    public void display() {
        for (int j = 0; j < nElems; j++) {     // for each element,
            System.out.print(a[j] + " ");      // display it
        }
        System.out.println("");                // new line at end
    }
} // end class HighArray
