package Exception;



public class P extends string_practice.String_Class {

	   public P m1 () {
		   System.out.println("hellow"); 
		   return new P();
	   }
	
	public static void main(String[] args) {
	P p=new P();
	System.out.println(p.m1());
	p=null;
	System.out.println(p.m1());

	}

}
