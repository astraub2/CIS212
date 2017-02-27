
public class Circle implements Measurable{
	
	private double radius;
	public Circle(double intradius){
		radius=intradius;
		
		
	}
	public double getArea(){
		
		return (Math.PI*radius*radius);
	}


}
