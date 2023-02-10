package Arrays;

public class Array3D {

public static void main(String[] args) {
	Array3D obj =new Array3D();
obj.m3();
			String arr[][][] =

					{     {  { "Arnav", "Pramod", "Dinesh" }, 
							{ "Babli", "Rahat", "Hema" }, 
							{ "Babli1", "Rahat1", "Hema1" }},

							{{ "Arnav123", "Pramod123", "Dinesh123" }, 
							{ "Babli123", "Rahat123", "Hema123" }, 
							{ "Babli1123", "Rahat1123", "Hema1123" }}
							
					};
			System.out.println(arr.length);
			for(String[][] strn : arr) {
				
				for (String[] str : strn) {
					for (String st : str) {
						System.out.print(st+" ");
					}
					System.out.println();
				}
			}

		}

void m3() {
			String arr[][][] =

					{     {  { "satish", "Prema", "Dinesh" }, 
							{ "Bablu", "Rahat", "HemaMalani" }, 
							{ "Babli", "Ramu", "Hena" }},

							{{ "Arnav123", "Pramod123", "Dinesh123" }, 
							{ "Babli123", "Rahat123", "Hema123" }, 
							{ "Babli1123", "Rahat1123", "Hema1123" }}
							
					};
			
			for(String[][] strn : arr) {
				
				for (String[] str : strn) {
					for (String st : str) {
						
						if (st.equalsIgnoreCase("Rahat")) {
							System.out.println("sam");
						}
					}
					System.out.println();
				}
			}

		}

}
