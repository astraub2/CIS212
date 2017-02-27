
import java.util.UUID;

import java.util.concurrent.LinkedBlockingQueue;

public class Producer implements Runnable {
	private int numberofstrings=10000;
	private LinkedBlockingQueue<String> _sharedlocation;
	public static boolean running=true;
	
	public Producer(LinkedBlockingQueue<String> sharedlocation) {
		_sharedlocation=sharedlocation;
	}
	
	@Override
	public void run() {
		int count=0;
		int total=0;
		for (int i=0; i <numberofstrings; ++i) {
			try {
				UUID string=UUID.randomUUID();
				_sharedlocation.put(string.toString());
				count++;
				total++;
				if(count==1000){
					System.out.println("producer: "+total);
					count=0;
				}
					
			} catch (InterruptedException ex) {
				System.out.println("Producer InterruptedException!!!");
			}
		
		}
		System.out.println("producer finished! Produced: "+total);
		running=false;
		
	}
	
	

}
