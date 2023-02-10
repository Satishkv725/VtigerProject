package up_DownCasting;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class practice {

	public static void main(String[] args) {

		// java.lang.ClassCastException:
		c cob = new c();

		p pob = new p();

	//c cob1 = (c) new p();    //--- donot use this type casting
	// cob1.p2();                 // call nahi ho payega
		
		p pob1 = new c();
	//	c cobj= (c) pob1;
		//cobj.p1();
		c abc=(c) pob1;

//		if(pob1 instanceof D) {
//			D cob1 =(D) pob1;
//			cob1.d1();
//		}else if(pob1 instanceof c) {
//			c cobj1= (c) pob1;
//			cobj1.p1();
//			
//		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
