package textExcel;

public class RealCell implements Cell {
	private String sinput;
	private double dvalue;
	public RealCell(double vinput, double pinput, String finput) {
		if(pinput == 0.0 && finput.length()==0) {
			sinput = vinput+"";
			dvalue = vinput;
		}
		else if(vinput==0.0 && finput.length()==0) {
			sinput = pinput*0.01+"";
			dvalue = pinput*.01;
		}
		else {
			sinput = finput;
			dvalue = 0.0;
		}
	}
	public String abbreviatedCellText() {
		return "placeholder";
		// text for spreadsheet cell display, must be exactly length 10
	}
	
	public String fullCellText() {
		// text for individual cell inspection, not truncated or padded
		return "placeholder";
	}
	public double getDoubleValue(){
		return dvalue;
	}
}
