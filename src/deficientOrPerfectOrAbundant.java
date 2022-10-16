import java.util.ArrayList;
import java.util.Scanner;

public class deficientOrPerfectOrAbundant {

	public static void main(String[] args) {
		Scanner userInput =new Scanner(System.in);
		System.out.print("Enter the positive whole number to be considered(or 'quit')> ");
		while(userInput.hasNext())
		{
			if(userInput.hasNextInt())
			{
				int number = userInput.nextInt();
				if(number<=0)
				{
					System.out.print("Error: " + number + " is not a positive whole number. \nEnter the positive whole number to be considered(or 'quit')> ");
				}
				else
				{
					System.out.print(number + " is " + isDeficientPerfectOrAbundant(number));
					if(isAdmirable(number))
					{
						System.out.print(" and is admirable. \nEnter the positive whole number to be considered(or 'quit')> ");
					}
					else
					{
						System.out.print(" and is not admirable. \nEnter the positive whole number to be considered(or 'quit')> ");
					}

				}
			}
			else
			{
				if(!userInput.hasNext("quit"))
				{
					System.out.print("Error: " + userInput.next() + " is not a positive whole number. \nEnter the positive whole number to be considered(or 'quit')> ");
				}
				else
					System.exit(0);				
			}
		}
		userInput.close();
	}
	
	public static int computeNextProperDivisor( int number, int lastProperDivisor ) 
	{
		while(lastProperDivisor < number)
		{
			if(number%lastProperDivisor==0)
			{
				return lastProperDivisor;
			}
			else
			{
				lastProperDivisor++;
			}
		}
		return -1;
	}
	
	public static int sumOfProperDivisors( int number ) 
	{
		ArrayList<Integer> properDivisors = new ArrayList<Integer>();
		int sumOfProperDivisors = 0;
		int divisorCount = 1;
		int nextDivisor = computeNextProperDivisor(number, divisorCount);
		while(!(nextDivisor == -1))
		{
			divisorCount = nextDivisor + 1;
			properDivisors.add(nextDivisor);
			nextDivisor = computeNextProperDivisor(number, divisorCount);
		}
		for(int index = 0; index<properDivisors.size(); index++)
		{
			sumOfProperDivisors += properDivisors.get(index);
		}
		return sumOfProperDivisors;
	}
	
	public static String isDeficientPerfectOrAbundant( int number )
	{
	    String check = new String();
		int sum = sumOfProperDivisors(number);
		if(sum < number)
		{
			check = "deficient";
		}
		else if(sum == number)
		{
			check = "perfect";
		}
		else if(sum > number)
		{
			check = "abundant";
		}
		return check;
	}
	
	public static boolean isAdmirable( int number ) 
	{
		ArrayList<Integer> properDivisors = new ArrayList<Integer>();
		int sumOfProperDivisors = 0;
		int divisorCount = 1;
		int nextDivisor = computeNextProperDivisor(number, divisorCount);
		while(!(nextDivisor == -1))
		{
			divisorCount = nextDivisor + 1;
			properDivisors.add(nextDivisor);
			nextDivisor = computeNextProperDivisor(number, divisorCount);
		}
		for(int index = 0; index<properDivisors.size(); index++)
		{
			sumOfProperDivisors += properDivisors.get(index);
		}
		
		boolean isAdmirable = false;
		for(int index = 0; index<properDivisors.size(); index++)
		{
			if(sumOfProperDivisors - 2*properDivisors.get(index) == number)
			{
				isAdmirable = true;
			}
		}
		return isAdmirable;
	}

}
