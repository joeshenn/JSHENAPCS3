/* This class receives the co-efficients of a quadratic equation in standard form and 
 * does all calculations necessary to describe the direction the graph opens, the location of its vertex,
 * and its intercepts 
 * @author Joe Shen	
 * @version 10/2/2018
 */
public class Quadratic {
	public static double discriminant(double a, double b, double c) {
		return (b*b)-(4*a*c);
	}
	public static double min(double num1, double num2) {
		if(num1 <= num2) {
			return num1;
		}else {
			return num2;
		}
	}
	public static double max(double num1, double num2) {
		if(num1 >= num2) {
			return num1;
		}else {
			return num2;
		}
	}
	public static double absValue(double num) {
		if(num >= 0) {
			return num;
		}
		else {
			return num*-1;
		}
	}
	public static double round2(double num1) {
		int thousandTimes = (int) (num1 * 1000);
		int hundredTimes = (int)(num1*100);
		if(num1>0) {
		if(thousandTimes%10 >=5) {
			return (double)(hundredTimes+1)/100.0;
		}else {
			return (double)(hundredTimes/100.0);
		}
		}
		else if(num1==0) {
			return 0;
		}
		else {
			if(absValue(thousandTimes)%10 >=5) {
				return (double)(hundredTimes-1)/100.0;
			}else {
				return (double)(hundredTimes/100.0);
			}
			
		}
			
		}
public static double sqrt(double num) {
		if(num<0) {
			throw new IllegalArgumentException("negative numbers are not accepted");
		}
		else {
		double answer1=10;
		while(absValue((answer1*answer1)-num)>=0.005) {
			answer1 =(0.5)*((num/answer1)+answer1);
	}
		
		return round2(answer1);
			}
}
public static String quadForm(double a, double b, double c) {
	double discrim= discriminant(a, b, c);
	if(discrim<0) {
		return "There are no real roots.";
	}else if(discrim==0) {
		double singleRoot= round2((-1.0*b)/(2.0*a));
		return "There is one x intercept at the point ("+singleRoot+",0)";
	}else {
		double root1 = ((-1.0*b)+sqrt(discrim))/(2.0*a);
		double root2 = ((-1.0*b)-sqrt(discrim))/(2.0*a);
		return "There are two x intercepts at "+"("+ min(root1, root2)+",0) and (" + max(root1, root2)+",0)";
	}
}
	public static String quadrDescriber(double a, double b, double c) {
		String opening;
		double xvert = (-1*b)/(2*a);
		double yvert = (a*xvert*xvert) + (b*xvert) + c;
		String vertex= "The vertex is located at the point("+xvert+","+yvert+".";
		String intercepts = quadForm(a, b, c) ;
		if(a>0) {
			opening="The graph opens upwards.";
		}
		else {
			opening="The graph opens downwards.";
		}
		return opening +"\n"+ vertex +"\n"+ intercepts;
	}
}

