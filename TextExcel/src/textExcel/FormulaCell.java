package textExcel;

public class FormulaCell extends RealCell {
	public FormulaCell(String input) {
		super(input);
	}
	public double getDoubleValue(){
		String[] longInput = (super.fullCellText()).split(" ");
		for(int i=1;i<=longInput.length-2;i+=2) {
			longInput[i+2] = produceAnswer(longInput[i]+" "+longInput[i+1]+" "+longInput[i+2]);
	}
		//placeholder
		return 0.0;
	}
	public static String produceAnswer(String input) {
		//placeholder
		return "hi";
	}
}
