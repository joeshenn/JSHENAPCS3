/*@author Joe Shen 
 *@version March 4, 2019
 */
package textExcel;

public class EmptyCell implements Cell{
	private String emptyInput;
	public EmptyCell() {
		emptyInput ="";
	}
	public String abbreviatedCellText() {
		// from cell interface
		// text for spreadsheet cell display, must be exactly length 10
		return (emptyInput+"          ").substring(0,10);
	}
	public String fullCellText() {
		// from cell interface
		// text for individual cell inspection, not truncated or padded
		return emptyInput;
	}
}
