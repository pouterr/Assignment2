# Assignment2
# MyArrayList

MyArrayList is a generic class that implements the MyList interface. It represents a dynamic array that can grow or shrink in size as elements are added or removed.

**Constructors**

`MyArrayList()` : Constructs an empty list with an initial capacity of 5.

**Public Methods**

`int size()` : Returns the number of elements in this list.

`boolean contains(Object o)` : Returns true if this list contains the specified element, false otherwise.

`void add(T element)` : Appends the specified element to the end of this list.

`void add(T item, int index)` : Inserts the specified element at the specified position in this list.

`boolean remove(T item)` : Removes the first occurrence of the specified element from this list, if it is present.

`void remove(int index)` : Removes the element at the specified position in this list.

`void clear()` : Removes all the elements from this list and sets the array size to 5.

`T get(int index)` : Returns the element at the specified position in this list.

`int indexOf(Object o)` : Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.

`int lastIndexOf(Object o)` : Returns the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element.

`void sort()` : Sorts the elements of the list in ascending order. Only works if the elements are integers.

**Private Methods**

`void increaseBuffer()` : Doubles the size of the array.

**Exception Handling**

`checkIndex(int index)` : Checks if the given index is within the bounds of the list. Throws an IndexOutOfBoundsException if the index is less than 0 or greater than or equal to the size of the list.

# MyLinkedList

MyLinkedList is a generic class that implements the MyList interface. It represents a linked list data structure that can grow or shrink in size as elements are added or removed. The linked list consists of nodes, each containing an element, a reference to the next node and a reference to the previous node.

**Constructors**

`MyLinkedList()`: Constructs an empty list with no elements.

**Public Methods**

`void add(T element)`: Appends the specified element to the end of this list.

`int size()`: Returns the number of elements in this list.

boolean contains(Object o)`: Returns true if this list contains the specified element, false otherwise.

`void add(T item, int index)`: Inserts the specified element at the specified position in this list.

`boolean remove(T item)`: Removes the first occurrence of the specified element from this list, if it is present.

`void remove(int index)`: Removes the element at the specified position in this list.

`void clear()`: Removes all the elements from this list.

`T get(int index)`: Returns the element at the specified position in this list.

`int indexOf(Object o)`: Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.

`int lastIndexOf(Object o)`: Returns the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element.

**Private Methods**

`void increaseBuffer()`: Doubles the size of the array.
