public class MyArrayList<T> implements MyList<T>{
    private Object[] array;
    private int size = 0;
    private int capacity = 5;
    public MyArrayList(){array = new Object[capacity];};
    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public void add(T element) {
        if(size == capacity){
            capacity = (int) (2*capacity);
            Object[] array2 = new Object[capacity];
            for(int i=0;i<size;i++){
                array2[i] = array[i];
            }
            array = array2;
        }
        array[size++] = element;
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

    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        return null;
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
}
