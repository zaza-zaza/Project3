import java.util.Collection;
import java.util.Iterator;
import java.util.function.Predicate;

/**
 * @author Zachary Garson
 * zgarson@u.rochester.edu
 * 10/1/23
 * Lab 4
 */

public class URLinkedList<E> implements Iterable<E> {
	
	
	// referencing the head and the tail of the linked list
	private URNode<E> head;
	private URNode<E> tail;
	private URNode<E> n;
	private URNode<E> p;
	
		
	public URLinkedList() {
//		head = new URNode(n, p);
//		tail = new URNode(p, n);	
//		head.setPrev(null);
//		head.setNext(tail);
//		tail.setPrev(head);
//		tail.setNext(null);
		head = null;
		tail = null;
		
	}
		
	public static void main(String[] args) {
		
		URLinkedList<Integer> ll = new URLinkedList<>();
		
		URLinkedList<String> ll2 = new URLinkedList<>();
		
		ll.add(1);
		ll.add(22);
		ll.add(3);
		ll.add(4);
		ll.add(5);
		ll.add(6);
			
	
		
//		ll.containsAll(coll2);
		
//		printLL(ll);
//
//		ll.indexOf(1);
//		ll.equals(77);
//		ll.get(7);
//		ll2.isEmpty();
//		ll.isEmpty();
//		ll.remove(22);
//		ll.size();
//		
//		printLL(ll);	
		
		ll2.add("a");
		ll2.add("b");
		ll2.add("c");
		ll2.add("d");
		ll2.add("e");
		ll2.add("f");
		ll2.add("g");
		
		
		ll2.addFirst("q");
		ll2.addLast("u");
//		ll2.addAll(coll2);
		printLL(ll2);
//		ll2.removeAll(coll2);
//		ll2.remove("c");
//		ll2.equals("g");
//		ll2.set(10, "a");
//		ll2.subList(3, 7);
		System.out.println(ll2.peekFirst());
		System.out.println(ll2.peekLast());
		System.out.println(ll2.pollFirst());
		System.out.println(ll2.pollLast());
		printLL(ll2);
		
			
	}
	
	public int size1() {
		return 0;
		
	}
	
	public static <E> void printLL(URLinkedList<E> ll) {
		URNode<E> current = ll.head;
		
		while(current != null) {
			System.out.print(current.element() + " ");
			current = current.next();
		}
		System.out.println();
	}

	public boolean add(E e) {
		
		URNode<E> newNode = new URNode<E>(e, p, n);
		
		if(tail == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.setNext(newNode);
			newNode.setPrev(tail);
			tail = newNode;
		}
	
		return false;
	}

	public void add(int index, E element) {
		
		if(index < 0) {
			throw new IllegalArgumentException("Index cannot be negative.");
		}
		URNode<E> newNode = new URNode<E>(element, p, n);
		
		if(index == 0) {
			// if the index is 0, insert at the begging of the list
			newNode.setNext(head);
			if(head != null ) {
				head.setPrev(newNode);
			}
			head = newNode;
			
			// if the tail was empty update the tail
			if(tail == null) {
				tail = newNode;
			}
		} else {
			URNode<E> current = head;
			
			int currentIndex = 0;
			
			//traverse list to find node before index
			while(current != null && currentIndex < index - 1) {
				current = current.next();
				currentIndex++;
			}
			
			if(current == null) {
				/**
				 * if the index is >= the size of the list
				 * then add the element at the end of list
				 */
				tail.setNext(newNode);
				newNode.setPrev(tail);
				tail = newNode;
			} else {
				// insert element at specified index
				newNode.setNext(current.next());
				newNode.setPrev(current);
				current.setNext(newNode);
				if(newNode.next() != null) {
					newNode.next().setPrev(newNode);
				}
			}
		}
	}
	 
	public boolean addAll(Collection<? extends E> c) {
		
		for(E element : c) {
			add(element);
		}
		return false;
	}
		
