import java.util.*;
public class Hourglass {

	public static void main(String[] args) {
		boolean repeat=true;
		while(repeat==true) {
		Scanner userInput = new Scanner (System.in);
		System.out.println("How large do you want your hourglass? It must be an integer and the minimum value is 2.");
		int input = userInput.nextInt();
		if(input<2) {
			System.out.println("The size cannot be less than 2.\nTry again? (y/n)");
			if(userInput.next().equals("y")) {
				repeat = true;
			}else {
				repeat = false;
				userInput.close();
			}
		}else {
			HourglassCalculator.hourglassForm(input);
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