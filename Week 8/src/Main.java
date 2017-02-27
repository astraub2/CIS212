import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
public class Main {
	public static void main(String[] args){
		final int QUEUE_SIZE = 100;
		
		LinkedBlockingQueue<String> queue= new LinkedBlockingQueue<String>(QUEUE_SIZE);
		
		
		
		Producer producer = new Producer(queue);
		Consumer consumer1 = new Consumer(queue, 1);
		Consumer consumer2 = new Consumer(queue, 2);
		Consumer consumer3 = new Consumer(queue, 3);
		
		
		ExecutorService executor = Executors.newCachedThreadPool();
		executor.execute(producer);
		executor.execute(consumer1);
		executor.execute(consumer2);
		executor.execute(consumer3);
		executor.shutdown();
		
		
	}

}
