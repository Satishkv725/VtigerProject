package java_java_method;

public class Varargs {

	public static void main(String[] args) {
		m1(10);
		m1(10,20,30,40,50);
		
		
	}
		public static void m1(int... x) {
			for (int i : x) {
				System.out.println(i);
			}
		

	
		}
}
