import java.util.Iterator;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * @author Zachary Garson
 * zgarson@u.rochester.edu
 * 12/10/23
 * Project 3
 */
// created an arraylist class from scratch for the purposes of this project
public class MyArrayList<T> implements Iterable<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;

    public MyArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public T add(int i, T element) {
        ensureCapacity();
        elements[size++] = element;
        return element;
    }
    public T add(T element) {
        ensureCapacity();
        elements[size++] = element;
        return element;
    }
    public void add(int element) {
        ensureCapacity();
        elements[size++] = element;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) elements[index];
    }

    public T getLast() {
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }
        return get(size - 1);
    }

    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(elements[i])) {
                return true;
            }
        }
        return false;
    }

    public void remove(T element) {
        int index = indexOf(element);
        if (index != -1) {
            removeAtIndex(index);
        }
    }

    private int indexOf(T element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }

    void removeAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        size--;
    }

    public void print() {
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.print(elements[i]);
            if (i < size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            int newCapacity = elements.length * 2;
            elements = copyArray(elements, newCapacity);
        }
    }

    private Object[] copyArray(Object[] oldArray, int newCapacity) {
        Object[] newArray = new Object[newCapacity];
        System.arraycopy(oldArray, 0, newArray, 0, size);
        return newArray;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            @SuppressWarnings("unchecked")
            public T next() {
                return (T) elements[currentIndex++];
            }
        };
    }
    public boolean removeIf(Predicate<T> filter) {
        Objects.requireNonNull(filter);
        boolean removed = false;
        Iterator<T> iterator = iterator();
        while (iterator.hasNext()) {
            T element = iterator.next();
            if (filter.test(element)) {
                iterator.remove();
                removed = true;
            }
        }
        return removed;
    }
    public static void main(String[] args) {
        MyArrayList<String> MyArrayList = new MyArrayList<>();

        MyArrayList.add(0, "Element 1");
        MyArrayList.add(0, "Element 2");
        MyArrayList.add(0, "Element 3");

        System.out.println("Size of MyArrayList: " + MyArrayList.size());
        System.out.println("Element at index 1: " + MyArrayList.get(1));
        System.out.println("Last element: " + MyArrayList.getLast());
        System.out.println("Contains 'Element 2': " + MyArrayList.contains("Element 2"));
        System.out.println("Contains 'Element 4': " + MyArrayList.contains("Element 4"));

        System.out.print("Elements in the list: ");
        MyArrayList.print();

        MyArrayList.remove("Element 2");
        System.out.print("After removing 'Element 2': ");
        MyArrayList.print();

        System.out.println("Iterating through the list using for-each loop:");
        for (String element : MyArrayList) {
            System.out.println(element);
        }
    }
}
