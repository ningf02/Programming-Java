import java.util.Scanner;

public class rangeOfHeights {

	public static void main(String[] args) {
	     Scanner userInput = new Scanner(System.in);
	    
	    
		 System.out.print("Enter a height in metres (Enter 0 to finish)> ");
		 double heightEntered = userInput.nextDouble();			 
		 if(heightEntered == 0)
		 {
			 System.exit(0);
		 }
		 while(heightEntered < 0)
		 {
			 System.err.print("Negative heights are invalid.\n"
			 		+ "Enter a height in metres (Enter 0 to finish)> ");
			 heightEntered = userInput.nextDouble();	
		 }		
		 double minimumNumber = heightEntered;
		 double maximumNumber = minimumNumber;
		 System.out.printf("Heights entered so far are in the range %.1f to %.1f. \n"
				 + "Enter a height in metres (Enter 0 to finish)> ", minimumNumber, maximumNumber);
				            
		 
		 while(userInput.hasNextDouble())
		 {
			 double newHeight = userInput.nextDouble();			 
			 while(newHeight< 0)
			 {
				 System.err.print("Negative heights are invalid.\n"
				 		+ "Enter a height in metres (Enter 0 to finish)> ");
				 newHeight = userInput.nextDouble();	
			 }
			 if(newHeight < minimumNumber)
			 {
				 minimumNumber = newHeight;
			 }
			 if(newHeight > maximumNumber)
			 {
				 maximumNumber = newHeight;
			 }
			 if(newHeight == 0)
			 {
				 System.exit(0);
			 }
			 System.out.printf("Heights entered so far are in the range %.1f to %.1f. \n"
					  + "Enter a height in metres (Enter 0 to finish)> ",minimumNumber, maximumNumber);
		 }
		 userInput.close();	
	}

}
