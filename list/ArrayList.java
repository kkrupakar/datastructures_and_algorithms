package list;

import java.util.NoSuchElementException;

import Iterator.ExIterable;
import Iterator.ExIterator;

public class ArrayList<E> implements List<E>, ExIterable<E> {

	private static final int CAPACITY = 16;
	private E[] data;
	private int size = 0;

	public ArrayList() {
		this(CAPACITY);
	}

	@SuppressWarnings("unchecked")
	public ArrayList(int capacity) {
		data = (E[]) new Object[capacity];
	}

	@SuppressWarnings("unchecked")
	protected void resize(int capacity) {
		E[] temp = (E[]) new Object[capacity];
		for(int i=0; i < size ; i++) {
			temp[i] = data[i];
		}
		data = temp;
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	protected void checkIndex(int i, int n) {
		if (i < 0 || i > n) {
			throw new IndexOutOfBoundsException("Illegal Index : " + i);
		}
	}

	@Override
	public E get(int i) throws IndexOutOfBoundsException {
		checkIndex(i, size);
		return data[i];
	}

	@Override
	public E set(int i, E e) throws IndexOutOfBoundsException {
		checkIndex(i, size);
		E temp = data[i];
		data[i] = e;
		return temp;
	}

	@Override
	public void add(int i, E e) throws IndexOutOfBoundsException {

		checkIndex(i, size);
		if (size == data.length) {
			resize(2*size);
		}

		for (int k = size - 1; k > 0; k--) {
			data[k + 1] = data[k];
		}
		data[i] = e;
		size++;
	}

	@Override
	public E remove(int i) throws IndexOutOfBoundsException {

		checkIndex(i, size);
		E temp = data[i];
		for (int k = i; k < size - 1; k++) {
			data[k] = data[k + 1];
		}
		data[size - 1] = null;
		size--;
		return temp;
	}
	

	@Override
	public ExIterator<E> iterator() {		
		return new ArrayIterator<>();
	}
		
	@SuppressWarnings("unchecked")
	private class ArrayIterator<E> implements ExIterator<E>{
		
		private int j = 0;

		@Override
		public boolean hasNext() {			
			return j < size;
		}
		
		@Override
		public E next() {
			if(j == size) throw new NoSuchElementException("No next element");
			return (E) data[j++];
		}
		
	}


}
