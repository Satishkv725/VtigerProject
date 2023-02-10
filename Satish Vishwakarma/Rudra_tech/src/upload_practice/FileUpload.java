package upload_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FileUpload {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Satish Vishwakarma\\Desktop\\Satish Vishwakarma\\Rudra_tech\\driver\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(); /// 1
		driver.get("http://localhost:8888/");

		WebElement weUserName = driver.findElement(By.name("user_name"));
		weUserName.clear();
		weUserName.sendKeys("admin");

		WebElement wePassword = driver.findElement(By.name("user_password"));
		wePassword.clear();
		wePassword.sendKeys("admin");

		driver.findElement(By.name("Login")).click();
		driver.findElement(By.xpath("//a[text()='Marketing']")).click();
		driver.findElement(By.xpath("//a[text()='Documents']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Document...']")).click();
		Select objSel = new Select(driver.findElement(By.xpath("//select[@name='filelocationtype']")));
		objSel.selectByIndex(0);
		driver.findElement(By.xpath("//input[@id='filename_I__']")).sendKeys(
				"C:\\Users\\Satish Vishwakarma\\Desktop\\Satish Vishwakarma\\Rudra_tech\\src\\upload_practice\\File\\Code-with-harry-java-notes-{Goodsoch.com}.pdf ");
	}

}
