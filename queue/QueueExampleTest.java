package queue;

import java.util.stream.IntStream;

public class QueueExampleTest {

	public static void main(String[] args) {
		
		int[] vals = IntStream.rangeClosed(1, 100).toArray();
		
		Integer[] data = new Integer[vals.length];
		for(int i = 0; i < vals.length ; i++) {
			data[i] = vals[i];
		}
		
		System.out.println("Result : "+
			QueueExamples.Josephus(
					QueueExamples.buildQueue(data),
					7)
		);
	}

}
