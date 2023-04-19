public class MyLinkedList<T> implements MyList<T> {
    private class Node {
        T element;
        Node next;
        Node prev;

        public Node(T element, Node next, Node prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node head;
    private Node tail;
    private int size;
    @Override
    public void add(T element) {
        Node newNode = new Node(element, null, tail);
        if (size == 0) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        Node current = head;
        while (current != null) {
            if (current.element.equals(o)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public void add(T item, int index) {

    }

    @Override
    public boolean remove(T item) {
        Node current = head;
        while (current != null) {
            if (current.element.equals(item)) {
                // Found the element, remove it
                if (current.prev == null) {
                    // Element is at head
                    head = current.next;
                } else {
                    current.prev.next = current.next;
                }
                if (current.next == null) {
                    // Element is at tail
                    tail = current.prev;
                } else {
                    current.next.prev = current.prev;
                }
                current.prev = null;
                current.next = null;
                size--;
                return true;
            }
            current = current.next;
        }
        return false; // Element not found
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node current;
        if (index == 0) {
            current = head;
            head = current.next;
            if (head != null) {
                head.prev = null;
            }
            current.next = null;
        } else if (index == size - 1) {
            current = tail;
            tail = current.prev;
            if (tail != null) {
                tail.next = null;
            }
            current.prev = null;
        } else {
            if (index < size / 2) {
                current = head;
                for (int i = 0; i < index; i++) {
                    current = current.next;
                }
            } else {
                current = tail;
                for (int i = size - 1; i > index; i--) {
                    current = current.prev;
                }
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
            current.prev = null;
            current.next = null;
        }
        size--;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node current = head;
        int i = 0;
        while (i < index) {
            current = current.next;
            i++;
        }
        return current.element;
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
