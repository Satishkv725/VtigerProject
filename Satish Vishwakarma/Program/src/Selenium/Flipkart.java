package Selenium;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Flipkart {
public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver","driver\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("http://www.flipkart.com");
	//Thread.sleep(1000);
	driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
	//search
	driver.findElement(By.xpath("//input[@name='q']")).sendKeys("samsung mobile");
	
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	//low to high
	Actions obj=new Actions(driver);
	Thread.sleep(2000);
	WebElement clickListObj=driver.findElement(By.xpath("//div[contains(text(),'Price -- Low to High')]"));
	obj.click(clickListObj).build().perform();
	
	List<WebElement> listObj=driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
	Thread.sleep(2000);
	Set<String> setListName=new TreeSet<String>();
	for (int i = 0; i < listObj.size(); i++) {
		Thread.sleep(2000);
		listObj=driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
		WebElement priceNameList= listObj.get(i);
		String priceName=priceNameList.getText();
	    System.out.println(i+"="+priceName);
	    setListName.add(priceName);
	
	Thread.sleep(2000);
	for (String getListObj : setListName) {
		System.out.println(getListObj);
		if(priceName.equalsIgnoreCase(getListObj)) {
			System.out.println("pass");
		}else {
			System.out.println("fail");
		}
		}
	}
	
}
}
