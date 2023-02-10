package string_practice;

public class String_Class {

	public static void main(String[] args) {
		
String s1 = "Hello";

String s2 = "Hello";

StringBuffer s3 = new StringBuffer("Hello");

StringBuilder s4 = new StringBuilder("Hello") ;

 

if (s1==s2) {
	System.out.println("Good");
}

if(s3.equals(s1)) {
	System.out.println("Good");
}
s3.append("hi"); 
System.out.println(s3);

s4.append("ram");
System.out.println(s4);


//String         its a immutable
//StringBuffer   its a mutable
//StringBuilder  its a mutable
//String threadSafe 
//== to check same address
//.equals to check same contains


	}

}

