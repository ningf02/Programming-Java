import java.util.Scanner;

public class BMI {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("What is your weight in kg?");
		double inputWeight = userInput.nextDouble();
		System.out.println("What is your height in metres?");
		double inputHeight = userInput.nextDouble();
		
		double BMI = inputWeight/(inputHeight*inputHeight);
		
		System.out.println("Your BMI is " + BMI);
		
		userInput.close();
		
	}

}

