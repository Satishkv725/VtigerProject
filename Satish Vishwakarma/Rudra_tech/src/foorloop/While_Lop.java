package foorloop;

public class While_Lop {

	public static void main(String[] args) {
		
		int i=0  ;	
		while(i++<5) {		
			int j=0;
        while(j++<i) { 
		System.out.print("*");
	}
    System.out.println();
	}
 
		System.out.println();
		 
        	int x=5;	
    		while(x-->0) {		
    			int y=x;
            while(y-->=0) { 
    	System.out.print("*");
    	}
        System.out.println();
		}
    		
     
    		  int p=1;
   	 	   while(p<=5)
   		        {           
   			int j=5;
   			while(j>p)
   			{
   			System.out.print(" ");
   			j--;
   			}
   			int k=0;
   			while(k<p)
   			{
   			System.out.print("*");
   			k++;
   			}
   	 	        System.out.println();
   		        p ++;
   	     	        } 	  	
    	
     
   	 	
	

	}

}
