package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
//constructor 
	public Spreadsheet() {
		//initializes a 2D array of cells with all elements containing EmptyCell objects
		EmptyCell[][] array;
		/*for(int col=1;col<=12;col++) {
			for(int row=1;row<=20;row++) {
				array[col][row]= 
			}
		}*/
	}
	@Override
	public String processCommand(String command)
	{
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public int getRows()
	{
		// TODO Auto-generated method stub
		return 20;
	}

	@Override
	public int getCols()
	{
		// TODO Auto-generated method stub
		return 12;
	}

	@Override
	public Cell getCell(Location loc)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getGridText()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
