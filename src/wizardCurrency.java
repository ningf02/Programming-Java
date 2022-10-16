import java.util.Scanner;

public class wizardCurrency {

	private static final int POUNDS_TO_PENCE = 100;
	private static final int GALLEON_TO_KNUTS = 493;
	private static final int SICKLE_TO_KNUTS = 29;
	private static final int GALLEON_TO_SICKLES = 17;

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		try
		{
			System.out.println("1. Convert Wizarding Currency To GBP\n"
					+ "2. Convert Knuts To Wizarding Currency and GBP\n"
					+ "3. Convert GBP to Wizarding Currency\n"
					+ "4. Quit");
			System.out.print("Select function> ");
			int userChoice = userInput.nextInt();
			if(userChoice == 1)
			{
				System.out.print("Enter the number of Galleons > ");
				while(!userInput.hasNextInt())
				{
					System.out.print("Error: The number of Galleons should be an integer (e.g. 3)\n"
							+ "Enter the number of Galleons > ");
					userInput.next();
				}
				int amountOfGalleons = userInput.nextInt();	
				System.out.print("Enter the number of Sickles > ");
				while(!userInput.hasNextInt())
				{
					System.out.print("Error: The number of Sickles should be an integer (e.g. 5)\n"
							+ "Enter the number of Sickles > ");
					userInput.next();
				}
				int amountOfSickles = userInput.nextInt();	
				System.out.print("Enter the number of Knuts > ");
				while(!userInput.hasNextInt())
				{
					System.out.print("Error: The number of Knuts should be an integer (e.g. 12)\n"
							+ "Enter the number of Knuts > ");
					userInput.next();
				}
				int amountOfKnuts = userInput.nextInt();
				double totalPence = convertWizardingCurrencyToPence(amountOfGalleons, amountOfSickles, amountOfKnuts);
				double totalPounds = totalPence/POUNDS_TO_PENCE;
				System.out.printf("In British Pounds HP%d:%d:%d is GBP%.2f.",amountOfGalleons, amountOfSickles, amountOfKnuts, totalPounds);
			}
			
			else if(userChoice == 2)
			{
				System.out.print("Enter the number of Knuts > ");
				while(!userInput.hasNextInt())
				{
					System.out.print("Error: The number of Knuts should be an integer (e.g. 56)\n"
							+ "Enter the number of Knuts > ");
					userInput.next();
				}
				int amountOfKnuts = userInput.nextInt();
				double totalPence = convertWizardingCurrencyToPence(0,0, amountOfKnuts);
				double totalPounds = totalPence/POUNDS_TO_PENCE;
				System.out.print(amountOfKnuts + " knuts is " + convertKnutsToWizardingCurrency(amountOfKnuts) + ", and is equal to GBP" + totalPounds + "." );				
			}
			
			else if(userChoice == 3)
			{
				System.out.print("Enter the number of British pounds and pence (e.g. 1.24) > ");
				while(!userInput.hasNextDouble())
				{
					System.out.print("Error: Invalid number of British pounds and pence\n"
							+ "Enter the number of British pounds and pence (e.g. 1.24) > ");
					userInput.next();
				}
				double GBP = userInput.nextDouble();
			    double pence = (GBP-Math.floor(GBP))*POUNDS_TO_PENCE;
				int pounds = (int)(Math.floor(GBP));
				System.out.print("In wizarding currency GBP" + GBP + " is " + convertGBPToWizardingCurrency(pounds, (int)pence) );
				
				
			}
			else if(userChoice == 4)
			{
				System.exit(0);
			}
			else
			{
				System.out.println("Error: Invalid selection.");
			}
		}

		catch(NumberFormatException e) 
		{
			System.out.println("Error: Invalid selection.");
		}
		catch(Exception e) 
		{
			System.out.println("Error: Invalid selection.");
		}
	    userInput.close();
}
	
	public static int convertGBPToKnuts( int pounds, int pence )
	{
		int penceInPounds = pounds*POUNDS_TO_PENCE;
		double knuts = (pence+penceInPounds)*((GALLEON_TO_KNUTS + 11*(SICKLE_TO_KNUTS))/499);
		return (int)Math.round(knuts);	 
	}
	
	public static String convertKnutsToWizardingCurrency(int totalKnuts) 
	{
		int knuts = totalKnuts%SICKLE_TO_KNUTS;
		int totalSickles = (totalKnuts-knuts)/SICKLE_TO_KNUTS;
		int sickles = totalSickles%GALLEON_TO_SICKLES;
	    int galleons = (totalSickles-sickles)/GALLEON_TO_SICKLES;
		String knutsToWizardingCurrency = "HP" + galleons + ":" + sickles + ":" + knuts;
	    return knutsToWizardingCurrency;
	}
	
	public static String convertGBPToWizardingCurrency(int pounds, int pence) 
	{
		int totalKnuts = convertGBPToKnuts(pounds, pence);
		String GBPToWizardingCurrency = convertKnutsToWizardingCurrency(totalKnuts);
		return GBPToWizardingCurrency;
	}
	
	public static int convertWizardingCurrencyToKnuts(int numGalleons, int numSickles, int numKnuts) 
	{
		int totalKnuts = numKnuts + numGalleons*GALLEON_TO_KNUTS + numSickles*SICKLE_TO_KNUTS;
		return totalKnuts;
	}
	
	public static int convertWizardingCurrencyToPence(int numGalleons, int numSickles, int numKnuts) 
	{
        return (int) Math.round(convertWizardingCurrencyToKnuts(numGalleons, numSickles, numKnuts)/(812/4.99)*100);
	}
	
	public static double getNumberFromUser(String prompt, String errorMessage, Scanner input, boolean integerRequired)
	{
		double number = 0;
		boolean isInteger = true;
		boolean isDouble = true;
		if(integerRequired)
		{
			do
			{
				isInteger = true;
				System.out.print(prompt);
				String inputIntegerNumber = input.next();
				try 
				{
					number = Integer.valueOf(inputIntegerNumber);
				} 
				catch(NumberFormatException nfe) 
				{
					isInteger = false;
					System.out.println(errorMessage);
				}
			}while(isInteger == false);
		}
		else
		{
			do
			{
				isDouble = true;
				System.out.print(prompt);
				String inputDoubleNumber = input.next();
				try 
				{
					number = Double.valueOf(inputDoubleNumber);
				} 
				catch(NumberFormatException nfe) 
				{
					isDouble = false;
					System.out.println(errorMessage);
				}				
			}while(isDouble == false);			
		}
		return number;		
	}

}
