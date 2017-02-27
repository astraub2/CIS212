
	import java.awt.Color;
	import java.awt.Graphics;
	import java.awt.Point;
	import java.awt.event.MouseAdapter;
	import java.awt.event.MouseEvent;
	import java.util.ArrayList;

	import javax.swing.JPanel;

	public class PaintPanel extends JPanel {	
		private final ArrayList<ShapePoint> _points;
		
		private Color _currentColor;
		private int _currentShape;
		
		public PaintPanel() {
			_points = new ArrayList<>();
			_currentColor = MainFrame.DEFAULT_COLOR;
			_currentShape = ShapePoint.SQUARE_TYPE;
			
			addMouseMotionListener(new MouseAdapter() {
				@Override
				public void mouseDragged(MouseEvent ev) {
					_points.add(new ShapePoint(ev.getPoint(), _currentShape));
					repaint();
				}
			});		
		}
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.setColor(_currentColor);
			
			for (ShapePoint p : _points) {
				p.paint(g);
			}
		}
		
		public void setCurrentColor(Color currentColor) {
			_currentColor = currentColor;
			
			// In order to update the color for all points when this is called,
			// need to call repaint().
			
		}
		
		public void setCurrentShape(int currentShape) {
			_currentShape = currentShape;
		}
	}


