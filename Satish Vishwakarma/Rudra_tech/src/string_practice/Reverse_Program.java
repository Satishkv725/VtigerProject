package string_practice;

public class Reverse_Program {

	public static void main(String[] args) {
		
		String word ="I am the king of this jungle";
		
		String [] wordObj=word.split(" ");
		
		for (int i = 0; i < wordObj.length; i++) {
		char [] obj=	wordObj[i].toCharArray();
		for (int j = obj.length-1; j >=0; j--) {
			System.out.print(obj[j]);
		}
		
		System.out.print(" ");
		
		}
		
	}

}
 