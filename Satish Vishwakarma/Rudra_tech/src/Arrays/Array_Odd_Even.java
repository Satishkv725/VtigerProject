package Arrays;

public class Array_Odd_Even {

	public static void main(String[] args) {
		
		String std[] = new String[4];
		std[0]="I";
		std[1]="Love";
		std[2]="My";
		std[3]="India";
		
		for (int i = 0; i < std.length; i++) {
			if(i % 2==0) {
				System.out.println(std[i]+"");
			}
			if(i % 2 !=0) {
		 int I = std[i].length();
		 String s="";
		 for (int j = I-1; j>=0; j--) {
			 char ch =std[i].charAt(j);
			 s=s+ch;
		 }
			System.out.println(s+" ");
			}
			
		}
		
		
		
	}
		
	}


