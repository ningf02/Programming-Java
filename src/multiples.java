import java.util.Scanner;

public class multiples {

	public static void main(String[] args) {	
		Scanner userInput = new Scanner(System.in);
		
		System.out.print("Please enter a postive integer: ");
		int inputNumber = userInput.nextInt();
		while(inputNumber<=0)
		{
			System.out.print("Try again. Please enter a postive integer for the number: ");
			inputNumber = userInput.nextInt();
		}
        
		System.out.print("Please enter an integer as the limit: ");
		int inputLimit = userInput.nextInt();
		while(inputLimit<0)
		{
			System.out.print("Try again. Please enter a postive integer for the limit: ");
			inputLimit = userInput.nextInt();
		}
		
		System.out.print("The multiples of " + inputNumber + " (up to " + inputLimit + ") are: ");
		for (int total = 0; (total <= inputLimit); total+=inputNumber)
			System.out.print(((total>0)?", ":"") + total );
				
		userInput.close();
	}

}
