package foorloop;
import java.util.Scanner;
public class Table {

	public static  void tableprint(int table) {
		for(int i=1; i<=10; i++) {
			System.out.println(table+"x"+i+"="+table*i);
		}
	}
	public static void main(String[] args) {
		int table;
		String Y_N= "";
		Scanner scr = new Scanner (System.in);
		Scanner scr1 = new Scanner (System.in);
		do {
			System.out.println("Please enter a number to print a table ");
			  
			table = scr.nextInt();
			tableprint(table);
		System.out.println("Do you wnat to another table? (Y/N)   ");	
		Y_N=scr.next();	
			
		}while(Y_N.contains("Y"));
		
		System.out.println("Thank you");
		
		
	} 

} 
