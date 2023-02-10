package Palindrome;

public class Palindrome_Class_Practice {

	public static void main(String[] args) {
		int temp=printHappy(23);
		while(temp>9) {
			temp=printHappy(temp);
		}
		if(temp==1) {
			System.out.println("Happy Number");
		}
		else {
			System.out.println("Unhappy Number");
		}
		
		

	}

	private static int printHappy(int num) {
	int sum=0;
	while(num>0) {
		int r = num%10;
		sum+=r*r;
		num=num/10;
	}
		
		
		
		
		return sum;
	}

}
