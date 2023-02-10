  package Arrays;

public class Arrays_Practice {

	public static void main(String[] args) {
//		name();
//		String  s = "I Love My India";
//		char c[] = s.toCharArray();
//		for (int i = c.length-1; i >0; i--) {
//			System.out.print(c[i]);	
//		}	
//		System.out.println();
//		
//		String std_Ind[] = { "I ", "Love ", "My ", "India " };
//		for (int i = std_Ind.length-1; i >=0; i--) {
//			System.out.print(std_Ind[i]);
//		}
//		System.out.println();
//	
		String std[] = new String[5];
		std[0]="ramesh";
		std[1]="suresh";
		std[2]="jignesh";
		std[3]="mohesh";
		std[4]="lokesh";
		

		
//		System.out.println(std.length);
//		System.out.println(std[2]);
		String stdd[] = new String[6];
		stdd[0]="ram";
		stdd[1]="sur";
		stdd[2]="jig";
		
		for (int i = 0; i <  std.length; i++) { 
		System.out.println("Hello "+std[i]);	
		
		std[i]=stdd[i];  
		
		}for (int i = 0; i < stdd.length; i++) {
			System.out.println(stdd[i]);
		}
	
	
//	public static void name() {
//		 String obj="I Love My India";
//		 
//		 String ob[]=obj.split(" ");
//		
//		for (int i = ob.length-1;i>=0 ;i--) {
//			System.out.print(ob[i]+"_");			
//		}
//		System.out.println();
	}
	
	
	
	
	
	
	
}
