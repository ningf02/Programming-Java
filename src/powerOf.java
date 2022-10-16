import java.util.Scanner;

public class powerOf {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		
		System.out.print("Enter base: ");
		if(!userInput.hasNextInt())		
		{
			System.out.println("Error: You must enter an integer. ");
		}		
		else
		{
			int base = userInput.nextInt();
			System.out.print("Enter exponent: ");
			if(!userInput.hasNextInt())
			{
				System.out.println("Error: You must enter an integer. ");
			}
			else
			{
				int exponent = userInput.nextInt();
				if(exponent<0)
				{
					System.out.println("Error: Exponent must be positive. ");
				}
				else
				{
					int result = 1;
					for(int count = 1; count<=exponent; count++)
					{
						result*=base;
					}
					System.out.println(base + " to the power of " + exponent + " is " + result + ".");
				}
			}
		userInput.close();	
		}

	}

}
