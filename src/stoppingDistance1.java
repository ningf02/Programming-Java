import java.util.Scanner;

public class stoppingDistance1 {

	private static final double HOUR_TO_SECOND = 3600;
	private static final double KILOMETRE_TO_METRE = 1000;

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.println("Enter vehicle speed in km/hr> ");
		double vehicleSpeed = userInput.nextDouble();
		System.out.println("Enter reaction time in seconds> ");
		double reactionTime = userInput.nextDouble();
		
		double reactionDistance = (vehicleSpeed/HOUR_TO_SECOND*KILOMETRE_TO_METRE) * reactionTime;
		double brakingDistance = (Math.pow((vehicleSpeed/HOUR_TO_SECOND*KILOMETRE_TO_METRE), 2)) / 20;
        double stoppingDistance = reactionDistance + brakingDistance;
        
        System.out.printf("At a speed of %.1fkm/hr and with a reaction time of %.1fs, the stopping distance would be %.1fm", vehicleSpeed, reactionTime, stoppingDistance);
        
        userInput.close();
	}

}




