
public class PieceWorker extends Employee{
	
	private double wage;
	private double pieces;
	
	public PieceWorker(String firstName, String lastName,  String socialSecurityNumber, double wage, int pieces)
	{
		super(firstName, lastName, socialSecurityNumber);
		if(wage<0.0)
		{
			throw new IllegalArgumentException("Wage per piece must be >= 0.0");
		}
		if (pieces < 0.0) // validate
	         throw new IllegalArgumentException("Pieces made must be >= 0.0");
		this.wage = wage;
		this.pieces = pieces;
	}

	public void setWage(double wage)
	{
		if (wage < 0.0)
	         throw new IllegalArgumentException("Wage per piece must be >= 0.0");
	      this.wage = wage;
	}  
	
	public double getWage()
	{
	    return wage;
	} 
	
	public void setPieces(double pieces)
	 {
	      if (pieces < 0.0)
	         throw new IllegalArgumentException("Pieces made must be >= 0.0");
	      this.pieces = pieces;
	 }
	
	public double getPieces()
	{
		return pieces;
	}
	
	@Override                                                           
	   public double earnings()                                            
	   {                                                                   
	      double wagePerPiece = getWage();
	      double piecesMade = getPieces();
	      return wagePerPiece * piecesMade;
	   }          
	
	public String toString()
	{
		return String.format("piece worker: %s%n%s: $%,.2f; %s: %,.2f",
		         super.toString(), "wage per piece", getWage(),                     
		         "pieces produced", getPieces()); 
	}
	  
	   


	
	

}