	public boolean addAll(int index, Collection<? extends E> c) {
		
		/**
		 * same concept as adding one element to a specified index
		 * but this method runs for each index in the collection
		 */
		if(index < 0) {
			throw new IllegalArgumentException("Index out of bounds.");
		}
		for(E e : c) {
			URNode<E> newNode = new URNode<E>(e, p, n);
			
			if(index == 0) {
				// if the index is 0, insert at the begging of the list
				newNode.setNext(head);
				if(head != null ) {
					head.setPrev(newNode);
				}
				head = newNode;
				
				// if the tail was empty update the tail
				if(tail == null) {
					tail = newNode;
				}
			} else {
				URNode<E> current = head;
				
				int currentIndex = 0;
				
				//traverse list to find node before index
				while(current != null && currentIndex < index - 1) {
					current = current.next();
					currentIndex++;
				}
				if(current == null) {
					/**
					 * if the index is >= the size of the list
					 * then add the element at the end of list
					 */
					tail.setNext(newNode);
					newNode.setPrev(tail);
					tail = newNode;
				} else {
					// insert element at specified index
					newNode.setNext(current.next());
					newNode.setPrev(current);
					current.setNext(newNode);
					if(newNode.next() != null) {
						newNode.next().setPrev(newNode);
					}
				}
			}
		}
		return false;
	}		
	 
	public void clear() { head = null; tail = null; }

	public boolean contains(Object o) {
		
		// toggle switch will flip true if there is at least
		// one element equal to the object in the argument
		boolean contains = false;
		
		URNode<E> current = head;
		//traverse list and compare each element to the object argument
		while(current != null) {
			if(current.element() == o) {
				contains = true;
				current = current.next();
			} else {
				contains = false;
				current = current.next();
			}
		}
		
		System.out.println("List contains " + o + ": " + contains);
		return contains;
	}
	 
	public boolean containsAll(Collection<?> c) {
		
		boolean out = false;

		// repeat for each object in the collection.
		// the "contains" toggle will flip true if
		// ALL items in the collection are in the linked list
		for(Object e : c) {
			boolean contains = false;
			URNode<E> current = head;
			//traverse list and compare each element to the object argument
			while(current != null) {
				if(current.element() == e) {
					contains = true;
					out = contains;
					current = current.next();
				} else {
					current = current.next();
					out = contains;
				}
			}
		}
		System.out.println("List contains all elements " + c + ": " + out);
		return out;
	}

	public boolean equals(Object o) {
		
		URNode<E> current = head;
		boolean equals = false;
		// creates a toggle switch during iteration
		// when one item is equal to another the toggle flips "true"
		while(current != null) {
			if(((current.element()).equals(o))) {
				equals = true;
				current = current.next();
			} else {
				current = current.next();
			}
		}
		// returns the expected outcome
		System.out.println(o + " equals: " + equals);
		return false;
	}
	
	public E get(int index) {
		
		if(index < 0) {
			throw new IllegalArgumentException("Index is out of bounds");
		}
		
		URNode<E> current = head;
		for(int i = 0; i < index; i++) {
			current = current.next();
		}
		System.out.println(current.element());
		
		return current.element();
	}

	public int indexOf(Object o) {

		boolean contains = false;
		URNode<E> current = head;
		int count = 0;
		//traverse list and compare each element to the object argument
		while(current != null) {
			if(current.element() == o) {
				System.out.println(o + " located at index: " + count);
				contains = true;
				current = current.next();
			} else {
				current = current.next();
			}
			count++;
		}
		if(contains == false) {
			System.out.println(-1);
		}
		
		return 0;
	}

	public boolean isEmpty() {
		
		boolean empty = false;
		// checks if there are any data in the head and the tail. 
		// there can't be a linked list if there is no data in the head or the tail
		if(head == null && tail == null) {
			empty = true;
		}
		// default outcome is false, returns true only if there are a head and tail containing data
		System.out.println("List empty: " + empty);
		
		return false;
	}
	
//	public Iterator<E> iterator() {
//		return new Iterator<E>() {
//            private URNode<E> current = head;
//
//            @Override
//            public boolean hasNext() {
//                return current != null;
//            }
//
//            @Override
//            public E next() {
//                if (!hasNext()) {
//                    throw new java.util.NoSuchElementException();
//                }
//                E element = current.element();
//                current = current.next();
//                return element;
//            }
//
//            @Override
//            public void remove() {
//                throw new UnsupportedOperationException("remove() method is not supported.");
//            }
//        };
//	}
		
