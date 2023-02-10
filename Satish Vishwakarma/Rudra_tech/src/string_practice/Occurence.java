package string_practice;

public class Occurence {

	public static void main(String[] args) {
		String word = "I am the King of This Jungle".toUpperCase();

		for (char at = 'A'; at <= 'Z'; at++) {
			int count = 0;
			for (int i = 0; i < word.length(); i++) {

				if (at == word.charAt(i)) {
				count++;
				}
			}
			if (count > 0) {
				System.out.println(at + "-:-" + count);
			}
		}
	}
}
