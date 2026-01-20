package priorityqueue;

import java.util.Comparator;

import positionlist.LinkedPositionalList;
import positionlist.Position;

public class SortedPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {

	private LinkedPositionalList<Entry<K, V>> list = new LinkedPositionalList<>();

	public SortedPriorityQueue() {
		super();
	}

	public SortedPriorityQueue(Comparator<K> comp) {
		super(comp);
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public Entry<K, V> insert(K k, V v) throws IllegalArgumentException {
		Entry<K, V> newest = new PQEntry<>(k, v);
		Position<Entry<K, V>> walk = list.last();

		while (walk != null && compare(newest, walk.getElement()) < 0) {
			walk = list.before(walk);
		}

		if (walk == null) {
			list.addFirst(newest);
		} else {
			list.addAfter(walk, newest);
		}

		return newest;
	}

	@Override
	public Entry<K, V> min() {
		if (!isEmpty()) {
			return null;
		}
		return list.first().getElement();
	}

	@Override
	public Entry<K, V> removeMin() {
		if (!isEmpty()) {
			return null;
		}
		return list.remove(list.first());
	}

}
