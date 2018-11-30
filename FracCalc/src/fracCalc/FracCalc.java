package fracCalc;
import java.util.*;
public class FracCalc {

    public static void main(String[] args) {
    	Scanner userInput = new Scanner(System.in);
    	boolean repeat = true;
    	while(repeat==true) {
    		System.out.println("Please enter an expression to be calculated. Type \"quit\" to stop");
    		String expression = userInput.nextLine();
    		if(expression.equals("quit") == true) {
    			repeat = false;
    			break;
    		} else {
    			String[] longInput = expression.split(" ");
        		for(int i=0;i<=longInput.length-2;i+=2) {
        			longInput[i+2] = produceAnswer(longInput[i].toString()+" "+longInput[i+1].toString()+" "+longInput[i+2].toString());
        		}
        		System.out.println(longInput[longInput.length-1]);
    		}
    	}
    	userInput.close();
    }
    public static String produceAnswer(String input) {
    	String[] longInput = input.split(" ");
		for(int i=0;i<=longInput.length-2;i+=2) {
			longInput[i+2] = Calculate(longInput[i].toString()+" "+longInput[i+1].toString()+" "+longInput[i+2].toString());
		}
		return longInput[longInput.length-1];
    }
    public static String Calculate(String input){ 
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
    	else if (operator.equals("/")) {
    		answerNum = (finalExpInt[0]*finalExpInt[3]);
    		answerDenom = (finalExpInt[1]*finalExpInt[2]);
    		 gcf = gcf(answerNum,answerDenom);
    		answerNum = answerNum/gcf;
    		answerDenom = answerDenom/gcf;
    	}
    	else {
    		return "Input is an invalid format";
    	}
        return (toMixedNum(answerNum,answerDenom));
    }
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
    	else if((numerator/denominator==0 && denominator>0 && numerator>0)||(numerator/denominator==0 && denominator>0 && numerator<0)) {
    		return numerator+"/"+denominator;
    	}
    	else if(numerator/denominator==0 && denominator<0 && numerator>0 || (numerator/denominator==0 && denominator<0 && numerator<0)) {
    		return (numerator*-1)+"/"+denominator*-1;
    	}
    	else {
    	if(Math.abs(numerator%denominator)==0) {
    		return numerator/denominator+"";
    	}
		return (numerator/denominator)+"_"+Math.abs(numerator%denominator)+"/"+Math.abs(denominator);
    	}
	}
    public static int max(int num1, int num2) {
		if(num1 >= num2) 
			return num1;
			return num2;
	}
    public static int min(int num1, int num2) {
		if(num1 <= num2) 
			return num1;
			return num2;
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
}
