package AutomationWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Automationexercise {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Satish Vishwakarma\\\\Desktop\\\\Satish Vishwakarma\\\\Rudra_tech\\\\driver\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://automationexercise.com");
		
		if(driver.findElement(By.xpath("//i[contains(@class,'home')]")).isDisplayed()==true) {
			System.out.println("Home page shoud be appared");
		}else {
			System.out.println("Home page shoud not be appared");
		}
		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
		//button[text()='Login']
		
		if(driver.findElement(By.xpath("//h2[contains(text(),'New User Signup')]")).isDisplayed()==true){
			System.out.println("'New User Signup!' is visible");
		}else {
			System.out.println("'New User Signup!' is not visible");
		}
		
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("satish");
		driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("satishkv725@gmail.com");
		driver.findElement(By.xpath("//button[text()='Signup']")).click();
		
		if(driver.findElement(By.xpath("//b[text()='Enter Account Information']")).isDisplayed()==true) {
			System.out.println("'ENTER ACCOUNT INFORMATION' is visible");
		}else { 
			System.out.println("'ENTER ACCOUNT INFORMATION' is not visible");
		}
		
		driver.findElement(By.xpath("//input[@value='Mr']")).click();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("satish725");
		
		new Select(driver.findElement(By.id("days"))).selectByVisibleText("15");
		new Select(driver.findElement(By.id("months"))).selectByVisibleText("July");
		new Select(driver.findElement(By.id("years"))).selectByVisibleText("1992");
		
		driver.findElement(By.xpath("//input[@id='newsletter']")).click();
		driver.findElement(By.xpath("//input[@id='optin']")).click();
		
		driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("Rudra");
		driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("Vishwakarma");
		driver.findElement(By.xpath("//input[@id='company']")).sendKeys("Rudra InterPrices");
		driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("");
		driver.findElement(By.xpath("//input[@id='address2']")).sendKeys("");
		
		new Select(driver.findElement(By.xpath("//select[@id='country']"))).selectByVisibleText("India");
		
		driver.findElement(By.xpath("//input[@id='state']")).sendKeys("Uttar Pradesh");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Bhadohi");
		driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys("221406");
		driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys("9616330099");
		
		if(driver.findElement(By.xpath("//button[text()='Create Account']")).isDisplayed()==true){
			System.out.println("'ACCOUNT CREATED!' is visible");
		} else {
			System.out.println("'ACCOUNT CREATED!' is not visible");
		}
		driver.findElement(By.xpath("//button[text()='Create Account']")).click();
		
		driver.findElement(By.xpath("")).sendKeys("");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
