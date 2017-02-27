import java.util.ArrayList;
import java.util.Random;

public class Main implements Measurable{
	
			

	public static void main(String[] args){
		
		double randomValue = nextDouble();
		Random r=new Random();
		int selector=r.nextInt(4);
		
		int circlecount=0;
		int spherecount=0;
		int rectanglecount=0;
		int boxcount=0;
		
		Measurable[] measurblelist=measurable();
		
		ArrayList<Measurable> mylist=new ArrayList();
		for (int shape=0; shape<1000; shape++){
			mylist.add(measurblelist[selector]);
			if (selector==0)
				rectanglecount+=1;
			if(selector==1)
				boxcount+=1;
			if(selector==2)
				circlecount+=1;
			if(selector==3)
				spherecount+=1;
			selector=r.nextInt(4);
			measurblelist=measurable();
				
					
			
		}
		double sum=calculatesum(mylist);
		System.out.println("Sum: " +sum);
		
		System.out.print("Boxes: " +boxcount);
		System.out.print("  Rectangles: "+rectanglecount);
		System.out.print(" Circles: " +circlecount);
		System.out.print("  Spheres: "+spherecount);
		
		}
	private static Measurable[] measurable(){
		double randomValue = nextDouble();
		Box box=new Box(randomValue,randomValue,randomValue);
		Rectangle rectangle=new Rectangle(randomValue,randomValue);
		Circle circle=new Circle(randomValue);
		Sphere sphere=new Sphere(randomValue);
	
		Measurable[] measurable= new Measurable[4];
		measurable[0]=rectangle;
		measurable[1]=box;
		measurable[2]=circle;
		measurable[3]=sphere;
		return measurable;
	}
	

	private static double nextDouble(){
		Random r = new Random();
		double randomValue = r.nextDouble();
		return randomValue;
		
		
	}
	private static double calculatesum(ArrayList mylist){
		
		double sum =0;
				for (int shape=0; shape<mylist.size(); shape++)
				{
					Object x= mylist.get(shape);
					sum+= ((Measurable) x).getArea();
				}
		return sum;
	}
}
		
		
				
					
	
	
	
	
	
