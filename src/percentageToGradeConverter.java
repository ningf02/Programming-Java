import java.util.Scanner;

public class percentageToGradeConverter {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		
		
		boolean validInput = true;
		do
		{
			System.out.print("Enter a percentage (or enter 'quit' to finish)> ");
			while(!userInput.hasNextDouble())
			{
				String inputLine = userInput.next();
				boolean quit = inputLine.equalsIgnoreCase("quit");
				if(quit)
				{
					System.exit(0);
				}
				else
				{
					System.out.println("Error: Enter a number between 0.0 and 100.0, or the word quit to exit the program> ");
					System.out.print("Enter a percentage (or enter 'quit' to finish)> ");
				}				
			}
						
			double percentage = userInput.nextDouble();
			while(percentage < 0)
			{
				System.out.print("Percentage has to be greater than or equal to 0%. Please enter again>\n");
				break;
			}
			while(percentage > 100)
			{
				System.out.print("Percentage has to be less than or equal to 100%. Please enter again> \n");
				break;
			}
			double roundedPercentage = Math.round(percentage);
			if(roundedPercentage <=100 & roundedPercentage >= 70)
			{
				System.out.println("The grade for " + percentage + "% is a I.");
			}
			else if(roundedPercentage >= 60 & roundedPercentage < 70)
			{
				System.out.println("The grade for " + percentage + "% is a II.1.");
			}
			else if(roundedPercentage >= 50 & roundedPercentage < 60)
			{
				System.out.println("The grade for " + percentage + "% is a II.2.");
			}
			else if(roundedPercentage >= 40 & roundedPercentage < 50)
			{
				System.out.println("The grade for " + percentage + "% is a III.");
			}
			else if(roundedPercentage >= 35 & roundedPercentage < 40)
			{
				System.out.println("The grade for " + percentage + "% is a F1.");
			}
			else if(roundedPercentage >= 0 & roundedPercentage < 35)
			{
				System.out.println("The grade for " + percentage + "% is a F2.");
			}
			
		}while(validInput);
		
	userInput.close();
		
	}

}
