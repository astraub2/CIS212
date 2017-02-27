import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class simplePrimeServer {
	public static ObjectOutputStream outputToClient;
    public static ObjectInputStream inputFromClient;
    private static ArrayList<Integer> primes=new ArrayList<Integer>();
   
    private static Socket socket;
    
    public static void main(String[] args) throws IOException, ClassNotFoundException{
    	System.out.println("The primefinder server is running.");
    	
        try{
        	ServerSocket serverSocket = new ServerSocket(7000);
        	socket = serverSocket.accept();
    		
        	
        	
            outputToClient = new ObjectOutputStream(socket.getOutputStream());
            // Create an input stream from the socket
            inputFromClient = new ObjectInputStream(socket.getInputStream());
        	
        	
        while(true)  {
        	System.out.println("Recieving data");
        	ArrayList<Integer> input = (ArrayList<Integer>) inputFromClient.readObject();
        	for( int i=0; i<input.size(); i++){
        		System.out.println(input.get(i));
        		System.out.println("Processing");
               
                if (isPrime(input.get(i))) {
                    primes.add(input.get(i));
                }
        	}
                	System.out.println("Sending");
                	outputToClient.writeObject(primes);
                	socket.close();
            
                
             
    	
        	
        	
    	
    } } catch (IOException e) {
        log("Error handling client# "+ ": " + e);
    } catch (ClassNotFoundException e) {
		e.printStackTrace();
	} finally {
        try {
            socket.close();
        } catch (IOException e) {
            log("Couldn't close a socket, what's going on?");
        }
        log("Connection with client# " + " closed");
    }
}
    
    private static void log(String message) {
        System.out.println(message);
    }

    public static boolean isPrime(int n) {
    	if(n<0)
    		return false;
    	if(n > 2 && (n & 1) == 0)
    		return false;

    	for(int i = 3; i * i <= n; i += 2)
        	{if (n % i == 0) 
        		return false;
        	}
    	return true;
    }
}


