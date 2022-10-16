public class twelveDaysOfChristmas {

	private static final int NUMBER_OF_DAYS = 12;

	public static void main(String[] args) {
		
		for(int dayNumber = 1; dayNumber <= NUMBER_OF_DAYS; dayNumber++)
		{
			String dayNumberName = "";
			switch(dayNumber)
			{
			case 1:
				dayNumberName = "first";
				break;
			case 2:
				dayNumberName = "second";
				break;
			case 3:
				dayNumberName = "third";
				break;
			case 4:
				dayNumberName = "fourth";
				break;
			case 5:
				dayNumberName = "fifth";
				break;
			case 6:
				dayNumberName = "sixth";
				break;
			case 7:
				dayNumberName = "seventh";
				break;
			case 8:
				dayNumberName = "eighth";
				break;
			case 9:
				dayNumberName = "nineth";
				break;
			case 10:
				dayNumberName = "tenth";
				break;
			case 11:
				dayNumberName = "eleventh";
				break;
			case 12:
				dayNumberName = "twelfth";
				break;
			default:				
			}
			
		    System.out.println("On the " + dayNumberName + " day of Christmas, \nMy true love sent to me: ");	
		    
		    switch (dayNumber)
			{
			case 12:
				System.out.println( "12 Drummers Drumming," );
			case 11:
				System.out.println( "11 Pipers Piping," );
			case 10:
				System.out.println( "10 Lords a Leaping," );
			case 9:
				System.out.println( "9 Ladies Dancing," );
			case 8:
				System.out.println( "8 Maids a Milking," );
			case 7:
				System.out.println( "7 Swans a Swimming," );
			case 6:
				System.out.println( "6 Geese a Laying," );
			case 5:
				System.out.println( "5 Golden Rings," );
			case 4:
				System.out.println( "4 Calling Birds," );
			case 3:
				System.out.println( "3 French Hens," );
			case 2:
				System.out.println( "2 Turtle Doves," );
			case 1:
				if (dayNumber!=1)
					System.out.print("and ");
				System.out.println( "a Partridge in a Pear Tree.\n" );
			default:
			}		
		}		
	}

}
