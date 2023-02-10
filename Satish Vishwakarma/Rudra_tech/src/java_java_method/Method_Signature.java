package java_java_method;

public class Method_Signature {
	
	public void m1(int i) {
		System.out.println("I am int");
	}
	
public void m1(double d , int i ) {
		System.out.println("i am integer");
	}
	
public void m1(String s) {
System.out.println("class");	
}

public static void main(String[] args) {
	Method_Signature obj=new Method_Signature();
	obj.m1("Rahul");
	obj.m1(2);
	obj.m1(2,20);
}

	

}
