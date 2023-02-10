package foorloop;

import java.util.Scanner;

public class Signal_Light {
	
	public static void main(String[] args) {
		String R_Y_G= "";
		Scanner sc = new Scanner (System.in);
		do {
			System.out.println("Please Enter Your Signal (R_G_Y) ");
			  String Signal = sc.nextLine();
			  if(Signal.equalsIgnoreCase("R"))System.out.println("Red Signal");
			  else if(Signal.equalsIgnoreCase("G"))System.out.println("Green Signal");
			  else if(Signal.equalsIgnoreCase("Y"))System.out.println("Yellow Signal");
			  else System.out.println("You have enter wrong digit");
			  System.out.println("Do you want to enter another Signal? (Y/N)");	
			  R_Y_G=sc.nextLine();		
	}while(R_Y_G.contains("yes"));
		if (R_Y_G.contains("no")) {
		System.out.println("Thank you");}
		else {
			System.out.println("you have entered invalid condition");
		}
	}

}
