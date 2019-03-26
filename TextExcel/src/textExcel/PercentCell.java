package textExcel;

public class PercentCell extends RealCell {
	public PercentCell(String input) {
		super(input);
	}
	public String abbreviatedCellText() {
		return ((int)(getDoubleValue()*100) +"%"+"          ").substring(0, 10);
		// text for spreadsheet cell display, must be exactly length 10
	}
	
	public String fullCellText() {
		// text for individual cell inspection, not truncated or padded
		return getDoubleValue()+"";
	}
	//fill in 
	public double getDoubleValue(){
		return Double.parseDouble((super.fullCellText().substring(0, super.fullCellText().length()-1)))/100;
	}
}
