package foorloop;

public class Forloop {

	public static void main(String[] args) {

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

}


