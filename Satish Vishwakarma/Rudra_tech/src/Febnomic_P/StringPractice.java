package Febnomic_P;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class StringPractice {
	public static void main(String[] args) {
		m1();
	}
	public static void lala() {
		
	
		StringPractice obj = new StringPractice();
		obj.m1();
		
		
		String word = "Hey I am Roshan";
		String[] split = word.split(" ");
		for (int i = 0; i < split.length; i++) {
			char[] a = split[i].toCharArray();
			for (int j = split[i].length() - 1; j >= 0; j--) {
				System.out.print(a[j]);
			}
			System.out.print(" ");
		}
	}

	static void m1() {
		
		String name="Hay I am Satish";
		String []sp = name.split("I");
for (int i = 0; i < sp.length; i++) {
	String split=sp[i];
	for(int j = split.length()-1;j>=0;j--) {
		System.out.print(split.charAt(j));
	}
   }
  }
}
  