import java.util.Scanner;

public class chuckALuck {

	public static void main(String[] args) {
		Wallet wallet = new Wallet();
		Scanner userInput = new Scanner(System.in);
		System.out.print("Please enter the amount of cash in your wallet. > ");
		boolean validBetType = true;
		boolean quitGame = false;
		while(!userInput.hasNextDouble())
		{
			System.out.print("Please enter a valid amount, thank you. > ");
			userInput.next();
		}
		double walletBalance = userInput.nextDouble();
		while(walletBalance<=0)
		{
			if(walletBalance<0)
			{
				System.out.print("Please enter a valid positive amount, thank you. > ");
				walletBalance = userInput.nextDouble();
			}				
			else if(walletBalance==0)
			{
				System.out.print("Sorry, you have entered zero as your balance, therefore you are broke and can not afford to play. Goodbye! :)");
                System.exit(0);
			}			
		}
		wallet.put(walletBalance);
		
		System.out.print("Do you want to play Chuck-a-Luck Dice Game?\n(Answer Yes > continue)\n(Answer No > quit) ");
		String userAnswer = userInput.next();
		while(!userAnswer.equalsIgnoreCase("no") && !userAnswer.equalsIgnoreCase("yes"))
		{
			System.out.print("Please enter either yes or no, thank you. > ");
			userAnswer = userInput.next();
		}
		if(userAnswer.equalsIgnoreCase("yes"))
		{
			System.out.println("Welcome to Chuck-a-Luck! We are glad to see you! Good Luck!");
			System.out.print("Please enter the type of bet you want to place (triple, field, high, low) or quit to exit the game. > ");
			String typeOfBet = userInput.next();
			while(!quitGame)
			{
				while(validBetType)
				{
					if(typeOfBet.equalsIgnoreCase("triple"))
					{
						resolveBet(typeOfBet, wallet);
					}
					else if(typeOfBet.equalsIgnoreCase("field"))
					{
						resolveBet(typeOfBet, wallet);
					}
					else if(typeOfBet.equalsIgnoreCase("high"))
					{
						resolveBet(typeOfBet, wallet);
						
					}
					else if(typeOfBet.equalsIgnoreCase("low"))
					{
						resolveBet(typeOfBet, wallet);				
					}   
					else if(typeOfBet.equalsIgnoreCase("quit"))
					{
						validBetType = false;
						quitGame = true;
					}
					else
					{
						System.out.print("Please enter a valid bet type or enter quit to exit the game, thank you. > ");
						typeOfBet = userInput.next();
					}
				}
				validBetType = true;
			}
		}
		System.out.print("Goodbye. We hope to see you again.");
		userInput.close();
	}
	
	public static void resolveBet(String betType, Wallet wallet)
	{
		Scanner userInput = new Scanner(System.in);
		
		double balance = wallet.check();
		System.out.println("Your wallet balance is £" + balance);
		if(balance<=0)
		{
			System.out.print("Sorry, you are out of money.");
			System.exit(0);
		}
		
		System.out.print("Please enter the bet amount. > ");
		while(!userInput.hasNextDouble())
		{
			System.err.print("Invalid input. Please enter again. >  ");
			userInput.next();
		}
		double betAmount = userInput.nextDouble();
		while(betAmount<=0)
		{
			System.out.print("The bet must be a positive amount. please enter again. > ");
			betAmount = userInput.nextDouble();
		}
		if(betAmount>balance)
		{
			System.out.print("Sorry, there is not enough money in your wallet. Your wallet balance is £" + balance + ". Please enter a lower bet. > ");
			betAmount = userInput.nextDouble();
		}
				
		Dice firstDice = new Dice();
		Dice secondDice = new Dice();
		Dice thirdDice = new Dice();
		
		int sum = firstDice.roll() + secondDice.roll() + thirdDice.roll();
		Boolean triple = true;
		Boolean high = true;
		Boolean low = true;
		if(firstDice.roll() == secondDice.roll() && firstDice.roll() == thirdDice.roll())
		{
			if(firstDice.roll() == 1 || firstDice.roll() == 6)
			{
				triple = true;
			}
			else
				triple = false;							
		}
		if(sum > 10)
		{
			if(firstDice.roll() == secondDice.roll() && firstDice.roll() == thirdDice.roll())
			{
				high = false;
			}
			else
				high = true;
		}
		if(sum < 11)
		{
			if(firstDice.roll() == secondDice.roll() && firstDice.roll() == thirdDice.roll())
			{
				low = false;
			}
			else
			    low = true;
		}
		
		if(betType.equalsIgnoreCase("field"))
		{
			if(sum<8 || sum>12)
			{
				wallet.put(betAmount);
			}
			else
				wallet.get(betAmount);
		}
		else if(betType.equalsIgnoreCase("high"))
		{
			if(high == true)
			{
				wallet.put(betAmount);
			}
			else
				wallet.get(betAmount);
		}
		else if(betType.equalsIgnoreCase("low"))
		{
			if(low == true)
			{
				wallet.put(betAmount);
			}
			else
				wallet.get(betAmount);
		}

		else if(betType.equalsIgnoreCase("triple"))
		{
			if(triple == true)
			{
				wallet.put(betAmount * 30);
			}
			else
				wallet.get(betAmount);
		}
		
		double result = wallet.check()-balance;
		if(wallet.check()>balance)
		{
			System.out.print("Congratulations. You have won £" + result + ".\n");
		}
		else if(wallet.check()<balance)
		{
			System.out.print("Sorry. You have lost £" + Math.abs(result) + ".\n");
		}
		else
		{
			System.out.print("Your haven't won or lost anything.\n");
		}
		System.out.println("You started the game with £" + balance + ", and you ended the game with £" + wallet.check() + ".");
        System.exit(0);
		userInput.close();
		


		
	}
}
		