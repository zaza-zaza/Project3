
public class URStack<E> extends URLinkedList<E>{
	
	private URLinkedList<E> top;	
	//constructor
	
	public static void main(String[] args) {
		URStack<Double> s = new URStack<>();
		s.push(1.0);
		printLL(s);

	}
	
	public void push(E o) {
		addFirst(o);
	}
}

