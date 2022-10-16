import java.util.Scanner;

public class percentageAnalysis {

	private static final int NUMBER_OF_MARKS = 5;

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.print("Enter the " + NUMBER_OF_MARKS + " percentages obtained: ");
		double[] percentages = new double[NUMBER_OF_MARKS];
		int percentagesCount = 0;
		while(percentagesCount<NUMBER_OF_MARKS && userInput.hasNextDouble())
		{
			double currentPercentage = userInput.nextDouble();
			if(currentPercentage>=0 && currentPercentage<=100)
			{
				percentages[percentagesCount]=currentPercentage;
			}
			percentagesCount++;
		}
		double averageMark = determineAverageMark(percentages);
		int aboveAverageStudents = countAboveAverageStudents(percentages, averageMark);
		System.out.println("The average percentage is " + averageMark + "% and there " +
				  ((aboveAverageStudents > 1) ? "were " + aboveAverageStudents + " above average students." :
				      ((aboveAverageStudents == 1) ? "was only 1 above average student." :
				    	  "were no above average students.")));
		userInput.close();

	}
	
	public static double determineAverageMark( double[ ] marks )
	{
		if (marks == null)
			return 0.0;
		double totalMarks = 0;
		for(int index=0; index<marks.length; index++)
		{
			totalMarks += marks[index];
		}
		return totalMarks/marks.length;
	}
	
	 public static int countAboveAverageStudents( double[ ] marks, double average )
	 {
		 if (marks == null)
				return 0;
		 int aboveAverageStudents = 0;
		 for(int index = 0; index<marks.length; index++)
		 {
			 if(marks[index]>=average)
				 aboveAverageStudents++;
		 }
		 return aboveAverageStudents;			
	 }

}
