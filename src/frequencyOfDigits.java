import java.util.Scanner;

public class frequencyOfDigits {

	public static void main(String[] args) {
		int[] frequencyArray = new int[10];
		Scanner userInput = new Scanner(System.in);
		System.out.print("Enter an integer> ");
		while(userInput.hasNextInt())
		{
			int number = userInput.nextInt();
			countDigitFrequencies(number, frequencyArray);
			printDigitFrequencies(frequencyArray);
			System.out.print("\nEnter an integer> ");
		}
		System.out.print("No integer found.");
		userInput.close();
	}
	
	public static void countDigitFrequencies( int number, int[ ] frequencies )
	{
		String digitsOfNumber = Integer.toString(number);
		int size = digitsOfNumber.length();
		while(size != 0)
		{
			int digit = number%10;
			frequencies[digit]++;
			number = number/10;
			size--;
		}
	}
	
	public static void printDigitFrequencies( int[ ] frequencies )
	{
		for(int count = 0; count < frequencies.length; count++)
		{
			if(frequencies[count] != 0)
				{
				    System.out.print(count + "(" + frequencies[count] + ")" + " ");
				}
		}
	}
}
