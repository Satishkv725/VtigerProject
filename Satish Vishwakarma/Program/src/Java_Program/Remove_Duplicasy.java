package Java_Program;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.xml.crypto.Data;

public class Remove_Duplicasy {

	public static void main(String[] args) {

		Remove_Duplicasy obj = new Remove_Duplicasy();
		// obj.m1();
		// obj.m2();
		obj.m3();
	}

	void m3() {
		String word = "Hi I am Satish Kumar Vishwakarma".toLowerCase();
		Set<Character> cData = new LinkedHashSet<Character>();

		for (int i = 0; i < word.length(); i++) {
			char obj = word.charAt(i);
			cData.add(obj);
		}
		for (Character charObj : cData) {
			System.out.print(charObj);
		}

	}

	void m2() {

		String word = "Hi I am Satish Kumar Vishwakarma".toLowerCase();
		for (char i = 'a'; i <= 'z'; i++) {
			int count = 0;
			for (int j = 0; j < word.length(); j++) {
				if (i == word.charAt(j)) {
					count++;
				}
			}
			if (count > 1) {
				System.out.println(i);
			}
		}

	}

	void m1() {
		String word = "Hi I am Satish Vishwakarma".toLowerCase();
		String[] name = word.split(" ");
		String temp = "";

		for (int i = 0; i < name.length; i++) {
			temp += name[i];
		}
		char arr[] = temp.toCharArray();
		int count = 1;
		System.out.println(" " + temp + " ");
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					count++;
				}
			}
			if (count == 2) {
				System.out.println(arr[i]);
			}
			count = 1;
		}

	}

}
