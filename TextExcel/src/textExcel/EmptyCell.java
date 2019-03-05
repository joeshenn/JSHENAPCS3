/*@author Joe Shen 
 *@version March 4, 2019
 */
package textExcel;

public class EmptyCell implements Cell{
	public String abbreviatedCellText() {
		// from cell interface
		// text for spreadsheet cell display, must be exactly length 10
		return "output";
	}
	public String fullCellText() {
		// from cell interface
		// text for individual cell inspection, not truncated or padded
		return "output";
	}
	public EmptyCell() {
		
	}
}
