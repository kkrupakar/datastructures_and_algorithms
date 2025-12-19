package SinglyLinkedList;

public class SinglyLinkedList<E> implements Cloneable{

	private Node<E> head;
	private Node<E> tail;
	private int size = 0;

	public SinglyLinkedList() {
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E first() {
		if (isEmpty()) {
			return null;
		}
		return head.getElement();
	}

	public E last() {
		if (isEmpty()) {
			return null;
		}
		return tail.getElement();
	}

	public void addFirst(E e) {
		Node<E> newest = new Node<E>(e, null);
		if (isEmpty()) {
			head = newest;
			tail = head;
		}else {
			newest.next = head;
			head = newest;
		}
		size++;
	}

	public void addLast(E e) {

		Node<E> newest = new Node<E>(e, null);
		if (isEmpty()) {
			head = newest;
		} else {
			tail.next = newest;
		}
		tail = newest;
		size++;

	}

	public E removeFirst() {

		if (isEmpty()) {
			return null;
		}

		E answer = head.getElement();
		Node<E> next = head.getNext();
		head = next;
		size--;

		if (isEmpty()) {
			tail = null;
		}
		return answer;

	}
	
	@SuppressWarnings("unchecked")
	public SinglyLinkedList<E> clone() throws CloneNotSupportedException{
		
		SinglyLinkedList<E> other = (SinglyLinkedList<E>) super.clone();
		if(size > 0) {
			other.head = new Node<>(head.getElement(),null);
			Node<E> walk = head.getNext();
			Node<E> otherTail = other.head;
			while(walk != null) {
				Node<E> newest = new Node<>(walk.getElement(),null);
				otherTail.setNext(newest);
				otherTail = newest;
				walk = walk.getNext();
			}
		}
		return other;
	}

	private static class Node<E> {

		private E element;
		private Node<E> next;

		public Node(E e, Node<E> next) {
			element = e;
			this.next = next;
		}

		public E getElement() {
			return element;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> n) {
			next = n;
		}
	}
}
