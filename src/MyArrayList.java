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

    }

    @Override
    public boolean remove(T item) {
        return false;
    }

    @Override
    public void remove(int index) {
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[size - 1] = null;
        size--;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return arr[index];
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public void sort() {

    }

    public void checkIndex(int index){
        if(index < 0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
    }
}
