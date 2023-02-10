package chromeOption;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Option {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Satish Vishwakarma\\Desktop\\Satish Vishwakarma\\Rudra_tech\\driver\\chromedriver.exe");
		
		ChromeOptions option=new ChromeOptions();
		option.addArguments("incognito");
		option.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
	    option.setHeadless(false);
//        option.addArguments("Headless");
	
		ChromeDriver driver = new ChromeDriver(option) ; /// 1
		driver.get("http://localhost:8888/");

		WebElement weUserName = driver.findElement(By.name("user_name"));
		weUserName.clear();
		weUserName.sendKeys("admin");

		WebElement wePassword = driver.findElement(By.name("user_password"));
		wePassword.clear();
		wePassword.sendKeys("admin");

		driver.findElement(By.name("Login")).click(); 
}
}