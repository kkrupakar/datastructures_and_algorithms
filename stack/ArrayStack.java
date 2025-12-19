package stack;

public class ArrayStack<E> implements Stack<E> {

	public static final int CAPACITY = 1000;
	private E[] data;
	private int t = -1;

	public ArrayStack() {
		this(CAPACITY);
	}

	@SuppressWarnings("unchecked")
	public ArrayStack(int capacity) {
		data = (E[]) new Object[CAPACITY];
	}

	@Override
	public int size() {
		return t + 1;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public void push(E e) {
		if (size() == data.length) {
			throw new IllegalStateException("Stack is full");
		}
		data[++t] = e;
	}

	@Override
	public E pop() {
		if (isEmpty()) {
			return null;
		}
		E e = data[t];
		t--;
		return e;
	}

	@Override
	public E top() {
		if (isEmpty()) {
			return null;
		}
		return data[t];
	}

}
