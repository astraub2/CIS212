
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
//I used elements of this
//example in my project
//http://cs.lmu.edu/~ray/notes/javanetexamples/
public class PrimesClient {

    private BufferedReader in;
    private ObjectOutputStream toserver;
    private ObjectInputStream fromserver;
    private JFrame frame = new JFrame("Prime Finder");
    private JTextField dataField = new JTextField(40);
    private JTextArea messageArea = new JTextArea(30, 60);
    private ArrayList<Integer> numbers=new ArrayList<Integer>();

    public PrimesClient() throws IOException, Throwable {
    	// Layout GUI
        messageArea.setEditable(false);
        frame.getContentPane().add(dataField, "North");
        frame.getContentPane().add(new JScrollPane(messageArea), "Center");
        messageArea.append("Hello, welcome to the prime finder!" + "\n");
        messageArea.append("Enter a -1 to display results" + "\n");
        messageArea.append("Enter a blank line to close at any time"+ "\n");

        // Add Listeners
        dataField.addActionListener(new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {
            	
            	int number = Integer.parseInt((dataField.getText()));
            	
            	if(number==-1){
            		numbers.add(number);
            		messageArea.append("Cliet Sent: "+numbers.toString());
            		try {
            			toserver.writeObject((ArrayList<Integer>)numbers);
						
					} catch (IOException e1) {
						
						e1.printStackTrace();
					}
            		
            	}
            	
            		
            	else
                numbers.add(number);
            	messageArea.append(number + "\n");
            	dataField.setText(null);
                
                
                
            }
        });
    }

    
    public void connectToServer() throws IOException {

        
        String serverAddress = null;
        Socket socket = new Socket(serverAddress, 9898);
        
        ObjectOutputStream toserver = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream fromserver=new ObjectInputStream(socket.getInputStream());
               
        ((Flushable) toserver).flush();
        ((Flushable) fromserver).flush();
        

        for (int i = 0; i <=3; i++) {
            messageArea.append(in.readLine() + "\n");
        }
    }

    
    public static void main(String[] args) throws Throwable {
    	
        PrimesClient client = new PrimesClient();
        client.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        client.frame.pack();
        client.frame.setVisible(true);
        //client.connectToServer();
        
    }
}