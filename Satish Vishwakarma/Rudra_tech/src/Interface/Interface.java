package Interface;

public interface Interface{
	
	

	void run();
	
	 void sleep();

	private static void jkl() {
		
	}
	
	 default void m1() {
		 
	 }

	
}

class parent implements Interface{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		
	}
	 void  m2() {
		 
	 }
}

class child extends parent {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		
	}
	void m3() {
		
	}
}

class   grandchild extends child 
{
	public static void main(String[] args) {
		
		
		child obj=	new grandchild();
		
		
		
	}
}