package textExcel;

public class FormulaCell extends RealCell {
	public FormulaCell(String input) {
		super(input);
	}
	public double getDoubleValue(){
		String[] longInput = (super.fullCellText()).split(" ");
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
