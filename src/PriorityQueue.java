import java.util.NoSuchElementException;

public class PriorityQueue<T extends Comparable<T>> extends Heap<T> {

    public PriorityQueue() {
        super();
    }

    // Additional methods for Priority Queue

    public void enqueue(T item) {
        insert(item);
    }

    public T dequeue() {
        return deleteMin();
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority Queue is empty");
        }
        return heap[0];
    }

    public boolean contains(T item) {
        for (int i = 0; i < heapSize; i++) {
            if (heap[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    public void printPriorityQueue() {
        for (int i = 0; i < heapSize; i++) {
            System.out.println(heap[i]);
        }
    }

}
