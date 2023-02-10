package java_java_method;

public class Switchto {

	public static void main(String[] args) {
		Switchto obj =new Switchto();
		obj.SwitchMonth();
		obj.SwitchVowel();
		
		
		
		int number =10;
		
		switch (number) {
		case 10:
			System.out.println(10);
			break;
		case 20:
			System.out.println(20);
		    break;
		case 30:
			System.out.println(30);
			break;
		case 40:
			System.out.println(40);
			break;
			
		default:
			System.out.println("Not in 10,20,30 or 40");
			break;
		}
		
	}	
		void SwitchMonth () {
		
			int month=7;
			
			String monthString="";
			
			switch (month) {
			case 1:monthString="1 -January";	
			System.out.println("January");
				break;
			case 2:monthString="2 -Febuary";
			System.out.println("Febuary");
			break;
			case 3:monthString="3 -March";
			System.out.println("March");
			break;
			case 4:monthString="4 -April";
			System.out.println("April");
			break;
			case 5:monthString="5 -May";
			System.out.println("May");
			break;
			case 6:monthString="6 -Jun";
			System.out.println("Jun");
			break;
			case 7:monthString="7 -July";
			System.out.println("July");
			break;
			case 8:monthString="8 -Agust";	
			System.out.println("Agust");
			break;
			case 9:monthString="9 -September";	
			System.out.println("September");
			break;
			case 10:monthString="10 -October";
			System.out.println("October");
			break;
			case 11:monthString="11 -Novmber";
			System.out.println("Novmber");
			break;
			case 12:monthString="12 -December";	
			System.out.println("December");
			break;

			default:
				System.out.println("Not in month");
				break;
			}			
			
		}
		
		void SwitchVowel () {
			 char ch='O';    
			    switch(ch)  
			    {  
			        case 'a':   
			            System.out.println("a - Vowel");  
			            break;  
			        case 'e':   
			            System.out.println("e - Vowel");  
			            break;  
			        case 'i':   
			            System.out.println("i - Vowel");  
			            break;  
			        case 'o':   
			            System.out.println("o - Vowel");  
			            break;  
			        case 'u':   
			            System.out.println("u - Vowel");  
			            break;  
			        case 'A':   
			            System.out.println("A - Vowel");  
			            break;  
			        case 'E':   
			            System.out.println("E - Vowel");  
			            break;  
			        case 'I':   
			            System.out.println("I - Vowel");  
			            break;  
			        case 'O':   
			            System.out.println("O - Vowel");  
			            break;  
			        case 'U':   
			            System.out.println("U - Vowel");  
			            break;  
			        default:   
			            System.out.println("Consonant");  
			    }  
		}
		
		
		
		
	
	

}
