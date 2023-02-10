package popup_Alart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Popup{

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Satish Vishwakarma\\Desktop\\Satish Vishwakarma\\Rudra_tech\\driver\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(); /// 1
		driver.get("http://localhost:8888/");

		WebElement weUserName = driver.findElement(By.name("user_name"));
		weUserName.clear();
		weUserName.sendKeys("admin");

		WebElement wePassword = driver.findElement(By.name("user_password"));
		wePassword.clear();
		wePassword.sendKeys("admin");

		driver.findElement(By.name("Login")).click();
		driver.findElement(By.xpath("//a[text()='Marketing']")).click();
		
		driver.findElement(By.xpath("//input[@id='130']")).click();
		driver.findElement(By.xpath("//input[@value='Delete']")).click();
		
	//	driver.switchTo().alert().accept();
//		driver.switchTo().alert().dismiss();
//		driver.switchTo().alert().getText();      
//		driver.switchTo().alert().sendKeys("");    popup text write
//		
		 
		

	}

}
