import javax.swing.JPanel;
import java.awt.Point;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

public class PaintPanel extends JPanel
{
	private final ArrayList<thePoint> points=new ArrayList<>();
	public PaintPanel(){
		addMouseMotionListener(
			new MouseMotionAdapter()
			{
				@Override
				public void mouseDragged(MouseEvent event)
				{
					points.add(new thePoint(event.getPoint(), Painter.color(), Painter.Size()));
					repaint();
				}
				
				}
			);		
				
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		for( thePoint point:points)
			point.paint(g);
	}
	
	public void clear(){
		points.clear();
		repaint();
		
	}
		
	
	
	}
		
		
			

	
