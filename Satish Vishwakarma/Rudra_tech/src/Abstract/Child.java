package Abstract;

public  class Child extends Parant {

	public static void main(String[] args) {
		
		
		
		
		
	Parant obj=new Child();
		obj.number();
		
		obj.cellPhone();
		obj.m1();
obj.m2();
	}

	@Override
	public void number() {
		System.out.println("hi");
		
	}

	@Override
	public void cellPhone() {
		System.out.println("this is a book");
	}

	
public void m1() {
	System.out.println("m1");
	this.m2();
		super.dog();
	}
public void m2() {
	System.out.println("m2");
	
}


}
