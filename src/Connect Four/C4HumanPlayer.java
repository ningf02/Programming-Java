import java.util.Scanner;

public class C4HumanPlayer extends ConnectPlayer{
	Scanner userInput = new Scanner(System.in);

	public int dropXDisc()
	{
		System.out.println("Drop a disk at columns (1-7). > ");
		int chosenColumn = userInput.nextInt()-1;
		return chosenColumn;
	}
	public int dropODisc()
	{
		System.out.println("Drop a disk at columns (1-7). > ");
		int chosenColumn = userInput.nextInt()-1;
		return chosenColumn;
	}

	

}