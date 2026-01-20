package priorityqueue;

import java.util.Comparator;

public abstract class AbstractPriorityQueue<K, V> implements PriorityQueue<K, V> {

	private DefaultComparator<K> comp;

	public AbstractPriorityQueue() {
		this(new DefaultComparator<K>());
	}

	public AbstractPriorityQueue(Comparator<K> c) {
		comp = (DefaultComparator<K>) c;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	protected int compare(Entry<K, V> a, Entry<K, V> b) {
		return comp.compare(a.getKey(), b.getKey());
	}

	protected boolean checkKey(K key) throws IllegalArgumentException {
		try {
			return (comp.compare(key, key) == 0);
		} catch (ClassCastException ex) {
			throw new IllegalArgumentException("Incomplete Key");
		}
	}

	protected static class PQEntry<K, V> implements Entry<K, V> {

		private K k;
		private V v;

		public PQEntry(K k, V v) {
			this.k = k;
			this.v = v;
		}

		@Override
		public K getKey() {
			return k;
		}

		@Override
		public V getValue() {
			return v;
		}

		protected void setKey(K key) {
			k = key;
		}

		protected void setValue(V value) {
			v = value;
		}

	}

	static class DefaultComparator<E> implements Comparator<E> {

		@SuppressWarnings("unchecked")
		@Override
		public int compare(E a, E b) throws ClassCastException {
			return ((Comparable<E>) a).compareTo(b);
		}

	}
}
