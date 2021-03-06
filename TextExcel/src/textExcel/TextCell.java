package textExcel;

public class TextCell implements Cell, Comparable<TextCell> {
	private String text;
	public TextCell(String input){
		text = input;
	}
	public String abbreviatedCellText() {
		// text for spreadsheet cell display, must be exactly length 10
		//return String.format("%-10s", text);
		return (text +"          ").substring(0, 10);
	}
	public String fullCellText() {
		// text for individual cell inspection, not truncated or padded
		return "\""+text+"\"";
	}
	public int compareTo(TextCell comparedText) {
		for ( int i = 0; i < this.fullCellText().length(); i++) {
			if(this.fullCellText().toUpperCase().charAt(i) < comparedText.fullCellText().toUpperCase().charAt(i) )
				return -1;
			if(this.fullCellText().toUpperCase().charAt(i) > comparedText.fullCellText().toUpperCase().charAt(i) )
				return 1;
		}
		return 0;
	}

}
