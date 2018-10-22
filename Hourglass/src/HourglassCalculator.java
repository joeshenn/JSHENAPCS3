
public class HourglassCalculator {

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


