package textExcel;

public class ValueCell extends RealCell {
	private String exactInput;
	public ValueCell(String input) {
		super(Double.parseDouble(input)+"");
		exactInput = input;
	}
	public String fullCellText() {
		// text for individual cell inspection, not truncated or padded
		return exactInput;
	}
}
