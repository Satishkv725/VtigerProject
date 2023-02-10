package java_java_method;

import java.util.Scanner;

public class Calculator {

	
	public static void main(String[] args) {
	    String operator;
		Double number1;
		Double number2;
		Double result;
		
		Scanner sc = new Scanner(System.in);

		String Y_N= "";
		do {

		System.out.println("Enter first number");
		number1 = sc.nextDouble();

		System.out.println("Choose an operator: ");
		 operator = sc.next();
		
		System.out.println("Enter second number");
		number2 = sc.nextDouble();

		switch (operator) {
		case "+":
			result = number1 + number2;
			System.out.println("Total = "+ result);
			break;

		case "-":
			result = number1 - number2;
			System.out.println( "Total = "+ result);
			break;
			
		case "*":
			result = number1 * number2;
			System.out.println("Total = "+ result);
			break;

		case "/":
			result = number1 / number2;
			System.out.println( "Total = "+ result);
			break;

		default:
			System.out.println("Invalid operator");
			break;
		}
		System.out.println("Do you want to enter another Number ? (Y/N)");	
		Y_N=sc.next();	
		}while(Y_N.contains("yes"));
		if(Y_N.contains("no")) 
		{
		System.out.println("thanku");
		}else
		{
			System.out.println("try Again");
		}
		
			
	}

}
