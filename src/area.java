import java.util.Scanner;

public class area {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.println("Enter the X and Y Co-ordinates of the first vertice (seperate by space)");
		double X1 = userInput.nextDouble();
		double Y1 = userInput.nextDouble();
		System.out.println("Enter the X and Y Co-ordinates of the second vertice (seperate by space)");
		double X2 = userInput.nextDouble();
		double Y2 = userInput.nextDouble();
		System.out.println("Enter the X and Y Co-ordinates of the third vertice (seperate by space)");		
		double X3 = userInput.nextDouble();
		double Y3 = userInput.nextDouble();
		
		double areaOfTriangle = Math.abs((X1*(Y2-Y3) + X2*(Y3-Y1) + X3*(Y1-Y2))/2);
		
		System.out.println("The area of the triangle with Co-ordinates entered above is " + areaOfTriangle);
        
		userInput.close();
	}

}
