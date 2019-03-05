package textExcel;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel
{

	public static void main(String[] args)
	{
		Spreadsheet newSheet = new Spreadsheet();
		Scanner userInput = new Scanner(System.in);
    	boolean repeat = true;
    	while(repeat==true) {
    		System.out.println("Please enter a command. Type \"quit\" to stop");
    		String expression = userInput.nextLine();
    		if(expression.equals("quit") == true) {
    			repeat = false;
    			break;
    		} else {
    			System.out.println(newSheet.processCommand(expression));
    		}
    	
	}
    	userInput.close();
}
}
