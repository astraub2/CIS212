
public class Sphere extends Circle{
	
	private double radius;
	public Sphere(double intradius){
		super(intradius);
		radius=intradius;
	}
	public double getArea(){
		
		return(4*Math.PI*radius*radius);
	}
}
