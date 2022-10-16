import java.util.Scanner;

public class averageAndStandardDeviation {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.println("Enter three numbers separated by spaces:");
		double number1 = userInput.nextDouble();
		double number2 = userInput.nextDouble();
		double number3 = userInput.nextDouble();
		
		double average = (number1 + number2 + number3)/3;
		double standardDeviation = Math.sqrt(((number1 - average)*(number1 - average) + 
				                              (number2 - average)*(number2 - average) +
				                              (number3 - average)*(number3 - average)) / 3);
		
		System.out.println("The average of the three numbers is " + average +
				            ", and the standard deviation is " + standardDeviation);

		userInput.close();
	}


}
