import java.util.Scanner;

public class Assignment1 {

	public static void main( String[] args ){
		
		
	
		Scanner input = new Scanner(System.in);  // Reading from System.in
		System.out.println("Enter a positive integer (-1 to print, -2 to reset, -3 to quit):");
		int amount=input.nextInt();		
		int sum=0;
		while (amount!=-3)
		{
			if (amount==-1)
				System.out.println("Sum: " +sum);
			
			if (amount==-2)
				sum=0;
			else
				if (amount>0)
					sum+=amount;
			System.out.println("Enter a positive integer (-1 to print, -2 to reset, -3 to quit):");
			amount=input.nextInt();			
		}
		System.out.println("Sum: " +sum);
		input.close();
		
                
		}
        	
}


