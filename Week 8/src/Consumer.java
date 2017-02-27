
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;



public class Consumer implements Runnable{
	int consumer;
	private LinkedBlockingQueue<String> sharedlocation;
	public static boolean running=true;

	public Consumer(LinkedBlockingQueue<String> sharedlocation, int consumer) {
		this.consumer=consumer;
		this.sharedlocation=sharedlocation;
	}

	@Override
	public void run() {
		String current = "";
		String max = "";
		int count=0;
		int interval=0;
		//the loop below runs until producer is finished
		while(running){
			try {
				current=sharedlocation.poll(10, TimeUnit.MILLISECONDS);
				running=Producer.running;
				if(current!=null){
				long sleepDelay = (long) (10* Math.random());
				Thread.sleep(sleepDelay);
				if (current.compareTo(max)>0){				
					max=current;
					
					}
				count++;
				interval++;
				if(interval==1000){
					System.out.println("Consumer "+consumer+" Consumed: "+ count);
					
					interval=0;
					}
			
				
					}
			
			} catch (InterruptedException ex) {
				System.out.println("Consumer InterruptedException!!!");
			}
			
	}
		//the loop below runs until producer is empty
		while(sharedlocation.isEmpty()==false){
			try{
		
			current=sharedlocation.poll();
			long sleepDelay = (long) (10* Math.random());
			Thread.sleep(sleepDelay);
			
			
			if (current.compareTo(max)>0){				
				max=current;
				
				}
			count++;
			interval++;
			if(interval==1000){
				System.out.println("Consumer "+consumer+" Consumed: "+ count);
				
				interval=0;
			}
			}catch (InterruptedException ex) {
				System.out.println("Consumer InterruptedException!!!");
				}
		}
		
	
		
		System.out.println("Consumer "+consumer+" finished! Consumed: "+ count);
		System.out.println("Consumer "+consumer+" max string: "+ max);
		
	}

}
