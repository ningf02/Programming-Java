import java.util.Scanner;

public class minAndMax {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		
		System.out.print("Please enter a list of numbers separated by space: ");
		String inputLine = userInput.nextLine();
		Scanner numberInput = new Scanner(inputLine);
		
		while(!numberInput.hasNextDouble())
		{
			System.err.println("Error: No numbers provided. Please try again. ");
			inputLine = userInput.nextLine();
			numberInput = new Scanner(inputLine);
		}
				
			double minimumNumber = numberInput.nextDouble();
			double maximumNumber = minimumNumber;
			
			while(numberInput.hasNextDouble())
			{
				double nextNumber = numberInput.nextDouble();
				if(nextNumber < minimumNumber)
				{
					minimumNumber = nextNumber;
				}
				if(nextNumber > maximumNumber)
				{
					maximumNumber = nextNumber;
				}					
			}
			
			System.out.printf("The numbers you entered are between %.1f and %.1f.", minimumNumber, maximumNumber);
		    
			userInput.close();
			numberInput.close();
	}

}
