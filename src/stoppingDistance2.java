import java.util.Scanner;

public class stoppingDistance2 {

	private static final double HOUR_TO_SECOND = 3600;
	private static final double KILOMETRE_TO_METRE = 1000;
	
	public static void main(String[] args) {
		double reactionTime = 0;
		double coefficientOfFriction = 0;		
		Scanner userInput = new Scanner(System.in);
		
		System.out.print("Enter vehicle speed in km/hr> ");
		double vehicleSpeed = userInput.nextDouble();
		
		System.out.print("Enter age in years> ");
		int age = userInput.nextInt();
		if(age<50)
		{
			reactionTime = 2.0;
		}
		else if(50<=age & age<60)
		{
			reactionTime = 2.5;
		}
		else if (age>=60)
		{
			reactionTime = 3.0;
		}
				
				
		System.out.print("Is the road wet (Yes/No)? ");
		String roadConditionAnswer = userInput.next();
		if(roadConditionAnswer.equalsIgnoreCase("yes"))
		{			 
			coefficientOfFriction = 0.4;
		}
		else
		{
			coefficientOfFriction = 0.8;
		}
		
		double brakingDistance = vehicleSpeed*vehicleSpeed/(250*coefficientOfFriction);	
		double reactionDistance = (vehicleSpeed/HOUR_TO_SECOND*KILOMETRE_TO_METRE) * reactionTime;
		double stoppingDistance = reactionDistance + brakingDistance;
		
		System.out.printf("As the road is " + (roadConditionAnswer.equalsIgnoreCase("yes")?"wet":"dry") + ", the coefficient of friction is %.1f,\n"
				+ "As the driver is " + age + " years old, his/her reaction time is %.1fs,\n"
				+ "At a speed of %.1fkm/hr, the reaction distance is %.0fm, the braking distance is %.0fm, and so the stopping distance is %.0fm.",				
				coefficientOfFriction, reactionTime, vehicleSpeed, reactionDistance, brakingDistance, stoppingDistance  );
	
       userInput.close();
	}

}
