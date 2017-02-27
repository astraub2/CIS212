import java.awt.Graphics;
import java.awt.Point;

public class ShapePoint {
	public static final int CIRCLE_TYPE = 0;
	public static final int SQUARE_TYPE = 1;
	
	private static final int CIRCLE_SIZE = 15;
	private static final int SQUARE_SIZE = 10;

	private final Point _point;
	private final int _shapeType;
	
	public ShapePoint(Point point, int shapeType) {
		_point = point;
		_shapeType = shapeType;
	}
	
	public Point getPoint() {
		return _point;
	}
	
	public int getShape() {
		return _shapeType;
	}
	
	public void paint(Graphics g) {
		if (_shapeType == CIRCLE_TYPE) {
			g.fillOval(_point.x, _point.y, CIRCLE_SIZE, CIRCLE_SIZE);
		} else if (_shapeType == SQUARE_TYPE) {
			g.fillRect(_point.x, _point.y, SQUARE_SIZE, SQUARE_SIZE);
		}
	}
}