	public E remove(int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }

        URNode<E> removedNode;

        if (index == 0) {
            // Removing the first node
            removedNode = head;
            head = head.next();
            if (head != null) {
                head.setPrev(null);
            } else {
                // If the list is now empty, also update the tail
                tail = null;
            }
        } else if (index == size() - 1) {
        	
            // Removing the last node
            removedNode = tail;
            tail = tail.prev();
            if (tail != null) {
                tail.setNext(null);
            } else {
                // If the list is  empty the head will update
                head = null;
            }
        } else {
            // Removing a node in the middle
            URNode<E> current = head;
            int currentIndex = 0;

            // Traverse the list to find the node at the specified index
            while (current != null && currentIndex < index) {
                current = current.next();
                currentIndex++;
            }

            removedNode = current;
            current.prev().setNext(current.next());
            current.next().setPrev(current.prev());
        }

        return removedNode.element();
}
	
	public boolean remove(Object o) {
		
		URNode<E> current = head;
		// if the object is equal to the data stored in the 
		// head, the head is moved to the next value
		if(head.element().equals(o)) {
			head = head.next();
	        if (head != null) {
	            head.setPrev(null);
	        } else {
	            tail = null;
	        }
	        // if the object is equal to the data stored in 
	        // tail, the tail is moved to the previous value
		} else if(tail.element().equals(o)) {
			tail = tail.prev();
			if(tail != null) {
				tail.setNext(null);
			} else {
				head = null;
			}
			// if the data is not equal to the data in either
			// the head to tail, the list is then iterated until
			// the value is found and then the node is removed
		} else {
			while(current != tail) {
				if(current.element().equals(o)) {
					current.prev().setNext(current.next());
		            current.next().setPrev(current.prev());
				}
				current = current.next();
			}
		}
		return false;
	}

	 
	public boolean removeAll(Collection<?> c) {
		//calling iterator
		Iterator<?> iterator = c.iterator();

        while (iterator.hasNext()) {
            Object elementToRemove = iterator.next();
            URNode<E> current = head;

            while (current != null) {
                if (elementToRemove == null ? current.element() == null : elementToRemove.equals(current.element())) {
                    // Found a matching element, remove it
                    URNode<E> prev = current.prev();
                    URNode<E> next = current.next();

                    if (prev != null) {
                        prev.setNext(next);
                    } else {
                        // If it's the first element, update head
                        head = next;
                    }

                    if (next != null) {
                        next.setPrev(prev);
                    } else {
                        // If it's the last element, update tail
                        tail = prev;
                    }
                }
                current = current.next();
            }
        }
			return false;
	}
	 
	public E set(int index, E element) {
		URNode<E> current = head;
        int currentIndex = 0;

        // Traverse the list to find the node at the specified index
        while (current != null && currentIndex < index) {
            current = current.next();
            currentIndex++;
        }
        
        E oldValue = current.element();
        remove(element);
        // Update the element at the specified index with the new element
        current.setElement(element);

        return oldValue;		
        
	}

	public int size() {
		URNode<E> current = head;
		int currentIndex = 0;
		while(current != null) {
			current = current.next();
			currentIndex++;
		}
		return currentIndex;
	}
	 
	public URList<E> subList(int fromIndex, int toIndex) {
		
		 URLinkedList<E> subList = new URLinkedList<>();
	        URNode<E> current = head;
	        int currentIndex = 0;

	        // Traverse the list to find the node at fromIndex
	        while (current != null && currentIndex < fromIndex) {
	            current = current.next();
	            currentIndex++;
	        }

	        // Add elements to the subList from fromIndex (inclusive) to toIndex (exclusive)
	        while (current != null && currentIndex < toIndex) {
	            subList.add(current.element());
	            current = current.next();
	            currentIndex++;
	            
	        }	
	        printLL(subList);
	        
        return null;
	}

	 
	public Object[] toArray() {
		Object[] array = new Object[size()]; // Create an array of the same size as the linked list
        URNode<E> current = head;
        int index = 0;

        // Traverse the list and copy elements to the array
        while (current != null) {
            array[index] = current.element();
            current = current.next();
            index++;
        }

        return array;
	}
	
	// Inserts the specified element at the beginning of this list.
	void addFirst(E e) {
		URNode<E> newNode = new URNode<>(e, n, p);

        if (head == null) {
            // If the list is empty, both head and tail should point to the new node
            head = newNode;
            tail = newNode;
        } else {
            // If the list is not empty, insert the new node at the beginning
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
	}
	// Appends the specified element to the end of this list.
	void addLast(E e) {
		URNode<E> newNode = new URNode<>(e, n, p);

        if (tail == null) {
            // If the list is empty, both head and tail should point to the new node
            head = newNode;
            tail = newNode;
        } else {
            // If the list is not empty, append the new node to the end
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
	}
	// Retrieves, but does not remove, the first element of this list, or returns null if
	// this list is empty.
	E peekFirst() {
		if (head == null) {
            // The list is empty, return null
            return null;
        } else {
            // Return the element at the head of the list
            return head.element();
        }
	}
	// Retrieves, but does not remove, the last element of this list, or returns null if
	// this list is empty.
	E peekLast() {
		if (tail == null) {
            // The list is empty, return null
            return null;
        } else {
            // Return the element at the tail of the list
            return tail.element();
        }
	}
	// Retrieves and removes the first element of this list, or returns null if this list
	// is empty.
	E pollFirst() {
		if (head == null) {
            // The list is empty, return null
            return null;
        } else {
            // Retrieve and remove the element at the head of the list
            E element = head.element();
            head = head.next();
            
            if (head == null) {
                // If the list becomes empty, also update tail
                tail = null;
            } else {
                // Set the new head's previous reference to null
                head.setPrev(null);
            }
            
            return element;
        }
	}
	// Retrieves and removes the last element of this list, or returns null if this list
	// is empty.
	E pollLast() {
		if (tail == null) {
            // The list is empty, return null
            return null;
        } else {
            // Retrieve and remove the element at the tail of the list
            E element = tail.element();
            tail = tail.prev();

            if (tail == null) {
                // If the list becomes empty, also update head
                head = null;
            } else {
                // Set the new tail's next reference to null
                tail.setNext(null);
            }

            return element;
        }
	}
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			private URNode<E> current = head;
			private URNode<E> lastReturned = null;

			@Override
			public boolean hasNext() {
				return current != null;
			}

			@Override
			public E next() {
				if (!hasNext()) {
					throw new java.util.NoSuchElementException();
				}
				lastReturned = current;
				current = current.next();
				return lastReturned.element();
			}

			@Override
			public void remove() {
				if (lastReturned == null) {
					throw new IllegalStateException("remove() called before next()");
				}
				URLinkedList.this.remove(lastReturned.element());
				lastReturned = null;
			}
		};
	}
	public void removeIf(Predicate<? super E> filter) {
		Iterator<E> iterator = iterator();
		while (iterator.hasNext()) {
			E element = iterator.next();
			if (filter.test(element)) {
				iterator.remove();
			}
		}
	}
	
}



class URNode<E> { // Doubly linked list node
	private E e; // Value for this node
	private URNode<E> n; // Reference to next node in list
	private URNode<E> p; // Reference to previous node
	// Constructors
	URNode(E it, URNode<E> inp, URNode<E> inn) {
		e = it; p = inp; n = inn;
	}
	URNode(URNode<E> inp, URNode<E> inn) { 
		p = inp; n = inn;
	}
	// Get and set methods for the data members
	public E element() { 
		return e; 
	} // Return the value
	public E setElement(E it) {
		return e = it; 
	} // Set element value
	public URNode<E> next() {
		return n; 
	} // Return next link
	public URNode<E> setNext(URNode<E> nextval) { 
		return n = nextval; 
	} // Set next link
	public URNode<E> prev() {
		return p; 
	} // Return prev link
	public URNode<E> setPrev(URNode<E> prevval) {
		return p = prevval;
	} // Set prev link
}