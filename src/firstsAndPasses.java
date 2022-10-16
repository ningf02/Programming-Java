import java.util.Scanner;

public class firstsAndPasses {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		
		System.out.print("Enter the number of students in the class> ");
		int numberOfStudents = userInput.nextInt();
		while(numberOfStudents<=0)
		{
			System.out.print("Error: The number of students must be greater than 0. Please enter again> ");
		    numberOfStudents = userInput.nextInt();
		}
		
		int studentCount = 1;
		int numberOfFirstClassHonours = 0;
		int numberOfPasses = 0;
		while(studentCount <= numberOfStudents)
		{
			System.out.print("Enter the percentage obtained by student " + studentCount + "> ");
			double percentage = userInput.nextDouble();
			while(percentage<0 | percentage>100)
			{
				System.out.print("Invalid percentage.  Please enter the mark again for this student. ");
				percentage = userInput.nextDouble();
			}
			studentCount++;
		   
			percentage = Math.round(percentage);			
			if(percentage>=40)
			{
				numberOfPasses++;
			}	
			if(percentage>=70)
			{
				numberOfFirstClassHonours++;
			}
		}
		
		double passPercentage = (numberOfPasses*100)/numberOfStudents;
		
		System.out.printf("In this class of %d students, %d got a first class honour and %.1f%% passed the class.",
				           numberOfStudents, numberOfFirstClassHonours, passPercentage);
		
		userInput.close();
			
	}

}
