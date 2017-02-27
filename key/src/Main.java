import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {	
		System.out.println("Hello world!");
		
		MainFrame frame = new MainFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		frame.setVisible(true);	
	}
}