package textExcel;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel
{

	public static void main(String[] args)
	{
		Scanner userInput = new Scanner(System.in);
    	boolean repeat = true;
    	while(repeat==true) {
    		System.out.println("Please enter an expression to be calculated. Type \"quit\" to stop");
    		String expression = userInput.nextLine();
    		if(expression.equals("quit") == true) {
    			repeat = false;
    			break;
    		} else {
    			
    		}
	}
}
}
