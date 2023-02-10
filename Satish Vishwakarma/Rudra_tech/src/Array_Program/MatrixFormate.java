package Array_Program;

public class MatrixFormate {

	public static void main(String[] args) {
		int arInt[][] = new int[3][3];
		arInt[0][0] = 10;
		arInt[0][1] = 20;
		arInt[0][2] = 30;
		arInt[1][0] = 40;
		arInt[1][1] = 50;
		arInt[1][2] = 60;
		arInt[2][0] = 70;
		arInt[2][1] = 80;
		arInt[2][2] = 90;
System.out.println("The MatrixFormate is :");
		for (int[] aObj : arInt) {
			for (int obj : aObj) {

				System.out.print(" "+obj);
			}
			System.out.println();
		}

	}

}
