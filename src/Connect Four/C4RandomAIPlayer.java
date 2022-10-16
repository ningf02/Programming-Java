import java.util.Random;

public class C4RandomAIPlayer extends ConnectPlayer{
	public char[][] emptyGrid = new char[6][7];
	public int dropXDisc()
	{
		int randomColumn = new Random().nextInt(emptyGrid[0].length);
	    return randomColumn;
	}
	public int dropODisc()
	{
		int randomColumn = new Random().nextInt(emptyGrid[0].length);
	    return randomColumn;
	}
	

}
