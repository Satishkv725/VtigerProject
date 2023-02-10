package collections;

import java.util.ArrayList;
import java.util.List;

public class ListInter {
//collection- collection is a interface which defines multiple interface and classess to store multiple object in a singal entity 
//if we want to represent multiple object in a singal intity  then we should go for collection interface 
	public static void main(String[] args) {
		    
		List ad=new ArrayList(); 
		ad.add(10);
		ad.add("satish");
		ad.add('a');
		ad.add(10.5);
		ad.add("satish");
		System.out.println(ad);
		 
	}

}
 