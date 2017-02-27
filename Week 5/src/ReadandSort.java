import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ReadandSort {
	protected final static ArrayList <NamesandNumbers> namesandnumbers = Builder("phonebook.txt");

	public static void main(String[] args) {
		
		GUI();
		
		}
	private static void GUI(){
		JFrame app= new JFrame("Assignment 5");
		JLabel label1 = new JLabel();
		JLabel label2 = new JLabel();
		JPanel leftpanel = new JPanel();
	   	leftpanel.setLayout( new GridLayout(2,0) );
	   	JPanel rightpanel = new JPanel();
	   	rightpanel.setLayout( new GridLayout(2,0) );
	   	app.getContentPane().add(leftpanel, BorderLayout.EAST);
	   	app.getContentPane().add(rightpanel, BorderLayout.WEST);
	   	leftpanel.add(label1);
	   	leftpanel.add(label2);
		
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(250,200);
		app.setVisible(true);
		JButton ssbutton=new JButton("Select Sort");
		
	   	 ssbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				long startTime1 = System.nanoTime();
				
				ArrayList <NamesandNumbers> selectsorted=SelectionSort(namesandnumbers);
				if( (Alphabetic(selectsorted)))
					label1.setText(printElapsedTimeMs(startTime1));
				else
					label1.setText("Error");
				}
			} 	
	);
	   	 
	   	 
		 rightpanel.add(ssbutton);
		 JButton msbutton=new JButton("Merge Sort");
	   	 msbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				long startTime2 = System.nanoTime();
				
				MergeSort merger= new MergeSort(namesandnumbers);
				merger.sort();
			if(Alphabetic(merger.values()))
				label2.setText(printElapsedTimeMs(startTime2));
			else
				label2.setText("Error");
				
				
			} }	
	);
	   	 rightpanel.add(msbutton);
		
	}
	private static String printElapsedTimeMs(long startTimeNs) {
		double elapsedTimeMs = (System.nanoTime() - startTimeNs) / 1000000.0;
		return (elapsedTimeMs+"     ");
	}
	
	
	public static Boolean Alphabetic(ArrayList <NamesandNumbers> list){
		for (int i=0; i<list.size()-1; i++){
			if (((NamesandNumbers) list.get(i)).name().compareToIgnoreCase((((NamesandNumbers) list.get(i+1)).name()))>0)
				return false;
		}
		return true;
	
			
		}
		
	
	
	public static ArrayList <NamesandNumbers> Builder(String input){
		ArrayList <NamesandNumbers> namesandnumbers=new ArrayList<NamesandNumbers>();
		try {
			File file = new File(input);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			
			String phonenumber;
			String name;
			while ((line = bufferedReader.readLine()) != null) {
				
				stringBuffer.append(line);
				
				phonenumber=stringBuffer.substring(0,8);
				name=stringBuffer.substring(10, (line.length()));
				stringBuffer = new StringBuffer();
				NamesandNumbers selection= new NamesandNumbers(phonenumber, name);
				namesandnumbers.add(selection);
				
			}
			fileReader.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
		return namesandnumbers;
	}
		
		
	
	
	
	
	
	
	
	
	public static ArrayList<NamesandNumbers> SelectionSort(ArrayList <NamesandNumbers> namesandNumbers){
		ArrayList <NamesandNumbers> out=new ArrayList<NamesandNumbers>();
		out=(ArrayList<NamesandNumbers>) namesandNumbers.clone();
		
		     for (int i=0; i<out.size();i++){
		    	Object min=out.get(i);
		    	String minname=((NamesandNumbers) min).name().toLowerCase();
		    	
		    	for (int j = i + 1; j < out.size(); j++) {
		    		Object person=out.get(j);
		    		String newname=((NamesandNumbers) person).name().toLowerCase();
		    		int compare = minname.compareTo(newname);
		    		 	
		            if (compare > 0) {
		            	min=out.get(j);
				    	minname=((NamesandNumbers) min).name().toLowerCase();
		            }

		     
		            if (min != out.get(i)) {
		            	
		                final Object temp =out.get(i);
		                out.set(i, (NamesandNumbers) person);
		                out.set(j,  (NamesandNumbers) temp);
		                	               
		                
		            } 
		    	}
		     }
			return out;
	}


}
		
		
		
		
	
	
		




