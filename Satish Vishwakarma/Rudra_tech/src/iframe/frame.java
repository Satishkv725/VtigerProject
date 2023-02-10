package iframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class frame {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","driver\\\\chromedriver.exe");

		WebDriver driver=new ChromeDriver();
	//	driver.manage().window().maximize();
		driver.get("https://automatenow.io/sandbox-automation-testing-practice-website/iframes/");
		
		driver.switchTo().frame(0);
		
	System.out.println(driver.findElement(By.xpath("//h1[contains(text(),'Selenium')]")).getText());
	
		driver.switchTo().defaultContent();
	//	driver.switchTo().parentFrame();
		//driver.switchTo().frame("");
		//driver.switchTo().frame(webelement reference);
	System.out.println(driver.findElement(By.xpath("//p[contains(text(),'iframe')]")).getText());	
				
	driver.findElement(By.xpath("//button[@id='nav_toggle']")).click();			

    driver.findElement(By.xpath("//span[text()='Training']")).click();
	
	driver.navigate().back();
	

	
	System.out.println(driver.findElement(By.xpath("//span[contains(text(),'automateNow')]")).getText());	
//	driver.findElement(By.xpath(""));
//	driver.findElement(By.xpath(""));
//	driver.findElement(By.xpath(""));
//		
	}

}
