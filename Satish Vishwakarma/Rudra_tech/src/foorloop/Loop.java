 package foorloop;

import java.util.Iterator;

public class Loop {

	public static void main(String[] a) {
	
		m1();
	//	m2();

		
		int i, j;
		for (i =1; i<=5; i++) {
			for (j =5; j>i; j--) {
				System.out.print(" ");
			}
			for(int k =0; k<i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();

		
		for (i =5; i>=1; i--) {
			for (j =5; j>i; j--) {
				System.out.print(" ");
			}
			for(int k =0; k<i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
//		public static void m2() {
//			
//		
//		
//		for(int i=0; i<5; i++) {
//           for(int j=0; j<=i; j++) {
//        	   System.out.print(j);
//	       }
//          System.out.println();
//		}
//		for(int i=5; i>=0; i--) {
//	           for(int j=i; j>0; j--) {
//	        	   System.out.print(j);
//	        	   
//		}		
//	System.out.println();
//		}	
//		}
     	public static void m1() { 
		for(int i=0; i<5; i++) {
	           for(int j=0; j<=i; j++) {
	        	   System.out.print("*");
		       }
	          System.out.println();
			}
		for(int m=1; m<10; m++) {
     		System.out.print("*"+"*");
		}
			for(int i=5; i>0; i--) {
	           for(int j=i; j>=1; j--) {
	        	   System.out.print("*");
		       }
	          System.out.println();
			}
     	
	}		
	
}