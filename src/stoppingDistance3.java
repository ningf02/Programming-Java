import java.util.Scanner;

public class stoppingDistance3 {

	private static final double HOUR_TO_SECOND = 3600;
	private static final double KILOMETRE_TO_METRE = 1000;

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		
		System.out.print("Enter vehicle speed in km/hr> ");
		while(!userInput.hasNextDouble())
		{
			System.out.print("Error: Enter a positive number for the speed of the vehicle.\nEnter vehicle speed in km/hr> ");
			userInput.next();
		}
		double vehicleSpeed = userInput.nextDouble();
		while(vehicleSpeed <= 0)
		{
			System.out.print("Error: Enter a positive number for the speed of the vehicle.\nEnter vehicle speed in km/hr> ");
            vehicleSpeed = userInput.nextDouble();
		}
		
		System.out.print("Enter age in years> ");
		while(!userInput.hasNextDouble())
		{
			System.out.print("Error: Enter a positive whole number for the age of the driver.\nEnter age in years> ");
			userInput.next();
		}
		int age = userInput.nextInt();
		while(age <= 0)
		{
			System.out.print("Error: Enter a positive whole number for the age of the driver.\nEnter age in years>  ");
            age = userInput.nextInt();
		}
		
		System.out.print("Is the road wet (Yes/No)? ");
		String wetOrNot = userInput.next();
		while((!wetOrNot.equalsIgnoreCase("yes")) && (!wetOrNot.equalsIgnoreCase("no")))
		{
			System.out.print("Error: You must enter either Yes or No.\nIs the road wet (Yes/No)? ");
			wetOrNot = userInput.next();
		} 
		boolean wet = wetOrNot.equalsIgnoreCase("yes");
				
		System.out.print("Is the road icy (Yes/No)? ");
		String icyOrNot = userInput.next();
		while((!icyOrNot.equalsIgnoreCase("yes")) && (!icyOrNot.equalsIgnoreCase("no")))
		{
			System.out.print("Error: You must enter either Yes or No.\nIs the road icy (Yes/No)? ");
			icyOrNot = userInput.next();
		}
		boolean icy = icyOrNot.equalsIgnoreCase("yes");
		
		double coefficientOfFriction = computeCoefficientOfFriction(icy, wet);
		double brakingDistance = computeBrakingDistance(vehicleSpeed, icy, wet);
		double reactionDistance = computeReactionDistance(vehicleSpeed, age);
		int stoppingDistance = computeStoppingDistance(vehicleSpeed, age, icy, wet);
		
		System.out.print("As the road is " + (icy?"icy and ":"") + (wet?"wet":"dry") + ", the coefficient of friction is " + coefficientOfFriction + ".\n"
				+ "At a speed of " + vehicleSpeed + "km/hr, a driver who is " + age + " years old, the reaction distance is " + Math.round(reactionDistance) + "m, the braking distance is " + Math.round(brakingDistance) + "m, and so the stopping distance is " + Math.round(stoppingDistance) + "m.\n");
		
		userInput.close();

	}
	
	public static double computeCoefficientOfFriction(boolean roadIsIcy, boolean roadIsWet)
	{
		double coefficientOfFriction;
		if (roadIsIcy)
		{
			coefficientOfFriction = 0.1;
		}
		else if(roadIsWet)
		{
			coefficientOfFriction = 0.4;
		}
		else
		{
			coefficientOfFriction = 0.8;
		}		
		return coefficientOfFriction;			
	}
	
	public static double computeBrakingDistance(double vehicleSpeed, boolean roadIsIcy, boolean roadIsWet)
	{
	    double brakingDistance = (vehicleSpeed*vehicleSpeed)/(250*computeCoefficientOfFriction(roadIsIcy, roadIsWet));
	    return brakingDistance;
	}
	
	public static double computeReactionDistance(double vehicleSpeed, int age)
	{
		double reactionTime = ((Math.abs(age-24))*0.05)+1;
		double reactionDistance = (vehicleSpeed/HOUR_TO_SECOND*KILOMETRE_TO_METRE) * reactionTime;
		return reactionDistance;
	}
	
	public static int computeStoppingDistance(double vehicleSpeed, int age, boolean roadIsIcy, boolean roadIsWet)
	{
		double stoppingDistance = computeBrakingDistance(vehicleSpeed, roadIsIcy, roadIsWet) + computeReactionDistance(vehicleSpeed, age);
		int roundedStoppingDistance = (int) Math.round(stoppingDistance);
		return roundedStoppingDistance;
	}
	

}
