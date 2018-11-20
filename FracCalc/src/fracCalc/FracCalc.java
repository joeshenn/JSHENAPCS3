package fracCalc;
import java.util.*;
public class FracCalc {

    public static void main(String[] args) {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	Scanner userInput = new Scanner(System.in);
    	boolean repeat = true;
    	while(repeat==true) {
    		System.out.println("Please enter an expression to be calculated. Type \"quit\" to stop");
    		String expression = userInput.nextLine();
    		if(expression.equals("quit") == true) {
    			repeat = false;
    			break;
    		} else {
    		System.out.println(produceAnswer(expression));
    		}
    	}
    	userInput.close();

    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input){ 
        // TODO: Implement this function to produce the solution to the input
    	int whole;
    	int numerator =0;
    	int denominator=1;
    	String[] rawInput = input.split(" ");
    	String operand1 = new String(rawInput[0].toString());
    	if(operand1.indexOf("/") == -1){
    		operand1 = intToImpFrac(operand1);
    	}
    	else if(operand1.indexOf("_") != -1) {
    		operand1 = toImproperFrac(operand1);
    	}
    	String operand2 = new String(rawInput[2].toString());
    	if(operand2.indexOf("/") == -1){
    		operand1 = intToImpFrac(operand2);
    	}
    	else if(operand1.indexOf("_") != -1) {
    		operand2 = toImproperFrac(operand2);
    	}
    	String impropExpression = new String(operand1+"/"+operand2);
    	String [] finalExpressionSplit = impropExpression.split("/");
    	int [] finalExpressionInt = new int[4];
        return ("whole:"+whole+" numerator:"+numerator+" denominator:"+denominator);
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
