
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
public class Painter {
	
	public static Color current_color = Color.BLACK;
	public static int size=5;
	public static void main(String[] args)
	{
		JFrame app= new JFrame("Paint Program");
		PaintPanel paintPanel=new PaintPanel();
		
		app.add(paintPanel, BorderLayout.CENTER);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(500,500);
		app.setVisible(true);
		
		JPanel leftpanel = new JPanel();
	    
	   	 leftpanel.setLayout( new GridLayout(4,0) );
	   	 
	   	 JButton buttonBlack=new JButton("Black");
	   	 buttonBlack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				current_color=Color.BLACK;
				
			} }	
	);
	   	 
	   	 
		 leftpanel.add(buttonBlack);
		 
		 JButton buttonGreen=new JButton("Green");
		 buttonGreen.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					current_color=Color.GREEN;
					
				} }	
		);
		 leftpanel.add(buttonGreen);
		 
		 JButton buttonYellow=new JButton("Yellow");
		 buttonYellow.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					current_color=Color.YELLOW;
					
				} }	
		);
		 leftpanel.add(buttonYellow);
		 
		 JButton buttonGrey=new JButton("Red");
		 buttonGrey.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					current_color=Color.RED;
					
				} }	
		);
		 leftpanel.add(buttonGrey);
	   	 
	   	 app.getContentPane().add(leftpanel, BorderLayout.WEST);
	   	 
	   	JPanel right = new JPanel();
	   	 right.setLayout( new GridLayout(4,0) );
		 JButton buttonSmall=new JButton("Small");
		 buttonSmall.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					size=5;
					
				} }	
		);
		 right.add(buttonSmall);
		 JButton buttonMedium=new JButton("Medium");
		 buttonMedium.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					size=10;
					
				} }	
		);
		 right.add(buttonMedium);
		 JButton buttonLarge=new JButton("Large");
		 buttonLarge.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					size=15;
					
				} }	
		);
		 right.add(buttonLarge);
		 JButton buttonClear=new JButton("Clear");
		 buttonClear.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					paintPanel.clear();
					
				} }	
		);
		 right.add(buttonClear);	
		 
		 app.getContentPane().add(right, BorderLayout.EAST);
	}
	public static Color color(){
		return current_color;	
	}
	public static int Size(){
		return size;
	}
	
}
		
	


