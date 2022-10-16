public class Connect4Grid2DArray implements Connect4Grid{
	private static final char EMPTY = ' ';
	private static final char X = 'X';
	private static final char O = 'O';
	public char[][] emptyGrid = new char[7][7];
	
	public void emptyGrid()
	{
		for (int row = 0; row < emptyGrid.length; row++)
		{
			if(row == 6)
			  {
				  System.out.print("_____________________________");
			  }
			else
			{
				 for (int column = 0; column < emptyGrid[row].length; column++) 
		            {
		               emptyGrid [row][column] = ' ';
		               System.out.print("|  " + emptyGrid[row][column]);
		            }
			}
            System.out.print("\n");
        }
	}
	
	public String toString()
	{
	  String grid = "";
	  for (int row = 0; row < emptyGrid.length; row++)
		{
		  if(row == 6)
		  {
			  grid+="_____________________________";
		  }
		  else
		  {
			  for (int column = 0; column < emptyGrid[row].length; column++)
				{
					if(this.emptyGrid[row][column] == X)
					{
						grid += "| X ";
					}
					else if(this.emptyGrid[row][column] == O)
					{
						grid += "| O ";
					}
					else if(this.emptyGrid[row][column] == EMPTY)
					{
						grid += "|   ";
					}
				}
		  }
			grid += "\n";
		}
	  System.out.print(grid);
	  return grid;
	}
	
	public boolean isValidColumn(int column)
	{
		if(column < 0 || column > emptyGrid[0].length)
		{
			System.out.println("It is not a valid column. Please select another column. > ");
			return false;
		}
		else
		{
			return true;
		}
			
	}
	
	public boolean isColumnFull(int column)
	{
		if(isValidColumn(column))		
		{
			if(emptyGrid[0][column] != ' ')
			{
				System.out.println("The column you have selected is full. Please select another column. > ");
				return false;
			}
			else
				return true;
		}
		else
		{
			return false;
		}
	}	
	
	public void dropPiece(ConnectPlayer player, int column)
	{
		if(!isColumnFull(column))
		{
			column = player.dropXDisc();
			for (int row = 5; row >= 0; row--)
			{
				if (this.emptyGrid[row][column] == ' ')
				{
					this.emptyGrid[row][column] = 'X';
					break;
				}
			}
		}
		else
		{
			for (int row = 5; row >= 0; row--)
			{
				if (this.emptyGrid[row][column] == ' ')
				{
					this.emptyGrid[row][column] = 'X';
					break;
				}
			}
		}
	}
	
	public void dropAnotherPiece(ConnectPlayer player, int column)
	{
		if(!isColumnFull(column))
		{
			column = player.dropODisc();
			for (int row = 5; row >= 0; row--)
			{
				if (this.emptyGrid[row][column] == ' ')
				{
					this.emptyGrid[row][column] = 'O';
					break;
				}
			}		
		}
		else
		{
			for (int row = 5; row >= 0; row--)
			{
				if (this.emptyGrid[row][column] == ' ')
				{
					this.emptyGrid[row][column] = 'O';
					break;
				}
			}
		}
	}
	
	public boolean didLastPieceConnect4()
	{
		for (int row = 0; row < emptyGrid.length-1; row++)
		{
			for (int column = 0; column < emptyGrid[0].length - 3; column+=1)
			{
				if ((emptyGrid[row][column] != ' ')
				    && (emptyGrid[row][column+1] != ' ')
				    && (emptyGrid[row][column+2] != ' ')
					&& (emptyGrid[row][column+3] != ' ')
					&& ((emptyGrid[row][column] == emptyGrid[row][column+1])
						&&(emptyGrid[row][column+1] == emptyGrid[row][column+2])
						&&(emptyGrid[row][column+2] == emptyGrid[row][column+3])))
				{
					return true;
				}
			}
		}
		
		for (int row = 0; row < emptyGrid.length - 4; row+=1)
		{
			for (int column = 0; column < emptyGrid[0].length; column++)
			{
				if ((emptyGrid[row][column] != ' ')
					&& (emptyGrid[row+1][column] != ' ')
					&& (emptyGrid[row+2][column] != ' ')
				    && (emptyGrid[row+3][column] != ' ')
				    && ((emptyGrid[row][column] == emptyGrid[row+1][column])
				    	&& (emptyGrid[row+1][column] == emptyGrid[row+2][column])
				        && (emptyGrid[row+2][column] == emptyGrid[row+3][column])))
				{
					return true;
				}		
			}
		}
		
		for (int row = 0; row < emptyGrid.length - 4; row++)
		{
			for (int column = 0; column < emptyGrid[0].length - 3; column+=1)
			{
				if((emptyGrid[row][column] != ' ')
				   && (emptyGrid[row+1][column+1] != ' ')
				   && (emptyGrid[row+2][column+2] != ' ')
				   && (emptyGrid[row+3][column+3] != ' ')
				   && ((emptyGrid[row][column] == emptyGrid[row+1][column+1])
					   && (emptyGrid[row+1][column+1] == emptyGrid[row+2][column+2])
					   && (emptyGrid[row+2][column+2] == emptyGrid[row+3][column+3])))
				{
					return true;
				}
			}
		}
		
		for (int row = 3; row < emptyGrid.length - 1; row+=1)
		{
			for (int column = 0; column < emptyGrid[0].length - 3; column++)
			{
				if ((emptyGrid[row][column] != ' ')
					&& (emptyGrid[row-1][column+1] != ' ')
					&& (emptyGrid[row-2][column+2] != ' ')
				    && (emptyGrid[row-3][column+3] != ' ')
				    && ((emptyGrid[row][column] == emptyGrid[row-1][column+1])
				    	&& (emptyGrid[row-1][column+1] == emptyGrid[row-2][column+2])
				        && (emptyGrid[row-2][column+2] == emptyGrid[row-3][column+3])))
				{
					return true;
				}		
			}
		}
		 return false;	
	}
	
	public boolean isGridFull()
	{
		int row = 0;
		for (int column = 0; column < emptyGrid[0].length; column+=1)
		{
			if(emptyGrid[row][column] == ' ')
			{
				return false;
			}
		}
		System.out.print("The grid is full. The game ended up in a draw.");
		return true;
	}

}
