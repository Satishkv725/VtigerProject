package Arrays;

public class Practice {

	public static void main(String[] args) {

		String arr[][] =

				      { { "Arnav", "Pramod", "Dinesh" },
						{ "Babli", "Rahat", "Hema" }, 
						{ "Babli1", "Rahat1", "Hema1" } };
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {

				System.out.println(arr[i][j]);
			}
		}

	}

}
