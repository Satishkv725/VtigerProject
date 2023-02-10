package Array_Program;

import java.util.Iterator;

public class MatrixTranspose {

	public static void main(String[] args) {
		
		int b[][]=new int[3][3];
		
		int a[][]= {
				{1,2,3},
				{4,5,6},
				{7,8,9}  };
		for (int i = 0; i < a.length; i++) 		
			{
		for (int j = 0; j < a.length; j++) 
		{
			b[i][j]=a[j][i];
		}
		}
		System.out.println("The transpose of matrices is : ");
		for (int i = 0; i < a.length; i++) {
		for (int j = 0; j < a.length; j++) {
			System.out.print("  "+b[i][j]);
		}	
		System.out.println();
		}
	}
	}


