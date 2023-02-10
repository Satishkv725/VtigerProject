package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Vitigar_Practice {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Satish Vishwakarma\\Desktop\\Satish Vishwakarma\\Rudra_tech\\driver\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		// driver.manage().window().maximize();

		WebElement usName = driver.findElement(By.name("user_name"));
		usName.clear();
		usName.sendKeys("admin");

		WebElement b = driver.findElement(By.name("user_password"));
		b.clear();
		b.sendKeys("admin");

		driver.findElement(By.xpath("//input[@title=\"Login [Alt+L]\"]")).click();

		List<WebElement> moudul = driver.findElements(By.xpath("//td[contains(@class,'Selected')]/a"));
		for (int i = 0; i < moudul.size(); i++) {
			moudul = driver.findElements(By.xpath("//td[contains(@class,'Selected')]/a"));
			WebElement getText = moudul.get(i);
			String getTextLink = getText.getText();
			System.out.println();
			System.out.println(i + 1 + "===" + getTextLink + "===");                                                                                                                                                                                                                                          
			getText.click();                                                                                                                                                                                                                                                                                                                                                                                                       
			Thread.sleep(2000);

			List<WebElement> subModule = driver.findElements(By.xpath("//td[contains(@class,'SelTab')]/a"));
			for (int j = 0; j < subModule.size(); j++) {
				subModule = driver.findElements(By.xpath("//td[contains(@class,'SelTab')]/a"));
				WebElement subGetText = subModule.get(j);                                                                                                                                                                                                                                                                                                                                                         
				String subGetTextLink = subGetText.getText();
				System.out.print(j + 1 + "," + subGetTextLink + ".");
				subGetText.click();
				
				if (subGetTextLink.equalsIgnoreCase("webmail") == false && subGetTextLink.equalsIgnoreCase("Module Manager") == false) {
					String expectedTest=getTextLink + " > "+subGetTextLink;
					WebElement actualText = driver.findElement(By.xpath("//a[@class=\"hdrLink\"]"));
					String expected = actualText.getText();

					if (subGetTextLink.equalsIgnoreCase(expected)) {
						System.out.println("passed. Where actual-"+expected+"&& expected-"+expectedTest);
					} else {
						System.out.println("failed. Where actual-"+"&& expected-");
					}
				} else
					System.out.println(subGetTextLink + " cant be automated !");
			}
		}
	}

}
