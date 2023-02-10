package Encapsulation;

public class Practice {
	
	private int collegeId;
	
	
	public void setCollegeId(int newCollegeId) {
		collegeId=newCollegeId;
	
	}
	
	public int getCollegeId() {
		
		
		return collegeId;
	}
	
public static void main(String[] args) {
	Practice obj =new Practice();
	obj.setCollegeId(10);
	//System.out.println(obj.getCollegeId());
int take=	obj.getCollegeId();
System.out.println(take);
}
}
