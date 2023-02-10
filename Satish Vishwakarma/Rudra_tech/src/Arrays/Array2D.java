package Arrays;

public class Array2D {

	public static void main(String[] args) {

		Array2D arrObj= new Array2D();
		arrObj.ary();
		
		int arInt[][] = new int[3][3];
		arInt[0][0] = 1;
		arInt[0][1] = 2;
		arInt[0][2] = 3;
		arInt[1][0] = 4;
		arInt[1][1] = 5;
		arInt[1][2] = 6;
		arInt[2][0] = 7;
		arInt[2][1] = 8;
		arInt[2][2] = 9;

		for (int[] is : arInt) {
			for (int is2 : is) {

				System.out.print(is2);
			}
			System.out.println();
		}

	}
	
	void ary () {
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

		for (int[] aObj : arInt) {
			for (int obj : aObj) {

				System.out.print(obj);
			}
			System.out.println();
		}

	}

	}


