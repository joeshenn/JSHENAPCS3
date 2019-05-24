package textExcel;
import java.util.*;
// Update this file with your own code.

public class Spreadsheet implements Grid{
private Cell[][] sheet;
private int rows;
private int columns;
private ArrayList<TextCell> orderedCells;
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
		//else if(command.substring(0, 5).equalsIgnoreCase("sorta") || command.substring(0, 5).equalsIgnoreCase("sortd")) {
		else if (command.toLowerCase().contains("sorta") || command.toLowerCase().contains("sortd")) {
			sort(command);
			return getGridText();
		}
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
	public void sort ( String input) {
		String[] range = input.substring(6).split("-", 2);
		int count = 0;
		char startIndex = (range[0].toString().toUpperCase()).charAt(0);
		char endIndex = (range[1].toString().toUpperCase()).charAt(0);
		//System.out.println(startIndex + " " + endIndex);
		int lowerBound = Integer.parseInt((range[0].toString()).substring(1));
		int upperBound = Integer.parseInt((range[1].toString()).substring(1));
		//System.out.println(lowerBound + " "+ upperBound);
		//double numTerms = (upperBound-lowerBound+1)*(endIndex-startIndex+1);
	//	System.out.println(numTerms);
		SpreadsheetLocation typeCell = new SpreadsheetLocation(((char)startIndex)+""+lowerBound);
		if(this.getCell(typeCell) instanceof TextCell) {
		 orderedCells = new ArrayList<TextCell>();
		}
		else { //real cells
		 orderedCells = new ArrayList<TextCell>();
		}
		for(int j =startIndex; j<=endIndex;j++) { //iterates through the character portion of the cell reference
			for(int k = lowerBound; k<=upperBound;k++) {
				if(this.getCell(typeCell) instanceof TextCell) {
				SpreadsheetLocation refCell = new SpreadsheetLocation(((char)j)+""+k);
					if(j==startIndex && k==lowerBound) {
						orderedCells.add((TextCell)this.getCell(refCell));
						System.out.println(orderedCells.get(0).fullCellText());
					}
					else {
						if(((TextCell)this.getCell(refCell)).compareTo(orderedCells.get(0))==-1) { //lower bound
							orderedCells.add(0, (TextCell)this.getCell(refCell));
							System.out.println(orderedCells.get(0).fullCellText());
						}
						else if(((TextCell)this.getCell(refCell)).compareTo(orderedCells.get(0))==1) { //upper bound
							orderedCells.add((TextCell)this.getCell(refCell));
						}
						else {
							for(int i=1;i<orderedCells.size()-1;i++) {
								if(((TextCell)this.getCell(refCell)).compareTo(orderedCells.get(i+1))<=0 && ((TextCell)this.getCell(refCell)).compareTo(orderedCells.get(i-1))>=0) {
									orderedCells.add(i, (TextCell)this.getCell(refCell));
									break;
								}
							}
						}
					}
				}
				else { //the cells are real cells 
					
				}
			
			}
		}
		for(int k = lowerBound; k<=upperBound;k++) { //iterates through the integer portion of the cell reference
			for(int j =startIndex; j<=endIndex;j++){
				SpreadsheetLocation refCell = new SpreadsheetLocation(((char)j)+""+k);
				sheet[refCell.getRow()][refCell.getCol()] = orderedCells.get(count);
				count++;
			}
		}
			
	}

}
