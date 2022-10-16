import java.util.Scanner;

public class sieveOfEratosthenes {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.print("Enter int >= 2 : ");
		int inputNumber = userInput.nextInt();
		int[] sequence = sieve(inputNumber);
        System.out.println(sequenceToString(sequence));
        System.out.println(nonCrossedOutSubseqToString(sequence));
        userInput.close();
	}
    
	public static int[] createSequence(int number)
	{
		int[] arrayOfNumbers = new int[number-1];
		int startingNumber = 2;
		for(int count = 0; count < arrayOfNumbers.length; count++)
		{
			arrayOfNumbers[count]=startingNumber;
			startingNumber++;
		}
		return arrayOfNumbers;
	}
	
	public static int[] crossOutHigherMultiples(int[] sequence, int number)
	{
		for(int count = 0; count < sequence.length; count++)
		{
			if(sequence[count] % number == 0 && sequence[count] != number)
			{
				sequence[count] = 1;
			}
		}
		return sequence;
	}
	
	public static int[] sieve(int number)
	{
		int sequence[] = createSequence(number);
		int count = 0;
		while(!(sequence[count] > Math.sqrt(number)))
		{
			if(sequence[count]!=1)
			{
				sequence = crossOutHigherMultiples(sequence, sequence[count]);
				System.out.println(sequenceToString(sequence));
				count++;
			}
			else
			{
				count++;
			}
		}
		return sequence;
	}
	
	public static String sequenceToString(int[] sequence)
	{
		String outPut = String.valueOf(sequence[0]);
		for(int count = 1; count<sequence.length; count++)
		{
			if(sequence[count]!=1) 
			{
				outPut = outPut + ", " + String.valueOf(sequence[count]);
			}
			else
			{
				outPut = outPut + ", " + "[" + String.valueOf(count+2) + "]";
			}
		}
		return outPut;
	}
	
	public static String nonCrossedOutSubseqToString(int[] sequence)
	{
		String outPut = String.valueOf(sequence[0]);
		for(int count = 1; count<sequence.length; count++)
		{
			if(sequence[count]!=1)
				outPut = outPut + ", " + String.valueOf(sequence[count]);
		}
		return outPut;
	}
}
