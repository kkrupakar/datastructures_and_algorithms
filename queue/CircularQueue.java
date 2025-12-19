package queue;

import CircularlyLinkedList.CircularlyLinkedList;

public class CircularQueue<E> implements Queue<E> {

	CircularlyLinkedList<E> list = new CircularlyLinkedList<E>();

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public void enqueue(E e) {
		list.addFirst(e);
	}

	@Override
	public E first() {
		return list.first();
	}

	@Override
	public E dequeue() {
		return list.removeFirst();
	}
	
	public void rotate() {
		list.rotate();
	}

}
