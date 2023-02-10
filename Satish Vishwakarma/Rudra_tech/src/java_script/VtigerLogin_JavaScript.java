package java_script;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class VtigerLogin_JavaScript {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions script =new ChromeOptions();
		System.setProperty("webdriver.chrome.driver", "driver\\\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(script);
		driver.get("http://localhost:8888/");
		
		script.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
	   
		
		
		JavascriptExecutor scriptObj = (JavascriptExecutor) driver;
		
		WebElement userName = driver.findElement(By.name("user_name"));
		scriptObj.executeScript("arguments[0].value='admin'", userName);

		WebElement userPass = driver.findElement(By.name("user_password"));
		scriptObj.executeScript("arguments[0].value='admin'", userPass);

		WebElement drop = driver.findElement(By.xpath("//select[@name='login_theme']"));
		scriptObj.executeScript("arguments[0].value='bluelagoon'", drop);
		Thread.sleep(3000);
		scriptObj.executeScript("arguments[0].value='woodspice'", drop);

//		Select dropObj= new Select(drop);
//		dropObj.selectByValue("bluelagoon");

		WebElement userLogin = driver.findElement(By.name("Login"));
		scriptObj.executeScript("arguments[0].click()", userLogin);

		
		JavascriptExecutor javaobj=(JavascriptExecutor)driver;
//		javaobj.executeScript("window.scrollBy(0,800)","");
		WebElement obj=driver.findElement(By.xpath("//b[contains(text(),'Key Metrics')]"));
		javaobj.executeScript("arguments[0].scrollIntoView();", obj);
		
		 
		
		
		WebElement marketingObj = driver.findElement(By.xpath("//a[text()='Marketing']"));
		scriptObj.executeScript("arguments[0].click()", marketingObj);

		WebElement leadsObj = driver.findElement(By.xpath("//div[@id=\"Marketing_sub\"]//a[text()='Leads']"));
		scriptObj.executeScript("arguments[0].click()", leadsObj);

		WebElement CreateLeadsObj = driver.findElement(By.xpath("//img[@alt=\"Create Lead...\"]"));
		scriptObj.executeScript("arguments[0].click()", CreateLeadsObj);

	}

}
