import java.util.Scanner;

public class marksRemapper {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.print("Enter all percentages (separated by spaces): ");
		int length = 0;
		double numbers[] = new double[10000];
		String inputLine = userInput.nextLine();
		Scanner numberInput = new Scanner(inputLine);
		if(!numberInput.hasNext())
		{
			System.out.println("Nothing was entered.");
			System.out.println("The original average was 0.0 and the standard deviation was 0.0.");
			System.out.println("The new average is 0.0 and the new standard deviation is 0.0.");
			System.exit(0);
		}
		String[] readInputLine = inputLine.split(" ");
		if(readInputLine!=null)
		{
			for(int count = 0; count<readInputLine.length; count++)
			{
				try 
			    {
			     double tryNumber = Double.valueOf(readInputLine[count]);
			     if(tryNumber > 100)
			     {
			      numbers[length] = 100;
			     }
			     else if(tryNumber < 0)
			     {
			      numbers[length] = 0;
			     }
			     else
			     {
			      numbers[length] = tryNumber;
			     }
			     length++;
			    } 
			    catch(NumberFormatException nfe) 
			    {
			     System.out.printf("Error: %s indexs not a valindexd number.\n", readInputLine[count]);
			    }		
		    }  
		}
		userInput.close();
		numberInput.close();
		
		double[] marks = new double[length];
		for(int index = 0; index < length; index++)
		    marks[index] = numbers[index];
		double average = determineAverage(marks);
		double standardDeviation = determineStandardDeviation(marks, average);
		System.out.printf("The original average was %.1f and the standard deviation was %.1f.\n", average, standardDeviation);
		
		double[] newMarks = new double[length];
		if(average!=60.0 || standardDeviation!=20.0)
		{
			for(int count = 0; count<marks.length; count++)
			{
				double newMark = 60.0 + (marks[count]-average)*20.0/standardDeviation;
				if(newMark>100)
				{
					newMark = 100;
				}
				else if(newMark<0)
				{
					newMark=0;
				}
				newMarks[count]=newMark;
			}		
		}
		for(int index = 0; index < marks.length; index++)
		   {
		    if (index != 0)
		     System.out.print(", ");
		    System.out.printf("%.1f->%.1f", marks[index], newMarks[index]);
		   }
		double newAverage = determineAverage(newMarks);
		double newStandardDeviation = determineStandardDeviation(newMarks, newAverage);
		System.out.printf("\nThe new average is %.1f and the new standard deviation is %.1f.", newAverage, newStandardDeviation);
	}
	
	public static double determineAverage( double[] arrayOfNumbers ) 
	{
		if(arrayOfNumbers == null)
			return 0.0;
		double totalMarks = 0;
		for(int index=0; index<arrayOfNumbers.length; index++)
		{
			totalMarks += arrayOfNumbers[index];
		}
		return totalMarks/arrayOfNumbers.length;
	}
	
	public static double determineStandardDeviation( double[] arrayOfNumbers, double average ) 
	{
		if(arrayOfNumbers == null)
			return 0.0;
		double total = 0;
		for(int count = 0; count<arrayOfNumbers.length; count++)
		{
			double tempValue = (arrayOfNumbers[count]-average)*(arrayOfNumbers[count]-average);
		    total = total+tempValue;
		}
		double standardDeviation = Math.sqrt(total/arrayOfNumbers.length);
		return standardDeviation;
	}
	
	public static boolean modifyAllMarks( double[] arrayOfMarks, double desiredAverage, double desiredStandardDeviation ) 
	{
		double oldAverage = determineAverage(arrayOfMarks);
		double oldStandardDeviaton = determineStandardDeviation(arrayOfMarks, oldAverage);
		if(oldAverage == desiredAverage && oldStandardDeviaton == desiredStandardDeviation)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
 
}
