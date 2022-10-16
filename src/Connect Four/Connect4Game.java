/* SELF ASSESSMENT
Connect4Game class (35 marks)
My class creates references to the Connect 4 Grid and two Connect 4 Players. It asks the user whether he/she would like to play/quit inside a loop. If the user decides to play then: 1. Connect4Grid2DArray is created using the Connect4Grid interface, 2. the two players are initialized - must specify the type to be ConnectPlayer, and 3. the game starts. In the game, I ask the user where he/she would like to drop the piece. I perform checks by calling methods in the Connect4Grid interface. Finally a check is performed to determine a win. 
Comment: yes

Connect4Grid interface (10 marks)
I define all 7 methods within this interface.
Comment: yes

Connect4Grid2DArray class (25 marks) 
My class implements the Connect4Grid interface. It creates a grid using a 2D array Implementation of the method to check whether the column to drop the piece is valid. It provides as implementation of the method to check whether the column to drop the piece is full. It provides as implementation of the method to drop the piece.  It provides as implementation of the method to check whether there is a win.
Comment: yes

ConnectPlayer abstract class (10 marks)
My class provides at lest one non-abstract method and at least one abstract method. 
Comment: yes

C4HumanPlayer class (10 marks)
My class extends the ConnectPlayer class and overrides the abstract method(s). It provides the Human player functionality.
Comment: yes

C4RandomAIPlayer class (10 marks)
My class extends the ConnectPlayer class and overrides the abstract method(s). It provides AI player functionality. 
Comment: yes

Total Marks out of 100: 100
*/
import java.util.Scanner;

public class Connect4Game {
	public static void main(String[] args)
    {
		Connect4Grid2DArray connect4 = new Connect4Grid2DArray();
        C4HumanPlayer humanPlayer = new C4HumanPlayer();
        C4RandomAIPlayer computerPlayer = new C4RandomAIPlayer();
        boolean connectFour = true;
        int turn = 0;
        
        Scanner userInput = new Scanner(System.in);
		System.out.print("Would you like to play Connect 4? (Please answer Yes/No) > ");
		String userAnswer = userInput.next();
		if(userAnswer.equalsIgnoreCase("yes"))
		{
			System.out.println("Welcome to Connect 4. \n"
					+ "Please select. > \n"
					+ "1. Player vs Player \n2. Player vs AI \n3. AI vs AI\n4. Quit");
			int inputChoice = userInput.nextInt();
			if(inputChoice == 1)
			{
				connect4.emptyGrid();
				while(connectFour)
				{
					if(turn % 2 == 0)
					{
						System.out.print("Player 1's turn. ");	
						connect4.dropPiece(humanPlayer, humanPlayer.dropXDisc());
						connect4.toString();
						turn++;
						if(connect4.didLastPieceConnect4())
						{
							System.out.print("The winner is Player 1.");
							System.exit(0);
						}
						if(connect4.isGridFull())
						{
							System.exit(0);
						}
					}
					else if(turn % 2 == 1)
					{
						System.out.print("Player 2's turn. ");
						connect4.dropAnotherPiece(humanPlayer, humanPlayer.dropODisc());
						connect4.toString();
						turn++;
						if(connect4.didLastPieceConnect4())
						{
							System.out.print("The winner is Player 2.");
							System.exit(0);
						}
						if(connect4.isGridFull())
						{
							System.exit(0);
						}
					}
				}
			}
			
			else if(inputChoice == 2)
			{
				connect4.emptyGrid();
				while(connectFour)
				{
					if(turn % 2 == 0)
					{
						System.out.print("Player 1's turn. ");	
						connect4.dropPiece(humanPlayer, humanPlayer.dropXDisc());
						connect4.toString();
						turn++;
						if(connect4.didLastPieceConnect4())
						{
							System.out.print("The winner is Player 1.");
							System.exit(0);
						}
						if(connect4.isGridFull())
						{
							System.exit(0);
						}
					}
					else if(turn % 2 == 1)
					{
						System.out.println("Player 2's turn. ");
						connect4.dropAnotherPiece(computerPlayer, computerPlayer.dropODisc());
						connect4.toString();
						turn++;
						if(connect4.didLastPieceConnect4())
						{
							System.out.print("The winner is Player 2.");
							System.exit(0);
						}
						if(connect4.isGridFull())
						{
							System.exit(0);
						}
					}
				}
			}
			
			else if(inputChoice == 3)
			{
				connect4.emptyGrid();
				while(connectFour)
				{
					if(turn % 2 == 0)
					{
						System.out.println("Player 1's turn. ");	
						connect4.dropPiece(computerPlayer, computerPlayer.dropXDisc());
						connect4.toString();
						turn++;
						if(connect4.didLastPieceConnect4())
						{
							System.out.print("The winner is Player 1.");
							System.exit(0);
						}
						if(connect4.isGridFull())
						{
							System.exit(0);
						}
					}
					else if(turn % 2 == 1)
					{
						System.out.println("Player 2's turn. ");
						connect4.dropAnotherPiece(computerPlayer, computerPlayer.dropODisc());
						connect4.toString();
						turn++;
						if(connect4.didLastPieceConnect4())
						{
							System.out.print("The winner is Player 2.");
							System.exit(0);
						}
						if(connect4.isGridFull())
						{
							System.exit(0);
						}
					}
				}
			}
			
			else if(inputChoice == 4)
			{
				System.out.print("Game Over.");
				connectFour = false;
			}					
		}
		
		else if (userAnswer.equalsIgnoreCase("no"))
		{
			System.out.print("You have chosen to not play Connect 4. ");
		}
		userInput.close();    
  }


}
