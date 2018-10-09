/* This class receives user input detailing the coefficients of a quadratic equation and outputs a 
 * description of the graph which is generated from Quadratic
 * @author Joe Shen
 * @version 10/2/2018
 */
import java.util.*;
public class QuadraticClient {
	//the main method prompts the user for the coefficients and calls the method quadrDescriber from
	//the class Quadratic to output an answer. 
	public static void main(String[] args) {
		boolean repeat=true;
		while(repeat==true) {
		Scanner userInput = new Scanner (System.in);
		System.out.println("Please provide the coefficients of a quadratic equation in standard form" );
		System.out.print("a: ");
		double a = userInput.nextDouble();
		System.out.print("b: ");
		double b = userInput.nextDouble();
		System.out.print("c: ");
		double c = userInput.nextDouble();
		if(a==0) {
			System.out.println("The coefficient \"a\"cannot equal 0.\nTry again? (y/n)");
			if(userInput.next().equals("y")) {
				repeat = true;
			}else {
				repeat = false;
				userInput.close();
			}
		}else {
			System.out.println(Quadratic.quadrDescriber(a, b, c));
			System.out.println("Would you like to try again?(y/n)");
			if(userInput.next().equals("y")) {
				repeat = true;
			}else {
				repeat = false;
				userInput.close();
			}
		}
	}
}
}
