
public class Rectangle implements Measurable{
	private double length;
	private double width;
	public Rectangle(double intlength, double intwidth){
		length=intlength;
		width=intwidth;
	
	}
	
	
	
	public double getArea() {
		
		return (length*width);
	}

	
}
