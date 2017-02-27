
	import java.awt.BorderLayout;
	import java.awt.Color;
	import java.awt.GridLayout;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	import javax.swing.JButton;
	import javax.swing.JColorChooser;
	import javax.swing.JFrame;
	import javax.swing.JPanel;

	public class MainFrame extends JFrame {
		public static final Color DEFAULT_COLOR = Color.BLUE;
		
		private final PaintPanel _paintPanel;
		private final JButton _colorButton;
		private final JButton _squareButton;
		private final JButton _circleButton;
		
		public MainFrame() {		
			super("LET'S PAINT!!!");
			setLayout(new BorderLayout());
			
			_paintPanel = new PaintPanel(); 
			add(_paintPanel, BorderLayout.CENTER);
			
			final String colorChooserTitle = "Choose a color for all points!";
			
			_colorButton = new JButton(colorChooserTitle);
			_colorButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Color color = JColorChooser.showDialog(MainFrame.this,
							colorChooserTitle, DEFAULT_COLOR);
					
					// JColorChooser will return null if the user cancels.
					if (color != null) {
						_paintPanel.setCurrentColor(color);
					}				
				}		
			});
			add(_colorButton, BorderLayout.NORTH);
			
			JPanel buttonPanel = new JPanel();
			buttonPanel.setLayout(new GridLayout(1, 2));
			
			_squareButton = new JButton("Square");
			_squareButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					_paintPanel.setCurrentShape(ShapePoint.SQUARE_TYPE);
				}		
			});
			buttonPanel.add(_squareButton);

			_circleButton = new JButton("Circle");
			_circleButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					_paintPanel.setCurrentShape(ShapePoint.CIRCLE_TYPE);
				}		
			});
			buttonPanel.add(_circleButton);

			add(buttonPanel, BorderLayout.SOUTH);
		}
	}

