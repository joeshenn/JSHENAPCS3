package fracCalc;
import java.util.Scanner;
public class FracCalcMultiple {
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
    	String[] rawInput = input.split(" ");
    	String operator = new String(rawInput[1].toString());
    	String operand1 = new String(rawInput[0].toString());
    	if(operand1.indexOf("/") == -1){
    		operand1 = intToImpFrac(operand1);
    	}
    	else if(operand1.indexOf("_") != -1) {
    		operand1 = toImproperFrac(operand1);
    	}
    	String operand2 = new String(rawInput[2].toString());
    	if(operand2.indexOf("/") == -1){
    		operand2 = intToImpFrac(operand2);
    	}
    	else if(operand2.indexOf("_") != -1) {
    		operand2 = toImproperFrac(operand2);
    	}
    	String impropExpression = new String(operand1+"/"+operand2);
    	String [] finalExpressionSplit = impropExpression.split("/");
    	int [] finalExpInt = new int[4];
    	for(int i=0;i<4;i++) {
    		finalExpInt[i]=Integer.parseInt(finalExpressionSplit[i].toString());
    	}
    	int answerNum;
    	int answerDenom;
    	int gcf =1;
    	if (operator.equals("+")) {
    		answerNum = (finalExpInt[0]*finalExpInt[3])+(finalExpInt[2]*finalExpInt[1]);
    		answerDenom = (finalExpInt[1]*finalExpInt[3]);
    		 gcf = gcf(answerNum,answerDenom);
    		answerNum = answerNum/gcf;
    		answerDenom = answerDenom/gcf;
    	}
    	else if(operator.equals("-")) {
    		answerNum = (finalExpInt[0]*finalExpInt[3])-(finalExpInt[2]*finalExpInt[1]);
    		answerDenom = (finalExpInt[1]*finalExpInt[3]);
    	    gcf = gcf(answerNum,answerDenom);
    		answerNum = answerNum/gcf;
    		answerDenom = answerDenom/gcf;
    	}
    	else if (operator.equals("*")) {
    		answerNum = (finalExpInt[0]*finalExpInt[2]);
    		answerDenom = (finalExpInt[1]*finalExpInt[3]);
    		 gcf = gcf(answerNum,answerDenom);
    		answerNum = answerNum/gcf;
    		answerDenom = answerDenom/gcf;
    	}
    	else {
    		answerNum = (finalExpInt[0]*finalExpInt[3]);
    		answerDenom = (finalExpInt[1]*finalExpInt[2]);
    		 gcf = gcf(answerNum,answerDenom);
    		answerNum = answerNum/gcf;
    		answerDenom = answerDenom/gcf;
    	}
        return (toMixedNum(answerNum,answerDenom));
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    public static String intToImpFrac(String input) {
    	input = input +"/1";
    	return input;
    }
    public static String toImproperFrac(String input) {
    	String[] sa1 = input.split("_");
    	String[] sa2 = sa1[1].toString().split("/");
    	int intpart = Integer.parseInt(sa1[0].toString());
    	int fracnum = Integer.parseInt(sa2[0].toString());
    	int fracdenom = Integer.parseInt(sa2[1].toString());
    	if(intpart>=0) {
    	sa2[0] = ((intpart*fracdenom)+fracnum)+"";
    	}
    	else {
    	sa2[0] = ((intpart*fracdenom)-fracnum)+"";
    	}
    	return sa2[0]+"/"+sa2[1];
    }
    public static String toMixedNum(int numerator, int denominator) {
    	if(numerator == denominator) {
    		return "1";
    	}
    	else if(numerator ==0) {
    		return "0";
    	}
    	else if(denominator ==0) {
    		return "can't divide by zero";
    	}
    	else if(numerator/denominator==0 && denominator>0 && numerator>0) {
    		return numerator+"/"+denominator;
    	}
    	else if(numerator/denominator==0 && denominator<0 && numerator>0) {
    		return (numerator*-1)+"/"+denominator*-1;
    	}
    	else if(numerator/denominator==0 && denominator<0 && numerator<0) {
    		return numerator*-1+"/"+denominator*-1;
    	}
    	else if(numerator/denominator==0 && denominator>0 && numerator<0) {
    		return numerator+"/"+denominator;
    	}
    	else {
    	if(absValue(numerator%denominator)==0) {
    		return numerator/denominator+"";
    	}
    	else if(denominator==1) {
    		return numerator+"";
    	}
    	else if(denominator==-1) {
    		return numerator*-1+"";
    	}
		return (numerator/denominator)+"_"+absValue(numerator%denominator)+"/"+absValue(denominator);
    	}
	}
    public static int max(int num1, int num2) {
		if(num1 >= num2) {
			return num1;
		}else {
			return num2;
		}
	}
    public static int min(int num1, int num2) {
		if(num1 <= num2) {
			return num1;
		}else {
			return num2;
		}
	}
    public static int gcf(int num1, int num2) {
		int smaller = min(num1, num2);
		int bigger = (int) max(num1, num2);
		int count = smaller;
		if(count>0) {
			while(count>1) {
				if(bigger%count==0 && smaller%count==0) {
					return count;
			}
		else {
			count--;
			}
		}
		} else {
			while(count<-1) {
				if(bigger%count==0 && smaller%count==0) {
					return count;
			}
		else {
			count++;
			}
			}
		}
		if(count==0) {
			return 1;
		}
		return count;
	} 
	public static int absValue(int num) {
		if(num >= 0) {
			return num;
		}
		else {
			return num*-1;
		}
	}
}
