package priorityqueue;

import java.util.Comparator;

import positionlist.LinkedPositionalList;
import positionlist.Position;

public class UnsortedPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {

	private LinkedPositionalList<Entry<K, V>> list = new LinkedPositionalList<>();

	public UnsortedPriorityQueue() {
		super();
	};

	public UnsortedPriorityQueue(Comparator<K> comp) {
		super(comp);
	}

	private Position<Entry<K, V>> findMin() {
		Position<Entry<K, V>> small = list.first();
		for (Position<Entry<K, V>> walk : list.positions()) {
			if (compare(walk.getElement(), small.getElement()) < 0) {
				small = walk;
			}
		}
		return small;
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public Entry<K, V> insert(K k, V v) throws IllegalArgumentException {
		checkKey(k);
		Entry<K, V> newest = new PQEntry<>(k, v);
		list.addLast(newest);
		return newest;
	}

	@Override
	public Entry<K, V> min() {
		if(!isEmpty()) { return null; }
		return findMin().getElement();
	}

	@Override
	public Entry<K, V> removeMin() {
		if(!isEmpty()) { return null; }
		return list.remove(findMin());
	}

}
