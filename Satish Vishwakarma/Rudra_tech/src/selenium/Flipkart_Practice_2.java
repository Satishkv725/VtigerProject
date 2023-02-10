package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkart_Practice_2 {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Satish Vishwakarma\\Desktop\\Satish Vishwakarma\\Rudra_tech\\driver\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		//driver.manage().window().maximize();

		driver.findElement(By.xpath("//button[@class=\"_2KpZ6l _2doB4z\"]")).click();
		
		driver.findElement(By.xpath("//input[@class=\"_3704LK\"]")).sendKeys("bata  shose");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(10000);
		List<WebElement> bataShoseName=driver.findElements(By.xpath("//a[contains(@class,'IRpwTa')]"));
		List<WebElement> bataShoseNamePrice=driver.findElements(By.xpath("//div[@class=\"_30jeq3\"]"));
		int batashosecont=bataShoseName.size();
		System.out.println(batashosecont);
		
		for (int i = 0; i <batashosecont; i++) {
		WebElement webataLink=	bataShoseName.get(i);
		WebElement webataPriceLink=bataShoseNamePrice.get(i);
		String innerTextosShose=webataLink.getText();
		String innerTextofBataprice=webataPriceLink.getText();
		System.out.println(1+i+","+innerTextosShose+"="+innerTextofBataprice);
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
}