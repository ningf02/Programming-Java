import java.util.Scanner;

public class lessOrEqual {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.print("Please enter the limit. > ");		
		while(!userInput.hasNextInt())
		{
			System.out.print("Please enter an integer as the limit, enter again. > ");
			userInput.next();
		}
		int limit = userInput.nextInt();
		while(limit<=0)
		{
			System.out.print("Please enter a positive integer as the limit, enter again. > ");
			limit = userInput.nextInt();
		}
		
		int maximumNumber = (int) Math.sqrt(limit); 
		System.out.print("The numbers whose squares are less than or equal to " + limit + " are ");
		for(int currentNumber = 0; currentNumber<=maximumNumber; currentNumber++)
		{
			System.out.print((currentNumber==0?"":",") + currentNumber);
		}
		System.out.print(".");
    
        userInput.close();
	}

}
