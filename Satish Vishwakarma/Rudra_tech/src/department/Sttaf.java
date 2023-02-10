package department;

public class Sttaf {

	public static void main(String[] args) {
		
		aditional(55, 60);	
		subtract(155, 70);
		multiply(25, 40);
		division(555, 50);						
		squareMethod(12, 10);
		
		int c=sam(22,55);
		System.out.println(c);
		
	}	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public static int sam(int a, int b){
	
	int c =a+b;
	
     System.out.println(c);
     
	return c;
	
//	System.out.println(c); do not call return c bcoz value transfer other method
	}
	
	public static void squareMethod(int a, int b){
	
	int c =a*a+b*b+2*a*b;
	
	System.out.println(c);
	}	
			
	public static void aditional(int a, int b){
	
	int c =a+b;
	
	System.out.println(c);
	}
	public static void subtract(int x, int y) {
		int z=x-y;
		System.out.println(z);
	}
	
	public static void multiply(int l, int m) {
		int n=l*m;
		System.out.println(n);
	}
	public static void division(int o, int p) {
		int q=o/p;
		System.out.println(q);
	}
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
