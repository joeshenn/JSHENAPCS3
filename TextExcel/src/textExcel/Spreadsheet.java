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
		sheet= new Cell[20][12]; 
		for(int col=1;col<=columns;col++) {
			for(int row=1;row<=rows;row++) {
				sheet[row-1][col-1]= new EmptyCell();
			}
		}
	}
	@Override
	public String processCommand(String command)
	{
		//clear entire sheet
		//clear a particular cell
		String lowerCase = command.toLowerCase();
		if(lowerCase.indexOf("clear")!=-1 && lowerCase.indexOf("\"")==-1) {
			String[] toclear = command.split(" ");
			if(toclear.length!=1) {
				SpreadsheetLocation inspected = new SpreadsheetLocation(toclear[1].toUpperCase());
				sheet[inspected.getRow()][inspected.getCol()] = new EmptyCell();
			}
			else {
				for(int col=1;col<=columns;col++) {
					for(int row=1;row<=rows;row++) {
						sheet[row-1][col-1]= new EmptyCell();
					}
				}
			}
			return getGridText();
		}
		// assign string values
		else if(command.indexOf("=")!=-1) {
			String[] assign = command.split(" ",3);
			SpreadsheetLocation inspected = new SpreadsheetLocation(assign[0].toUpperCase());
			//text cell
			if(command.indexOf("\"")!=-1) {
				String[] noquotes = assign[2].split("\"",3);
				sheet[inspected.getRow()][inspected.getCol()] = new TextCell(noquotes[1]);
			}
			//formula cell
			else if(command.indexOf("(")!=-1) {
				sheet[inspected.getRow()][inspected.getCol()] = new FormulaCell(assign[2], this);
			}
			//percent cell
			else if(command.indexOf("%")!=-1) {
				sheet[inspected.getRow()][inspected.getCol()] = new PercentCell(assign[2]);
			}
			//value cell
			else {
				sheet[inspected.getRow()][inspected.getCol()] = new ValueCell(assign[2]);
			}
			return getGridText();
		}
		//sorting 
	//	else if(command.substring(0, 5).equalsIgnoreCase("sorta") || command.substring(0, 5).equalsIgnoreCase("sortd")) {
			
	//	}
		//cell inspection 
		else {
			SpreadsheetLocation inspected = new SpreadsheetLocation(command);
			return sheet[inspected.getRow()][inspected.getCol()].fullCellText();
		}
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
		//String gridBody="";
		for(char i='A';i<='L';i++) {
			gridText+=String.format("%-10s",Character.toString(i))+"|";
		}
		gridText+="\n";
		for(int i=1;i<=rows;i++) {
		//	gridBody+=String.format("%11s",getCell( "|");
	//	}
			gridText+=String.format("%-2s",i+"")+" |";
			for(int j=1;j<=columns;j++) {
				//SpreadsheetLocation selected = new SpreadsheetLocation((Character.toString((char)(i+64))+Integer.toString(j)));
				gridText+=String.format("%-10s",sheet[i-1][j-1].abbreviatedCellText())+"|";
			}
			gridText+="\n";
		}
		// TODO Auto-generated method stub
		return gridText;
	}

}
