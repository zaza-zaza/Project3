import java.util.NoSuchElementException;

/**
 * @author Zachary Garson
 * zgarson@u.rochester.edu
 * 11/05/23
 * Lab 7
 */


public class Heap<T extends Comparable<T>> implements UR_Heap<T> {

	// initializing heap and the heap size
	protected T[] heap;
	protected int heapSize;	
	protected int position;
	
	public Heap() {
		heap = (T[]) new Comparable[10];
		heapSize = 0;
		position = -1;
	}
	// resizes the array if it is full
	private void resize (int cap) {
		System.arraycopy(heap, 0, heap = (T[]) new Comparable[cap], 0, position + 1);
	}
	private int enumerationCursor = 0;

	// Implementing Enumeration methods

	public boolean hasMoreElements() {
		return enumerationCursor < heapSize;
	}


	public T nextElement() {
		if (!hasMoreElements()) {
			throw new NoSuchElementException("No more elements in the heap");
		}
		return heap[enumerationCursor++];
	}

	// Additional methods for resetting enumeration
	public void resetEnumeration() {
		enumerationCursor = 0;
	}

	@Override
	public void insert(T item) {

		try {
			if (heapSize == heap.length - 1) {
				resize(2 * heap.length);
				throw new IllegalArgumentException("Heap is full");
			} else {
				heapSize++;
				position++;
				heap[heapSize - 1] = item;
				bubbleUp(heapSize - 1);
			}
		} catch (IndexOutOfBoundsException e){
			e.getMessage();
		} finally{
			resize(1 + heap.length);
		}
	}
	
	private void bubbleUp(int index){
		int parentIndex = 0;
		while (index > 0) {
			parentIndex = (index - 1 ) / 2;
			if(heap[index].compareTo(heap[parentIndex]) >= 0) return;
			else {
				swap(index, parentIndex);
				bubbleUp(index);
			}
		}
	}
	
	// swapping method makes implementation of 
	// other algorithms easier
	public void swap(int one, int two) {
		T tmp = heap[one];
		heap[one] = heap[two];
		heap[two] = tmp;
	}
		
	
	@Override
	public boolean isEmpty() {
		if(heap[0] == null) {
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		return heapSize;
	}

	@Override
	public T deleteMin() {
		if(isEmpty()) {
			throw new IllegalArgumentException("Heap is empty.");
		} else {
			T minElement = heap[0];
			heap[0] = heap[heapSize - 1];
			heapSize--;
			if(heapSize > 0) {
				bubbleDown();
			}
			return minElement;
		}

    }

	private void bubbleDown() {
		int childIndex = 2 * position + 1;
		T value = heap[position];

		while (childIndex < heapSize) {
			T minChild = heap[childIndex];
			int minChildIndex = childIndex;

			// Find the minimum child
			for (int i = 1; i <= 2 && i + childIndex < heapSize; i++) {
				if (heap[i + childIndex].compareTo(minChild) < 0) {
					minChild = heap[i + childIndex];
					minChildIndex = i + childIndex;
				}
			}

			// Check if the minimum child is greater than or equal to the value
			if (minChild.compareTo(value) >= 0) {
				break;
			}

			// Swap with the minimum child
			swap(position, minChildIndex);
			position = minChildIndex;

			// Update childIndex for the next iteration
			childIndex = 2 * position + 1;
		}
	}


	// returns the root of the heap
	public T getRoot() {
		if(isEmpty()) {
			return null;
		} else {
			T result = heap[0];
			heap[0] = heap[position--];
			heap[position + 1] = null;
			bubbleDown();
			return result;
		}
	}
	
	@Override
	public void printHeap() {
		
		try {
			for(int i = 0; i < heap.length - 1; i++) {
				if(heap[i].equals(null)) {
					continue;
				} else {
					System.out.println(heap[i]);
				}
			}
		} catch(NullPointerException e) {}		
	}

	@Override
	public void heapify() {
		int n = heap.length - 1;
		for(int i = n - 1 / 2 - 1; i >= 0; i--) {
			bubbleDown();
		}
		for(int i = heap.length - 1; i > 0; i--) {
			swap(0, i);
				bubbleDown();
		}
	}

	public static void main(String[] args) {
		
		Heap<Integer> heap = new Heap<>();
		
		
		System.out.println("isEmpty: " + heap.isEmpty());
		System.out.println("Size: " + heap.size());

		
		heap.insert(1);
		heap.insert(2);
		heap.insert(3);
		heap.insert(4);
		heap.insert(5);
		heap.insert(6);
		heap.insert(7);
		heap.insert(8);
		
		
		heap.printHeap();
		
		System.out.println("Heap size: " + heap.size());
		
		heap.deleteMin();

		System.out.println("Heap size after deletion: " + heap.size());
		System.out.println("Heap after deletion:");
		heap.printHeap();
		
		System.out.println("Heap after Heapification:");
		heap.heapify();
		heap.printHeap();
		
		System.out.println("Root: " + heap.getRoot());

		
	

		
//		heap.printHeap();
		
//		heap.heapify();
//		System.out.println(heap.size());
		
//		System.out.println(heap.size());
//		heap.printHeap();
		

	}

	
	
}
