package foorloop;

import java.util.Scanner;

public class Driving_License {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		Scanner sc1 = new Scanner (System.in); 
		String Y_N= "";
		do {
			System.out.println("Please Enter Your Year... ");
			int Year=sc.nextInt();
			int age=2022-Year;
			if (age<18) {
				System.out.println("You are not eligibile for driving_Lisence. ");
				System.out.println("Please check your age par gov. creteria");

			}
			else  if (age>18 && age<=75) {
				System.out.println("You are eligibile for driving_Lisence ");}	

			else if(age>75 && age<120) {
				System.out.println("You are too old senior citizen.");
				System.out.println(" you have not go for driving_Lisence ");

			}
			System.out.println("Do you want to enter another person ? (Y/N)");	
			Y_N=sc1.nextLine();	  

		}while(Y_N.contains("yes"));
		if(Y_N.contains("no")) 
		{
			System.out.println("thanku");
		}
		else
		{
			System.out.println("try letter");
		}




	}

}
