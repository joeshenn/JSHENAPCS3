
public class EqualCalc {
	public static void main(String[] args) {
		double a = 0;
		double b = 10;
		for(int i=1;i<=9;i++) {
			a*=.85;
			a+=b*.45;
			b=10.0-a;
			System.out.println(a+" | "+b);
		}
	}
}
