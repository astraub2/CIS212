
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

//I used elements of this
//example in my project
//http://cs.lmu.edu/~ray/notes/javanetexamples/
public class PrimesServer {

    
    public static void main(String[] args) throws Exception {
        System.out.println("The primefinder server is running.");
        int clientNumber = 0;
        
        ServerSocket listener = new ServerSocket(9898);
        try {
            while (true) {
                new Capitalizer(listener.accept(), clientNumber++).start();
            }
        } finally {
            listener.close();
        }
    }

    private static class Capitalizer extends Thread {
        private Socket socket;
        private int clientNumber;
        private ArrayList<Integer> primes=new ArrayList<Integer>();
        private ArrayList<Integer> numbers=new ArrayList<Integer>();
        

        public Capitalizer(Socket socket, int clientNumber) {
            this.socket = socket;
            this.clientNumber = clientNumber;
            log("New connection with client# " + clientNumber + " at " + socket);
        }

        
        public void run() {
        	System.out.println("running");
            try {

            	ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                ArrayList<Integer> clientList = (ArrayList<Integer>) in.readObject();
                
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                while (true) {
                	
                    for( int i=0; i<clientList.size(); i++){
                    if(clientList.get(i)>0)
                    	numbers.add(clientList.get(i));
                    if (isPrime(clientList.get(i))) {
                        primes.add(clientList.get(i));
                    }
                    if (clientList.get(i).equals(-1)) {
                    	out.println("Primes: "+primes+" All numbers:  "+numbers+"    Press enter to close");
                    	
                
                    }
                    
                }
                }
    
            } catch (IOException e) {
                log("Error handling client# " + clientNumber + ": " + e);
            } catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    log("Couldn't close a socket, what's going on?");
                }
                log("Connection with client# " + clientNumber + " closed");
            }
        }

        
        private void log(String message) {
            System.out.println(message);
        }
        public boolean isPrime(int n) {
        	if(n<0)
        		return false;
            if(n > 2 && (n & 1) == 0)
               return false;
     
            for(int i = 3; i * i <= n; i += 2)
                if (n % i == 0) 
                    return false;
            return true;
        }
    }
}