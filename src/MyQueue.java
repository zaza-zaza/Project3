import java.util.NoSuchElementException;

public class MyQueue<T> extends MyArrayList{
    private MyArrayList<T> list;

    public MyQueue() {
        this.list = new MyArrayList<>();
    }

    public void enqueue(T element) {
        list.add(element);
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        T front = list.get(0);
        list.removeAtIndex(0);
        return front;
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }

    public void print() {
        list.print();
    }
}
