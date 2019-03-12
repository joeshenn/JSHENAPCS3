package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid{
private Cell[][] sheet;
private int rows;
private int columns;
//constructor 
	public Spreadsheet() {
		//initializes a 2D array of cells with all elements containing EmptyCell objects
		rows= 20;
		columns= 12;
		sheet= new EmptyCell[20][12]; 
		/*for(int col=1;col<=columns;col++) {
			for(int row=1;row<=rows;row++) {
				sheet[col][row]= new EmptyCell();
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
		return sheet[loc.getRow()][loc.getCol()];
	}

	@Override
	public String getGridText()
	{
		String gridText ="   |";
		String gridBody="";
		for(char i='A';i<='L';i++) {
			gridText+=String.format("%-10s",Character.toString(i))+"|";
		}
		for(int i=1;i<=columns;i++) {
			gridBody+=String.format("%11s", "|");
		}
			for(int j=1;j<=rows;j++) {
				gridText+="\n"+String.format("%-2s",j+"")+" |"+gridBody;
			}
		// TODO Auto-generated method stub
		return gridText;
	}

}
