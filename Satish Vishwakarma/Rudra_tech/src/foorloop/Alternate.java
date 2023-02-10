package foorloop;

public class Alternate {
public static void main(String[] args) {
	String nae = "Satish";
	for (int i = 0 ; i <nae.length();i++) {
		char s = 	nae.charAt(i);
		if (i%2!=0) {
			System.out.print(s);
		}
	}
}
}
