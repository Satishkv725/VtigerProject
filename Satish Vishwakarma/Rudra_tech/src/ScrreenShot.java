import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class ScrreenShot {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888");

		WebElement userName = driver.findElement(By.name("user_name"));
		userName.clear();
		userName.sendKeys("admin");

		WebElement userPassword = driver.findElement(By.name("user_password"));
		userPassword.clear();
		userPassword.sendKeys("admin");

		driver.findElement(By.name("Login")).click();

		TakesScreenshot tss = (TakesScreenshot) driver;
		File from = tss.getScreenshotAs(OutputType.FILE);
		File to = new File("automationreport//abc.png");
		Files.copy(from, to);

	}

}
