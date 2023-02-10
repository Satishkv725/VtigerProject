package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Croma_practice_1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Satish Vishwakarma\\Desktop\\Satish Vishwakarma\\Rudra_tech\\driver\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.croma.com/");
		//driver.manage().window().maximize();

		String str=driver.findElement(By.xpath("")).getText();
		
		
	}

}
