import java.util.Scanner;

public class factiorian {

	
	public static void main(String[] args) {		
		 Scanner input = new Scanner( System.in );
		    String inputString="";
			do {
				System.out.print("Enter number (or 'quit')>");
				input = new Scanner( System.in );
				if (input.hasNextInt())
				{
					int number = input.nextInt();
					System.out.println("The number " + number + " is " +
					        (isFactorion( number ) ? "" : "not ") + "a Factorian.");
					
				}
				else if (input.hasNext())
					inputString = input.next();
			} while (!inputString.equalsIgnoreCase("QUIT"));	
	     input.close();
	}
	
	public static int computeFactorial(int inputNumber)
	{
		int result = 1;
		for(int count = inputNumber; count>=1; count--)
		{
			result = result*count;
		}
		return result;			
	}
	
	public static boolean isFactorion(int inputNumber)
	{
		int currentNumber = inputNumber;
		int sumOfFactorials = 0;
		while(currentNumber!=0)
		{
			sumOfFactorials += computeFactorial(currentNumber % 10);
			currentNumber = currentNumber/10;
		}
		return(inputNumber == sumOfFactorials);			
	}


}
