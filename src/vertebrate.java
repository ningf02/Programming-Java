import java.util.Scanner;

public class vertebrate {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		
		System.out.print("Is the animal cold blooded (Yes/No)? ");
		String coldBloodedAnswer = userInput.next();
	    boolean coldBlooded = coldBloodedAnswer.equalsIgnoreCase("yes");
		
		if(!coldBlooded)
		{
			System.out.print("Does the animal have fins (Yes/No)? ");
			String haveFinsAnswer = userInput.next();
			boolean haveFins = haveFinsAnswer.equalsIgnoreCase("yes");
			
			if(!haveFins)
			{
				System.out.print("Does the aniaml have feathers (Yes/No)? ");
				String haveFeathersAnswer = userInput.next();
				boolean haveFeathers = haveFeathersAnswer.equalsIgnoreCase("yes");
				
				if(!haveFeathers)
				{
					System.out.print("The animal is a mammal.");
				}
				else 
					System.out.print("The animal is a bird.");
			}
			else
				System.out.print("The animal is not included in these five classes.");
		}
		
	    if(coldBlooded)
	    {
	    	System.out.print("Does the animal have fins (Yes/No)? ");
			String haveFinsAnswer = userInput.next();
			boolean haveFins = haveFinsAnswer.equalsIgnoreCase("yes");
			
			if(!haveFins)
			{
				System.out.print("Does the aniaml have scales (Yes/No)? ");
				String haveScalesAnswer = userInput.next();
				boolean haveScales = haveScalesAnswer.equalsIgnoreCase("yes");
				
				if(haveScales)
				{
					System.out.print("The animal is a reptile.");
				}
				else
					System.out.print("The animal is an amphibian.");					
	        }
			else
				System.out.print("The animal is a fish.");
		
	    }  
	    
	    userInput.close();
       
  }
}