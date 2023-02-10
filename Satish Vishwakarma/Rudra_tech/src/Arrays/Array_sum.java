package Arrays;

import java.util.Iterator;

public class Array_sum {

	public static void main(String[] args) {

		int a[] = { 3, 7, 9, 8 };
		int sum = 0;
		
//		for (int i = 0; i < a.length; i++) {
//			sum = sum + a[i];
//			System.out.println(sum);
		for (int j : a) {
			sum = sum +j;
			System.out.println(sum);
		}	
		}
//	}

}
  