package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;

public class ColorPrint {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.xxx.com");
		
	
		
		WebElement userName=driver.findElement(By.name("user_name"));
		userName.clear();
		userName.sendKeys("admin");
		if(userName.isDisplayed()) 
			System.out.println("UserName Box is visible");
		else
			System.out.println("UserName Box is not visible");
		if(userName.isEnabled())
			System.out.println("UserName Box is clickable");
		else
			System.out.println("UserName Box is not clickable");
		System.out.println();
		
			
		WebElement userPassword=driver.findElement(By.name("user_password"));
		userPassword.clear();
		userPassword.sendKeys("admin");
		if(userPassword.isDisplayed()) 
			System.out.println("userPassword Box is visible");
		else
			System.out.println("userPassword Box is not visible");
		if(userPassword.isEnabled())
			System.out.println("userPassword Box is clickable");
		else
			System.out.println("userPassword Box is not clickable");
		System.out.println();
			
		String userLoginText=driver.findElement(By.name("Login")).getText();
		if(userLoginText.equalsIgnoreCase("Login")) {
			System.out.println("Login button text is "+userLoginText);
		}else {
			System.out.println("Login button text is not Match");
		}
	    System.out.println();
		WebElement usLogin=driver.findElement(By.name("Login"));
		if(usLogin.isDisplayed()) {
			System.out.println("Login Button is visible");
		}else {
			System.out.println("Login Button is not visible");
		}
		if(usLogin.isEnabled())	{
			System.out.println("Login Button is clickable");
		}else {
			System.out.println("Login Button is not clickable");
		}
		usLogin.click();	
		
		
		
		System.out.println();
		String getTextMarketing =driver.findElement(By.xpath("//a[text()='Marketing']")).getText();
		if(getTextMarketing.equalsIgnoreCase("Marketing")) {
			System.out.println("Marketing Button text is "+getTextMarketing);
		}else {
			System.out.println("Marketing Button text is not Match");
		}
		
		driver.findElement(By.xpath("//a[text()='Marketing']")).click();
		
		driver.findElement(By.xpath("//table[@class='level2Bg']//a[text()='Accounts']")).click();
		
		System.out.println();
		
		String getColorElement=	driver.findElement(By.xpath("//input[@value='Delete']")).getCssValue("background-color");
	    String color=	Color.fromString(getColorElement).asHex();
		
		if(color.equals("#ff0000")) {
			System.out.println(" Delet Button color--Test is verified ");
		}else {
			System.out.println(" Delet Button color--Test is not verified ");
		}
		
		String getColorText=	driver.findElement(By.xpath("//input[@value='Delete']")).getCssValue("color");
        String colorText=	Color.fromString(getColorText).asHex();
		
		if(colorText.equals("#ffffff")) {
			System.out.println(" Delet Button Inner Text color--Test is verified ");
		}else {
			System.out.println(" Delet Button Inner Text color--Test is not verified ");
		}
		System.out.println();
		
		
		
		String getColorElementEdit=	driver.findElement(By.xpath("//input[@value='Mass Edit']")).getCssValue("background-color");	
	    String colorEdit=	Color.fromString(getColorElementEdit).asHex();
		
		if(colorEdit.equals("#008000")) {
			System.out.println("Edit Button color--Test is verified ");
		}else {
			System.out.println("Edit Button color--Test is not verified ");
		}
		
		String getColorTextEdit=	driver.findElement(By.xpath("//input[@value='Mass Edit']")).getCssValue("color");
		String colorEditText=	Color.fromString(getColorTextEdit).asHex();
		if(colorEditText.equals("#ffffff")) {
			System.out.println("Edit Button Inner Text color--Test is verified ");
		}else {
			System.out.println("Edit Button Inner Text color--Test is not verified ");
		}
		
		
		
		
		
		 
		
		
	}
	
	
	
	

}
