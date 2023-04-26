/**
 * A generic linked list implementation of the MyList interface.
 * Elements are added to the end of the list and can be accessed by index.
 */
public class MyLinkedList<T> implements MyList<T> {
        // The Node class represents a node in the linked list
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

        private Node head; // The first node in the linked list
        private Node tail; // The last node in the linked list
        private int size; // The number of elements in the linked list

    /**
     * Adds the specified element to the end of this list.
     *
     * @param element the element to be added to the list
     */
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
    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
        @Override
        public int size() {
            return size;
        }
    /**
     * Returns true if this list contains the specified element.
     *
     * @param o the element to be searched for in the list
     * @return true if the list contains the specified element, false otherwise
     */
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
    /**
     * Inserts the specified element at the specified position in this list.
     *
     * @param item the element to be inserted into the list
     * @param index the index at which the specified element is to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
        @Override
        public void add(T item, int index) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
            }
            Node newNode = new Node(item, null, null);
            if (index == 0) {
                newNode.next = head;
                head = newNode;
            } else if (index == size) {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            } else {
                Node current = head;
                for (int i = 0; i < index - 1; i++) {
                    current = current.next;
                }
                newNode.next = current.next;
                newNode.prev = current;
                current.next.prev = newNode;
                current.next = newNode;
            }
            size++;
        }
    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     *
     * @param item the element to be removed from the list
     * @return true if the list contained the specified element, false otherwise
     */
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
    /**
     * Removes the element at the specified position in this list.
     *
     * @param index the index of the element to be removed
     * @throws IndexOutOfBoundsException if the index is out of range
     */
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
    /**
     * Removes all the elements from this list.
     */
        @Override
        public void clear() {
            Node current = head;
            while (current != null) {
                Node next = current.next;
                current.next = null;
                current.prev = null;
                current = next;
            }
            head = null;
            tail = null;
            size = 0;
        }
    /**
     * Returns the element at the specified position in this list.
     *
     * @param index the index of the element to be returned
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
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
    /**
     * Returns the index of the first occurrence of the specified element in this list,
     * or -1 if this list does not contain the element.
     *
     * @param o the element to be searched for in the list
     * @return the index of the first occurrence of the element in this list, or -1 if not found
     */
        @Override
        public int indexOf(Object o) {
            Node current = head;
            int index = 0;
            while (current != null) {
                if (current.element.equals(o)) {
                    return index;
                }
                current = current.next;
                index++;
            }
            return -1;
        }
/**
 * Returns the index of the last occurrence of the specified element in this list,
 * or -1 if this
 * * list does not contain the element.
 *  *
 *  * @param o the element to be searched for in the list
 *  * @return the index of the last occurrence of the element in this list, or -1 if not found
 *  */
        @Override
        public int lastIndexOf(Object o) {
            Node current = tail;
            int index = size - 1;
            while (current != null) {
                if (current.element.equals(o)) {
                    return index;
                }
                current = current.prev;
                index--;
            }
            return -1;
        }

        @Override
        public void sort() {
//            if (size < 2){
//                return;
//            }
//            Node<T> curr = head;
//            Node<T> index;
//            T temp;
//
//            while (curr != null){
//                index = curr.next;
//                while (index != null){
//                    if (((Comparable<T>)curr.data).compareTo(index.data) > 0){
//                        temp = curr.data;
//                        curr.data = index.data;
//                        index.data = temp;
//                    }
//                    index = index.next;
//                }
//                curr = curr.next;
//            }
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
