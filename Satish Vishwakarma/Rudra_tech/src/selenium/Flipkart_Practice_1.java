package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkart_Practice_1 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Satish Vishwakarma\\Desktop\\Satish Vishwakarma\\Rudra_tech\\driver\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//button[@class=\"_2KpZ6l _2doB4z\"]")).click();
		
	    List<WebElement> homePageTagNamePrint = driver.findElements(By.xpath("//div[@class=\"_37M3Pb\"]//div[@class=\"xtXmba\"]"));
	    int homePageTagName=homePageTagNamePrint.size();
	    System.out.println(homePageTagName);
		for (int i = 0; i <homePageTagName ; i++) {
			homePageTagNamePrint = driver.findElements(By.xpath("//div[@class=\"_37M3Pb\"]//div[@class=\"xtXmba\"]"));
			WebElement homePage=homePageTagNamePrint.get(i);
			String homePageTextname= homePage.getText();
			System.out.println(homePageTextname);
			homePage.click();
			Thread.sleep(2000);
			if (homePageTextname.equalsIgnoreCase("Fashion")==false &&(homePageTextname.equalsIgnoreCase("Electronics")==false &&(homePageTextname.contentEquals("Home")==false && (homePageTextname.contentEquals("Beauty, Toys & More")==false)))) {
				driver.navigate().back();
				Thread.sleep(10000);
			} else {
				System.out.println("No Back here");
			}
			 
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
