package textExcel;

public class FormulaCell extends RealCell {
	public FormulaCell(String input) {
		super(input);
	}
	public double getDoubleValue(){
		String[] longInput = (super.fullCellText()).split(" ");
		Spreadsheet accessCell = new Spreadsheet();
		System.out.println(longInput[1]);
		if(longInput[1].equals("SUM") || longInput[1].equals("AVG")) {
			String[] range = longInput[2].split("-", 2);
			double sum = 0;
			char startIndex = (range[0].toString()).charAt(0);
			char endIndex = (range[1].toString()).charAt(0);
			System.out.println(startIndex + " " + endIndex);
			int lowerBound = Integer.parseInt((range[0].toString()).substring(1));
			int upperBound = Integer.parseInt((range[1].toString()).substring(1));
			System.out.println(lowerBound + " "+ upperBound);
			double numTerms = (upperBound-lowerBound+1)*(endIndex-startIndex+1);
			System.out.println(numTerms);
			for(int j =startIndex; j<=endIndex;j++) { //iterates through the character portion of the cell reference
				for(int k = lowerBound; k<=upperBound;k++) {
					//System.out.println(((char)j)+""+k);
					SpreadsheetLocation refCell = new SpreadsheetLocation(((char)j)+""+k);
					sum += ((RealCell) (accessCell.getCell(refCell))).getDoubleValue();
				}
			}
			if(longInput[1].equals("SUM")) {
				return sum;
			}
			else  {  //AVG
				return sum / numTerms;
			}
		} 
		for(int j=1;j<longInput.length;j++) {
			if(longInput[j].charAt(0) >= 65 && longInput[j].charAt(0) <= 76) {
				SpreadsheetLocation refCell = new SpreadsheetLocation(longInput[j].toString());
				System.out.println((accessCell.getCell(refCell)).abbreviatedCellText()+"");
				longInput[j] = ((RealCell) (accessCell.getCell(refCell))).getDoubleValue()+"";
				}
			}
		for(int i=1;i<longInput.length-2;i+=2) {
				longInput[i+2] = produceAnswer(longInput[i]+" "+longInput[i+1]+" "+longInput[i+2]);
			}
		return Double.parseDouble(longInput[longInput.length-2]);
	}
	public static String produceAnswer(String input) {
		String[] calculate = input.split(" ",3);
		if(calculate[1].equals("+")) {
			return (Double.parseDouble(calculate[0]) + Double.parseDouble(calculate[2]))+"";
		}
		else if(calculate[1].equals("-")) {
			return (Double.parseDouble(calculate[0]) - Double.parseDouble(calculate[2]))+"";
		}
		else if(calculate[1].equals("*")) {
			return (Double.parseDouble(calculate[0]) * Double.parseDouble(calculate[2]))+"";
		}
		else if(calculate[1].equals("/")) {
			return (Double.parseDouble(calculate[0]) / Double.parseDouble(calculate[2]))+"";
		}
		else {
			return "invalid operator";
		}
		
	}
	public String abbreviatedCellText() {
		return (getDoubleValue() +"          ").substring(0, 10);
		// text for spreadsheet cell display, must be exactly length 10
	}
}
