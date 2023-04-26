public class MyArrayList<T> implements MyList<T>{
    private T[] arr;
    private int size;

    /**
     * Constructs an empty list with an initial capacity of 5.
     */
    public MyArrayList(){
        this.arr= (T[]) new Object[5];
        this.size = 0;};

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return size;//
    }

    /**
     * Returns true if this list contains the specified element, false otherwise.
     *
     * @param o the element to be checked for containment in this list
     * @return true if this list contains the specified element, false otherwise
     */
    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param element the element to be appended to this list
     */
    @Override
    public void add(T element) {
        if(size == arr.length){
            increaseBuffer();
        }
        arr[size++] = element;
    }

    /**
     * Doubles the size of the array.
     */
    public void increaseBuffer(){
        T[] newArr = (T[]) new Object[arr.length*2]; // Create a new array with twice the size
        for(int i=0; i< arr.length; i++){ // Loop through the old array
            newArr[i]=arr[i]; // Copy its elements to the new array
        }
        arr = newArr; // Replace the old array with the new one
    }

    /**
     * Inserts the specified element at the specified position in this list.
     *
     * @param item the element to be inserted into this list
     * @param index the index at which the specified element is to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public void add(T item, int index) {
        if (index < 0 || index > size) { // If the specified index is out of range
            throw new IndexOutOfBoundsException("Invalid index: " + index); // Throw an exception
        }

        if (size == arr.length) { // If the array is full
            // Resize the array if it is full
            T[] newArr = (T[]) new Object[size * 2];
            for (int i = 0; i < size; i++) {
                newArr[i] = arr[i];
            }
            arr = newArr;
        }

        // Shift elements to the right
        for (int i = size - 1; i >= index; i--) {
            arr[i + 1] = arr[i];
        }

        // Insert the new element
        arr[index] = item;
        size++;
    }

    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     *
     * @param item the element to be removed from this list, if present
     * @return true if this list contained the specified element, false otherwise
     */
    @Override
    public boolean remove(T item) {
        for (int i = 0; i < size; i++) { // Loop through the array
            if(arr[i].equals(item)){ // If the element at the current index equals the specified object
                remove(i); // Remove the element at the current index
                return true; // Return true to indicate that the element was removed
            }
        }
        return false; // Otherwise, return false to indicate that the element was not found
    }

    /**

     *Removes the element at the specified position in this list.
     *@param index the index of the element to be removed
     *@throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
     */
    @Override
    public void remove(int index) {
        // Check if the given index is valid
        checkIndex(index);

        // Shift the elements to the left
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }

        // Remove the last element and decrease the size
        arr[size - 1] = null;
        size--;
    }

    /**
     *Removes all the elements from this list and sets the array size to 5.
     */
    @Override
    public void clear() {
        this.arr = (T[]) new Object[5];
        this.size = 0;
    }


    /**
     * Returns the element at the specified position in this list.
     *
     * @param index the index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     *                                   (<tt>index &lt; 0 || index &gt;= size()</tt>)
     */
    @Override
    public T get(int index) {
        // Check if the index is within the valid range
        checkIndex(index);
        // Return the element at the specified index
        return arr[index];
    }


    /**
     * Returns the index of the first occurrence of the specified element in this list,
     * or -1 if this list does not contain the element.
     *
     * @param o the element to search for
     * @return the index of the first occurrence of the specified element in this list,
     * or -1 if this list does not contain the element
     */
    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size - 1; i++) {
            if(arr[i].equals(o)){
                return i;
            }
        }
        return -1; // element not found
    }


    /**
     * Returns the index of the last occurrence of the specified element in this list,
     * or -1 if this list does not contain the element.
     *
     * @param o the element to search for
     * @return the index of the last occurrence of the specified element in this list,
     * or -1 if this list does not contain the element.
     */
    @Override
    public int lastIndexOf(Object o) {
        int lastindex = -1;
        for(int i = 0; i<size;i++){
            if(arr[i].equals(o)){
                lastindex = i;
            }
        }
        return lastindex;
    }


    /**
     * Sorts the elements of the list in ascending order. Only works if the elements are integers.
     *
     * @throws UnsupportedOperationException if the elements in the list are not integers
     */
    @Override
    public void sort() {
        // Check if the elements in the list are integers
        if (!(arr[0] instanceof Integer)) {
            throw new UnsupportedOperationException("List is not integer. You can't sort it");
        }

        // Sort the elements using bubble sort algorithm
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if ((Integer) arr[j] > (Integer) arr[j + 1]) {
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }


    /**
     * Checks if the given index is within the bounds of the list.
     *
     * @param index the index to check
     * @throws IndexOutOfBoundsException if the index is less than 0 or greater than or equal to the size of the list
     */
    public void checkIndex(int index){
        if(index < 0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
    }

    public void addAll(T[] arr, int index){
        if(index<0 || index >= size){
            throw new IndexOutOfBoundsException("Invalid index. Try again please");
        }
        for(T item:arr){
            add(item,index);
        }
    }
}
