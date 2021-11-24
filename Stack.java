public class Stack<T> implements GenericStack<T> {
    private Node<T> top = null;

    public boolean isEmpty() { return top == null; }

    public void push (T t) {
	Node<T> n = new Node<T>(t, top);
	top = n;
    }

    public T pop () {
	if (top == null)
	    return null;

	Node<T> n = top;
	top = n.getNext();
	return n.getValue();
    }

    public T peek () {
	if (top == null)
	    return null;

	return top.getValue();
    }

    public String toString () {
	String str = "[";
	Node<T> n = top;

	while (n != null) {
	    str += n.getValue().toString();
	    if (n.hasNext()) {
		str += ", ";
	    }
	    n = n.getNext();
	}

	str += "]";

	return str;
    }
}

class Node<T> {
    private T value;
    private Node<T> next = null;

    public Node (T value) {
	this.value = value;
    }

    public Node (T value, Node<T> next) {
	this.value = value;
	this.next = next;
    }

    public T getValue () { return value; }
    public Node<T> getNext () { return next; }
    public boolean hasNext () { return next != null; }
    public void setNext (Node<T> next) { this.next = next; }
}
