import java.util.Random;
import java.util.Scanner;

public class tossACoin {

	public static void main(String[] args) {
		int numberOfHeads = 0;
		int numberOfTails = 0;
		Scanner userInput = new Scanner(System.in);
		
		System.out.print("Please enter the number of tosses: ");
		int numberOfTosses = userInput.nextInt();
		
		int[] headOrTail = new int[] {1,2};
		for (int count = 1; count < numberOfTosses; count++)
		{
			 int randomElement = headOrTail[new Random().nextInt(headOrTail.length)];		 
			 if(randomElement == 1)
			 {
				 numberOfHeads++;
			 }
			 else if(randomElement == 2)
			 {
				 numberOfTails++;
			 }			 
		}
		
		int lastToss = headOrTail[new Random().nextInt(headOrTail.length)];
		if(lastToss == 1)
		{
			numberOfHeads++;
		}
		else
		{
			numberOfTails++;
		}	
		 
		System.out.println("After " + numberOfTosses + " tosses, there are " + numberOfHeads + " heads and " + numberOfTails + " tails.");		 		 
		System.out.print("The last toss is a " + ((lastToss==1)?"head.":"tail."));
						 	 
		 userInput.close();
	}

}
