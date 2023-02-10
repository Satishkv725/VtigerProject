package foorloop;
import java.util.Scanner;
public class Even_Odd {

	public static void main(String[] args) {

		Scanner sc = new Scanner (System.in);
		//Scanner sc1 = new Scanner (System.in);
		String Y_N= "";
		do {
			System.out.println("Please Enter a No.");
			int x =sc.nextInt();
			if (x%2==0) {
				System.out.println("Even No.");
			}
			else  
				System.out.println("Odd No.");



			System.out.println("Do you want to enter another No. ? (Y/N)");	
			Y_N=sc.next();
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
