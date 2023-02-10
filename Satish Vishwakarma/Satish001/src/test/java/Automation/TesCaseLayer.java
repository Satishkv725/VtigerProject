package Automation;

import com.aventstack.extentreports.ExtentReports;

public class TesCaseLayer extends GenaricLayer  {
	
	public static void main(String[] args) {
		
		TesCaseLayer obj=new TesCaseLayer();
		
		ExtentReports report = obj.takeExtentTestReport();
		obj.createTest("TC000");

		obj.lanchBrowser( "chrome", "chromeBrowser");
		obj.openUrl("http://localhost:8888");
		
		obj.createTest("TC001---verifyUserTextboxSize");	
		obj.verifyUserTextboxSize();
		
		obj.createTest("tc002--verifyUserTextboxLocation");
		obj.verifyUserTextboxLocation();
		
		obj.createTest("tc003--verifyCreateNewLead");
		obj.verifyCreateNewLead();
		
		obj.flush();
	}
	
	public void verifyUserTextboxSize() {
	
		validateGetSize("xpath", "//input[@name='user_name']", "user name", 140, 22);
		validateGetSize("xpath", "//input[@name='user_password']", "user password", 141, 23);
		validateGetSize("xpath", "//input[@name='Login']", "Login Button", 138, 40);
		
	}
	
	public  void verifyUserTextboxLocation() {
	
		validateGetLocation("xpath", "//input[@name='user_name']", "user name", 632, 230);
		validateGetLocation("xpath", "//input[@name='user_password']", "user password", 632,262);
		validateGetLocation("xpath", "//input[@name='Login']", "Login Button", 632, 350);
	
	}
	
		public  void verifyCreateNewLead() {
		
		enterTextboxValue("xpath", "//input[@name='user_name']", "user name", "admin");
	
		validateText("xpath", "//td[text()='User Name']", "user name", "user");
		
		enterTextboxValue("xpath", "//input[@name='user_password']", "user password", "admin");
	    getInnerText("xpath", "//td[text()='Password']", "PASWORD");
		
		getSelectValue("xpath", "//select[@name='login_theme']", "login_theme", "alphagrey");
		getAttributeValue("xpath", "//input[@name='Login']", "loginFuction","accesskey");
		click("xpath", "//input[@name='Login']", "login");
		//Marketing
		click("xpath", "//a[text()='Marketing']","Marketing");
		//obj.actionMouseOver("xpath", "//a[text()='Marketing']","Marketing");
		
		//Leads
		click("xpath", "//table[@class='level2Bg']//a[text()='Leads']", "Leads");
		//Create Lead
		click("xpath","//img[@title='Create Lead...']", "CreateLead");
		//select dropdown title name
		getSelectValue("xpath","//select[@name='salutationtype']", "titleName", "Mr.");
		enterTextboxValue("xpath","//input[@name='firstname']","EnterFirstName","Satish");
		enterTextboxValue("xpath","//input[@name='lastname']","EnterLastName","Vishwakarma");
		enterTextboxValue("xpath","//input[@name='company']","CompanyName","RudraInterPricess");
		enterTextboxValue("xpath","//input[@name='designation']","CompanyName","pvt.ltd");
		getSelectValue("xpath","//select[@name='leadsource']", "leadsource", "Public Relations");
		getSelectValue("xpath","//select[@name='leadstatus']", "leadstatus", "Hot");
		
		enterTextboxValue("xpath","//input[@id='phone']","PhoneNo","05414274328");
		enterTextboxValue("xpath","//input[@id='mobile']","MobileNo","9616330099");
		enterTextboxValue("xpath","//input[@id='fax']","FaxNo","221406");
		enterTextboxValue("xpath","//input[@id='email']","Email_Id","satishkv725@gmail.com");
		enterTextboxValue("xpath","//textarea[@name='lane']","Street","Mondh Bhadohi Road");
		enterTextboxValue("xpath","//input[@id='code']","Postal Code","221406");
		enterTextboxValue("xpath","//input[@id='country']","Country","India");
		enterTextboxValue("xpath","//input[@id='pobox']","PostBox","Mondh");
		enterTextboxValue("xpath","//input[@id='city']","City","Bhadohi");
		enterTextboxValue("xpath","//input[@id='state']","State","UttarPradesh");
		enterTextboxValue("xpath","//textarea[@name='description']","Description","Hi i am satish kumar vishwakarma this is the new thing");
		
	}
	
}
