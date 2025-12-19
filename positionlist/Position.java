package positionlist;

public interface Position<E> {

	E getElement() throws IllegalStateException;
}
