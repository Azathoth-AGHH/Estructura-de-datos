class OrdArray {
    private long[] a;           // ref to array a
    private int nElems;         // number of data items
    // constructor
    public OrdArray(int max) {
        a = new long[max];      // create the array
        nElems = 0;             // no items yet
    }
    // return number of elements
    public int size() {
        return nElems;
    }
    // binary search - returns index if found, or nElems if not found
    public int find(long searchKey) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;

        while (true) {
            curIn = (lowerBound + upperBound) / 2;

            if (a[curIn] == searchKey) {
                return curIn;           // found it
            } else if (lowerBound > upperBound) {
                return nElems;          // can't find it
            } else {
                if (a[curIn] < searchKey) {
                    lowerBound = curIn + 1;  // it's in upper half
                } else {
                    upperBound = curIn - 1;  // it's in lower half
                }
            }
        } // end while
    } // end find()
    // insert element (maintains sorted order)
    public void insert(long value) {
        int j;
        for (j = 0; j < nElems; j++) {     // find where it goes
            if (a[j] > value) {            // (linear search)
                break;
            }
        }
        // move bigger elements up to make space
        for (int k = nElems; k > j; k--) {
            a[k] = a[k - 1];
        }
        a[j] = value;                      // insert it
        nElems++;                          // increment size
    } // end insert()
    // delete element (if found)
    public boolean delete(long value) {
        int j = find(value);
        if (j == nElems) {                 // can't find it
            return false;
        } else {                           // found it
            // move higher elements down
            for (int k = j; k < nElems - 1; k++) {
                a[k] = a[k + 1];
            }
            nElems--;                      // decrement size
            return true;
        }
    } // end delete()
    // display array contents
    public void display() {
        for (int j = 0; j < nElems; j++) {
            System.out.print(a[j] + " ");
        }
        System.out.println("");
    }
} // end class OrdArray