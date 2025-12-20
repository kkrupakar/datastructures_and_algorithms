package positionlist;

public class FavoritesListMTF<E> extends FavoritesList<E>{

	protected void moveUp(Position<Item<E>> p) {
		if(p != null) {
			list.addFirst(list.remove(p));
		}
	}
	
	@SuppressWarnings("unchecked")
	public Iterable<E> getFavorites(int k) throws IllegalArgumentException{
		if( k < 0 || k > size()) {
			throw new IllegalArgumentException("Invalid k");
		}
		
		PositionalList<Item<E>> tempList = new LinkedPositionalList<>();
		for(Item<E> item:list) {
			tempList.addLast(item);
		}
		
		PositionalList<Item<E>> result = new LinkedPositionalList<>();
		
		for(int j=0; j < k ; j++) {
			Position<Item<E>> highPos = tempList.first();
			Position<Item<E>> walk = tempList.after(highPos);
			while(walk != null) {
				if(count(walk) > count(highPos)) {
					highPos = walk;
				}
				walk = tempList.after(walk);
			}
			result.addLast((Item<E>) value(highPos));
			tempList.remove(highPos);
		}
		
		return (Iterable<E>) result;
		
	}
}
