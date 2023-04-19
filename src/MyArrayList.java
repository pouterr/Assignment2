public class MyArrayList<T> implements MyList<T>{
    private T[] arr;
    private int size;

    public MyArrayList(){
        this.arr= (T[]) new Object[5];
        this.size = 0;};

    @Override
    public int size() {
        return size;//
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(T element) {
        if(size == arr.length){
            increaseBuffer();
        }
        arr[size++] = element;
    }

    public void increaseBuffer(){
        T[] newArr = (T[]) new Object[arr.length*2];
        for(int i=0; i< arr.length; i++){
            newArr[i]=arr[i];
        }
        arr = newArr;
    }

    @Override
    public void add(T item, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        if (size == arr.length) {
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

    @Override
    public boolean remove(T item) {
        return false;
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[size - 1] = null;
        size--;
    }

    @Override
    public void clear() {
        this.arr = (T[]) new Object[5];
        this.size = 0;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return arr[index];
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size - 1; i++) {
            if(arr[i].equals(o)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int lastindex = -1;
        for(int i = 0; i<size-1;i++){
            if(arr[i].equals(o)){
                lastindex = i;
            }
        }
        return lastindex;
    }

    @Override
    public void sort() {
        if (!(arr[0] instanceof Integer)) {
            throw new UnsupportedOperationException("List is not integer. You can't sort it");
        }

        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if ((Integer)arr[j] > (Integer)arr[j + 1]) {
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public void checkIndex(int index){
        if(index < 0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
    }
}
