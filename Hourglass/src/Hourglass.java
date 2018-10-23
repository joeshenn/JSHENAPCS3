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
			hourglassForm(input);
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
	public static void hourglassForm(int a) {
		int b=a-1;
		int a2=2*a;
		System.out.print("|");
		for(int i=0; i<a2; i++) {
			System.out.print("\"");
		}
		System.out.println("|");
		for(int i=b;i>=1;i--) {
			for(int j=0;j<a-i;j++) {
				System.out.print(" ");
			}
			System.out.print("\\");
			for(int k=0;k<2*i;k++) {
				System.out.print(":");
			}
			System.out.print("/\n");
			}
		for(int z=0;z<a;z++) {
			System.out.print(" ");
		}
		System.out.println("||");
		for(int i=1;i<=b;i++) {
			for(int j=0;j<a-i;j++) {
				System.out.print(" ");
			}
			System.out.print("/");
			for(int k=0;k<2*i;k++) {
				System.out.print(":");
			}
			System.out.print("\\\n");
			}
		System.out.print("|");
		for(int i=0; i<a2; i++) {
			System.out.print("\"");
		}
		System.out.println("|");
		}
}