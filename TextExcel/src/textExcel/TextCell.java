package textExcel;

public class TextCell implements Cell {
	private String text;
	public TextCell(String input){
		text = input;
	}
	public String abbreviatedCellText() {
		// text for spreadsheet cell display, must be exactly length 10
		return String.format("%1.10s", text);
	}
	public String fullCellText() {
		// text for individual cell inspection, not truncated or padded
		return "\""+text+"\"";
	}

}
