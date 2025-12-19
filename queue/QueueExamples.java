package queue;

public class QueueExamples {
	
	public static <E> CircularQueue<E> buildQueue(E a[]){
		CircularQueue<E> queue = new CircularQueue<>();
		for(E e: a) {
			queue.enqueue(e);
		}
		return queue;
	}

	public static <E> E Josephus(CircularQueue<E> queue,int k) {
		if(queue.isEmpty()) {
			return null;
		}
		while(queue.size() > 1) {
			for(int i = 0; i < k - 1; i++) {
				queue.rotate();
			}
			E e = queue.dequeue();
			System.out.println("   "+e + "is out!");
		}
		return queue.dequeue();
	}
	
	
}
