package positionlist;

public class LinkedPositionalList<E> implements PositionList<E> {

	private Node<E> header;
	private Node<E> trailer;
	private int size = 0;

	public LinkedPositionalList() {
		header = new Node<E>(null, null, null);
		trailer = new Node<E>(null, header, null);
		header.next = trailer;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	private Node<E> validate(Position<E> p) throws IllegalArgumentException {
		if (!(p instanceof Node)) {
			throw new IllegalArgumentException("Invalid p");
		}
		Node<E> node = (Node<E>) p;

		if (node.getNext() == null) {
			throw new IllegalArgumentException("p is no longer in the list");
		}
		return node;
	}

	private Position<E> position(Node<E> node) {
		if (node == header || node == trailer) {
			return null;
		}
		return node;
	}

	@Override
	public Position<E> first() {
		return position(header.getNext());
	}

	@Override
	public Position<E> last() {
		return position(trailer.getPrev());
	}

	@Override
	public Position<E> before(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return position(node.getPrev());
	}

	@Override
	public Position<E> after(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return position(node.getNext());
	}

	private Position<E> addBetween(E e, Node<E> pred, Node<E> succ) {
		Node<E> newest = new Node<>(e, pred, succ);
		pred.setNext(newest);
		succ.setPrev(newest);
		size++;
		return newest;
	}

	@Override
	public Position<E> addFirst(E e) {
		return addBetween(e, header, header.getNext());
	}

	@Override
	public Position<E> addLast(E e) {
		return addBetween(e, trailer, trailer.getPrev());
	}

	@Override
	public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return addBetween(e, node.getPrev(), node);
	}

	@Override
	public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return addBetween(e, node, node.getNext());
	}

	@Override
	public E set(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> node = validate(p);
		E answer = node.getElement();
		node.setElement(e);
		return answer;
	}

	@Override
	public E remove(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		Node<E> predecessor = node.getPrev();
		Node<E> successor = node.getNext();
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		size--;
		E answer = node.getElement();
		node.setNext(null);
		node.setPrev(null);
		return answer;
	}

	@SuppressWarnings("hiding")
	private class Node<E> implements Position<E> {

		private E element;
		private Node<E> next;
		private Node<E> prev;

		public Node(E e, Node<E> p, Node<E> n) {
			this.element = e;
			this.next = n;
			this.prev = p;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> next) {
			this.next = next;
		}

		public Node<E> getPrev() {
			return prev;
		}

		public void setPrev(Node<E> prev) {
			this.prev = prev;
		}

		public void setElement(E element) {
			this.element = element;
		}

		@Override
		public E getElement() throws IllegalStateException {
			if (next == null) {
				throw new IllegalStateException("Position no longer valid");
			}
			return element;
		}

	}

}
