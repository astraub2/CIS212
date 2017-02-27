import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

	public class thePoint {
		
		private final Point _point;
		private final int _size;
		private final Color _color;

		
		public thePoint(Point point, Color color, int size) {
			_point = point;
			_size=size;
			_color=color;
		}
			
		
		
		public Point getPoint() {
			return _point;
		}
		
		
		
		
		public void paint(Graphics g) {
			g.setColor(_color);
			g.fillOval(_point.x, _point.y, _size, _size);
			
			}
		
	}

