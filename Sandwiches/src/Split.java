import java.util.Arrays;
public class Split {
		 public static void main(String[] args) {

// Your task Part 0
		//String.split();

		//It's a method that acts on a string, <StringName>.split(<String sp>);

		//Where sp is the string where the string splits

		//And it returns an array

		// Example: "I like apples!".split(" ");
			System.out.println(Arrays.toString("I like apples!".split(" ")));
		// it will split at spaces and return an array of ["I","like","apples!"]
			System.out.println(Arrays.toString("I really like really red apples".split("really")));
		// Example 2: "I really like really red apples"split("really")

		// it will split at the word "really" and return an array of ["I "," like ","red apples!"]

		//play around with String.split!

		//What happens if you "I reallyreally likeapples".split("really") ?

		//Your task Part 1:
			String[] sandwich = "applesbreadpineapplesbreadlettustomatobaconmayohambreadcheesebreadchips".split("bread");
			String contents = new String("applesbreadpineapplesbreadlettustomatobaconmayohambreadcheesebreadchips");
			int counter = 0;
			int breads = 0;
			String middle= new String("");
			while(counter<(contents.length())){
				if(contents.indexOf("bread", counter)!= -1) {
					counter= contents.indexOf("bread", counter)+1;
					breads++;
				}
				else {
					break;
				}
			}
			for(int i=1;i<=breads-1;i++) {
				middle += sandwich[i];
			}
			System.out.println(breads);
			System.out.println(middle);
		/*Write a method that take in a string like

		* "applespineapplesbreadlettustomatobaconmayohambreadcheese"

		* describing a sandwich.

		* Use String.split to split up the sandwich by the word "bread" and return what's in the middle of
			
		* the sandwich and ignores what's on the outside

		* What if it's a fancy sandwich with multiple pieces of bread?

		*/

		//Your task pt 2:

		/*Write a method that take in a string like

		* "apples pineapples bread lettus tomato bacon mayo ham bread cheese"

		* describing a sandwich

		* use String.split to split up the sandwich at the spaces, " ", and return what's in the middle of

		* the sandwich and ignores what's on the outside.

		* Again, what if it's a fancy sandwich with multiple pieces of bread?

		*/
			String[] sandwichSpace = "apples pineapples bread lettus tomato bacon mayo ham bread cheese".split(" ");
			String contentsSpace = new String("apples pineapples bread lettus tomato bacon mayo ham bread cheese");
			int counter2 = 0;
			int breads2 = 0;
			String middle2= new String("");
			while(counter2<(contentsSpace.length())){
				if(contentsSpace.indexOf("bread", counter2)!= -1) {
					counter2= contentsSpace.indexOf("bread", counter2)+1;
					breads2++;
				}
				else {
					break;
				}
			}
			for(int i=1;i<=breads2-1;i++) {
				middle2 += sandwichSpace[i];
			}
			System.out.println(breads2);
			System.out.println(middle2);
		 }

		}
