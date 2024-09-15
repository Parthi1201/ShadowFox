import java.util.Scanner;

public class Calculator {
	
	public static double basicoperation(double n1,double n2,char operator) {
		switch(operator) {
		case '+':
			return n1+n2;
		case '-':
			return n1-n2;
		case '*':
			return n1*n2;
		case '/':
			if(n2!=0) {
				return n1/n2;
			}
			else {
				System.out.println("Error! Division by zero.");
				return Double.NaN;
			}
		default:
			System.out.println("Invalid operator.");
			return Double.NaN;
		
		}
	}
	
	public static double scioperation(double num1,String operation) {
		switch(operation) {
		case "sqrt":
			return Math.sqrt(num1);
		case "pow":
			Scanner sc = new Scanner(System.in);
            System.out.println("Enter the exponent:");
            double exp = sc.nextDouble();
            return Math.pow(num1, exp);
        default:
        	System.out.println("Invalid scientific operation.");
        	return Double.NaN;
		}
	}
	
	public static double temperatureConversion(double celsius) {
		return (celsius * 9 / 5) + 32;
	}
	
	public static double currencyConversion(double usd) {
        return usd * 83.88;
    }

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		boolean work=true;
		
		while(work) {
		System.out.println("Enhanced Console-based Calculator");
		System.out.println("Menu:");
		System.out.println("1.Arithmetic Operations (Addition, Subtraction, Multiplication, Division)");
		System.out.println("2.Scientific Calculations (Square root, Exponentiation)");
		System.out.println("3.Temperature Conversion (Celsius to Fahrenheit)");
		System.out.println("4.Currency Conversion (USD to INR)");
		System.out.println("5.Exit");
		System.out.println("Select an Operation to perform:");
		int option=sc.nextInt();
			
		switch(option) {
			case 1:
				System.out.println("Arithmetic Operation");
				System.out.println("Enter First Number:");
				double n1=sc.nextDouble();
				System.out.println("Enter Operator(+,-,*,/)");
				char operator=sc.next().charAt(0);
				System.out.println("Enter Second Number:");
				double n2=sc.nextDouble();
				double result=basicoperation(n1,n2,operator);
				System.out.println(result);
				break;
			case 2:
				System.out.println("Scientific Calculation");
				System.out.println("Enter Number:");
				double num1=sc.nextDouble();
				System.out.println("Enter operation (sqrt for square root, pow for exponentiation):");
				String operation=sc.next();
				double result2=scioperation(num1,operation);
				if (!Double.isNaN(result2)) {
                    System.out.println("Result: " + result2);
                }
				break;
			case 3:
				System.out.println("Temperature Conversion");
				System.out.println("Enter temperature in Celsius:");
                double celsius = sc.nextDouble();
                double fahrenheit = temperatureConversion(celsius);
                System.out.println(celsius + "°C = " + fahrenheit + "°F");
                break;
			case 4:
				System.out.println("Currency Conversion");
				System.out.println("Enter amount in USD:");
                double usd = sc.nextDouble();
                double inr = currencyConversion(usd);
                System.out.println(usd + " USD = " + inr + " INR");
                break;
			case 5:
				System.out.println("Exiting... Thank you for using the calculator!");
                work = false;
                break;
            default:
            	System.out.println("Invalid choice! Please select a valid option.");
			}
		}
		sc.close();
	}

}
