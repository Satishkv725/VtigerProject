package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sel_Practice_satish {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\\\Users\\\\Satish Vishwakarma\\\\Desktop\\\\Satish Vishwakarma\\\\Rudra_tech\\\\driver\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");

		WebElement weUserName = driver.findElement(By.name("user_name"));
		weUserName.clear();
		weUserName.sendKeys("admin");

		WebElement wePassword = driver.findElement(By.name("user_password"));
		wePassword.clear();
		wePassword.sendKeys("admin");

		String usarValue = weUserName.getAttribute("value");
		System.out.println(usarValue);

		String passwordValue = wePassword.getAttribute("value");
		System.out.println(passwordValue);

		String loginButtonText = driver.findElement(By.name("Login")).getText();
		System.out.println("Login Button text is " + loginButtonText);
		driver.findElement(By.name("Login")).click();

		WebElement actTitle = driver.findElement(By.xpath("//a[@href=\"index.php?action=index&module=Home\"]"));
		String extTitle = driver.getTitle();

		if (actTitle.equals(extTitle)) {
			System.out.println("home page should be appeard");

		} else {
			System.out.println("home page should not be appeard");
		}

		// Marketing
		driver.findElement(By.linkText("Marketing")).click();

		String actualText = driver.findElement(By.xpath("//span[@class='moduleName']")).getText();
		String expectedText = "Search";
		if (actualText.equalsIgnoreCase(expectedText))

		{
			System.out.println("Search testing is passed");
		} else {
			System.out.println("Search testing is failed");
		}
		String actualSearchNowText = driver.findElement(By.xpath("//input[@class='crmbutton small create']"))
				.getAttribute("value");
		String expectedSearchNowText = " Search Now ";

		if (actualSearchNowText.equalsIgnoreCase(expectedSearchNowText)) {
			System.out.println("Search Now Button Testing is passed");
		} else {
			System.out.println("Search Now Button Testing is failed");
		}

		boolean actualStatus = driver.findElement(By.xpath("//input[@class='crmbutton small create']")).isEnabled();
		boolean expectedStatus = true;
		if (actualStatus == expectedStatus) {
			System.out.println("Search Now Button is passed and isEnabled");
		} else {
			System.out.println("Search Now Button is passed and isDisable");
		}

		
		
		
		
		
		
		 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
