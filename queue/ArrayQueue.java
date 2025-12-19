package queue;

public class ArrayQueue<E> implements Queue<E>{

	private int size = 0;
	private int last = 0;
	private int first = 0;
	private E[] data;
	private static final int CAPACITY = 1000;
	
	public ArrayQueue() {
		this(CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayQueue(int capacity) {
		data = (E[]) new Object[capacity];
	}
	
	@Override
	public int size() { return size; }

	@Override
	public boolean isEmpty() { return size == 0; }

	@Override
	public void enqueue(E e) {
		if(size == data.length) {
			throw new IllegalStateException("Queue is full");
		}
		int avail = (first + last) % data.length;
		data[avail] = e;
		last = ( last + 1 ) % data.length;
		size++;
	}

	@Override
	public E first() {
		if(isEmpty()) {
			return null;
		}
		return data[first];
	}

	@Override
	public E dequeue() {
		if(isEmpty()) {
			return null;
		}
		E answer = data[first];
		data[first] = null;
		first = (first+1) % data.length;
		size--;
		return answer;
	}

}
