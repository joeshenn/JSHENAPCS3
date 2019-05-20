package textExcel;

public class RealCell implements Cell, Comparable <RealCell> {
	private String vinput;
	public RealCell(String input) {
		vinput = input;
		/*//value input
		if(pinput == 0.0 && finput.length()==0) {
			sinput = vinput+"";
			dvalue = vinput;
		}
		//percent input
		else if(vinput==0.0 && finput.length()==0) {
			sinput = pinput*0.01+"";
			dvalue = pinput*.01;
		}
		//formula input
		else {
			sinput = finput;
			dvalue = 0.0; 
		} */
	}
	public String abbreviatedCellText() {
		return (vinput +"          ").substring(0, 10);
		// text for spreadsheet cell display, must be exactly length 10
	}
	
	public String fullCellText() {
		// text for individual cell inspection, not truncated or padded
		return vinput;
	}
	public double getDoubleValue(){
		return Double.parseDouble(vinput);
	}
	public int compareTo(RealCell comparedValue) {
		if(this.getDoubleValue() < comparedValue.getDoubleValue()) {
			return -1;
		}
		else if(this.getDoubleValue() == comparedValue.getDoubleValue()) {
			return 0;
		}
		else { //this cell's value is greater than that of cell it is being compared to
			return 1;
		}
	}
}
