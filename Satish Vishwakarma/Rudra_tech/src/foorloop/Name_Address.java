package foorloop;

import java.util.Scanner;

public class Name_Address {

	public static void main(String[] args) {
		String Y_N= "";
		Scanner sc = new Scanner (System.in);

		do {
			System.out.println("Please Enter Your Nmae...... ");
			String Name = sc.next(); 

			System.out.println("Please Enter Your Age......");
			if (sc.hasNextByte()) {
				String  Age= sc.next();
				if (Age.length()==3) 
					System.out.println("Please Enter Your Mobile......");
				String Mobile= sc.next();

				System.out.println("Please Enter Your City......");
				String City =sc.next();

				System.out.println("Your Name is "+ Name );
				System.out.println("Your Age is"+Age);
				System.out.println("Your Mobile is"+Mobile);
				System.out.println("Your City is"+City);

			}
			else System.out.println("only numeric didits are allowed");
			System.out.println("Do you want another details? (Y_N)");
			Y_N=sc.next();
		}while(Y_N.contains("Y"));if(Y_N.contains("N"))

		{
			System.out.println("Thank you");
		}else System.out.println(" wrong condition");
	}}
