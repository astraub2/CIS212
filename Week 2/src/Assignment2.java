import java.util.ArrayList;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class Assignment2 {

	public static void main( String[] args ){
		Scanner input = new Scanner(System.in);  // Reading from System.in
		
		
		// retrieve Length Value
		//Caching Exceptions
		boolean valid = false;
		int length=0;
		while (!valid) {
		    try {
		    	System.out.println("Enter Array Length:");
		    	length=input.nextInt();
		        valid = true;
		    } catch (InputMismatchException e) {
		    	System.out.println("Entry Must Be a Possitive Number.");
		    	input.next();
		    	}
		    }
		
		
	
		//Retrieve Density Value
		//Caching Exceptions
		double density=0;
		boolean valid1 = false;
		while (!valid1) {
		    try {
		    	System.out.println("Enter Density:");
		    	density=input.nextDouble();
		        valid1 = true;
		    } catch (InputMismatchException e) {
		    	System.out.println("Density must be in the range 0.0 to 1.0");
		    	input.next();
		    	}
		    }
		
		
		//Extra precausin to cathch bad Density inputs
		while (density>=1 || density<=0){
			System.out.println("Density must be in the range 0.0 to 1.0");
			System.out.println("Enter Density:");
			density=input.nextDouble();
		}
		
		
		//Used to measure the clock
		long startTime = System.nanoTime();
		
		
		int[] d=densearray(length, density);
		System.out.println("create dense length:" +d.length+" time: "+ ((System.nanoTime()-startTime)/1000)+" milliseconds");
		
		ArrayList dtos=densetosparce(d);
		System.out.println("convert to sparse length:"+ dtos.size()+" time: "+ ((System.nanoTime()-startTime)/1000)+" milliseconds");
		
		ArrayList s=sparsearray(length, density);
		System.out.println("create sparce length: "+s.size()+" time: "+ ((System.nanoTime()-startTime)/1000)+" milliseconds");
		//Needed 3 values, the length of the array, and it's max value and location
		int[] stod = sparsetodense(s, density);
		int stodlen=stod[0];
		int stodmax=stod[1];
		int stodloc=stod[2];
				
		System.out.println("convert to dense length:"+stodlen+" time: "+ ((System.nanoTime()-startTime)/1000)+" milliseconds");
		int[] maxdense=maxdense(d);
		//Needed 2 values, one for the max value and another for it's location
		int num=maxdense[0];
		int lon=maxdense[1];
		
		System.out.println("find max (dense): "+num+ " at "+lon+" time: "+ ((System.nanoTime()-startTime)/1000)+" milliseconds");
		System.out.println("find max (sparce): "+stodloc+ " at "+stodmax+" time: "+ ((System.nanoTime()-startTime)/1000)+" milliseconds");
		
		
	}
	
		
	public static int[] densearray(int length, double density){
		int number = 0;
		Random r = new Random();
		int randomNumber=r.nextInt(1000001)+1;
	
		double randomValue = r.nextDouble();
		int[] array=new int[length];
		for (int i=0; i<length; i++ )
		{
			if (randomValue<density)
				number=randomNumber;
			
		
			array[i]=number;
			randomValue = r.nextDouble();
			randomNumber=r.nextInt(1000001)+1;
			
		}	
		return array;
		
		}
	public static ArrayList sparsearray(int length, double density){
		
		ArrayList array=new ArrayList();
		int[] var= new int[2];
	
		int number = 0;
		Random r = new Random();
		int randomNumber=r.nextInt(1000001)+1;

		double randomValue = r.nextDouble();
	
		for (int i=0; i<length; i++ )
		{
			if (randomValue<density)
				{var[0]=i;
				var[1]=randomNumber;
				array.add(Arrays.toString(var));
				}
			randomValue = r.nextDouble();
			randomNumber=r.nextInt(1000001)+1;
	
		}
		return array;
	
		}
	public static ArrayList densetosparce(int[] densearray){
		ArrayList array=new ArrayList();
		int[] var= new int[2];
		for (int i=0; i<densearray.length; i++ )
		{
			if (densearray[i]>0)
				{var[0]=i;
				var[1]=densearray[i];
				array.add(Arrays.toString(var));
				}
			}
		return array;
	
	
	}
	public static int[] sparsetodense(ArrayList sparcearray, double desity){
		int[] var= new int[sparcearray.size()*2];
		int number = 0;
		Random r = new Random();
		int randomNumber=r.nextInt(1000001)+1;
		double den = desity;

		double randomValue = r.nextDouble();
	
		for (int i=0; i<var.length; i++ )
		{
			if (randomValue<den)
				{
				var[i]=i;
				var[i+1]=randomNumber;
				
				}
			i=i+1;
		
			randomValue = r.nextDouble();
			randomNumber=r.nextInt(1000001)+1;
	
		}
		
		int max=0;
		int val=0;
		for(int i=0; i<var.length; i++)
		{
			if (var[i]>max)
				{max=var[i];
				val=var[i+1];
				}
			
			i=i+1;
			}
		
		
		int[] dense=new int[max+1];
		for(int j=0; j<=sparcearray.size()*2-1; j++)
		{	
			if (var[j+1]!=0)
				{
				dense[j]=var[j+1];
				
				
				}	
			j=j+1;
		}
		int[] output={dense.length, max, val};
		return output;
		
	}

		
	
	public static  int[] maxdense(int[] densearray){
		int max = 0;
		int loc=0;
				for(int i=0; i<densearray.length; i++)
				{
					if (densearray[i]>max)
						{max=densearray[i];
						loc=i;
						}
						
					
				}
		
		int[] answer={max, loc};
		return answer;
	}
}