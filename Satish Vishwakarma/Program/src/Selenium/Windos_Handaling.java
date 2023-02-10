package Selenium;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windos_Handaling {
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888");

		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.name("Login")).click();

		// windows Handaling
		driver.findElement(By.linkText("Feedback")).click();
		driver.findElement(By.linkText("Help")).click();
		driver.findElement(By.linkText("About Us")).click();

	Set<String> objWindowsHandle=	driver.getWindowHandles();
	for (String objHandle : objWindowsHandle) {
		driver.switchTo().window(objHandle);
		System.out.println(objHandle);
		String actualTitle=driver.getTitle();
		System.out.println(actualTitle);
		if(objHandle.equalsIgnoreCase(actualTitle)) {
		break;
	}else {
	driver.close();
	
	
	
	}
	}
	driver.findElement(By.xpath("//a[text()='Privacy Policy']")).click();
	
	
	
	
	}	
	//textarea[@name='description']
}