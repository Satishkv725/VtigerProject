package department;
public class Work {
	static Work sc;
		
	public static Work m1() {
		sc = new Work();
		return sc; 
	}
	int i =5;
	public static String m2() {
		System.out.println(" hi i am method 2");
		return "hi";   
	}
	public static void main(String[] args) {
	
		
		Work sc1=m1();	
	System.out.println(sc1.m2());
	}

}
