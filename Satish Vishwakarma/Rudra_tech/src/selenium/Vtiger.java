package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;

public class Vtiger {
public static void main(String[] args) {
	
	System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
	ChromeOptions options = new ChromeOptions();
	options.addArguments("incognito");
	options.setExperimentalOption("excludeSwitches", new String [] {"enable-automation"});
	WebDriver driver = new ChromeDriver(options);
	driver.get("http://localhost:8888/");
	driver.findElement(By.name("user_name")).sendKeys("admin");
	Actions action = new Actions(driver);
	driver.findElement(By.name("user_password")).sendKeys("admin");
	//action .sendKeys(null, args)
	driver.findElement(By.name("Login")).click();
	WebElement weMarketing =  driver.findElement(By.xpath("//a[text()='Marketing']"));
	action.clickAndHold(weMarketing).build().perform();
	driver.findElement(By.xpath("//div[@id='Marketing_sub']//a[text()='Accounts']")).click();
	String color = driver.findElement(By.xpath(" //input[@class='crmbutton small create']")).getCssValue("background-color");
System.out.println(color);
java.awt.Color asHex = Color.fromString(color).getColor().red;
//System.out.println("ffff ==="+asHex);
if (asHex.equals("#5774b0")){
	System.out.println("color Test is passed....");
}
else {
	System.out.println("color test is failed...😥😥😥😥😥😥😥😥");
}
}
}
