package Febnomic_P;

public class Febnomic {
	public static void main(String args[])  
	{    
	         int n1=0,
			 n2=1,
			 n3;
			    
	 System.out.print(n1+" "+n2);//printing 0 and 1    
	    
	 for(int i=0;i<10;i++)    
	 {    
	  n3=n1+n2;    
	  System.out.print(" "+n3);    
	  n1=n2;    
	  n2=n3;    
	 }    
	  
	} 
	
	
}
