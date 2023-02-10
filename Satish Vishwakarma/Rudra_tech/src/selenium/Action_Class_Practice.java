package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Action_Class_Practice {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Satish Vishwakarma\\Desktop\\Satish Vishwakarma\\Rudra_tech\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		ChromeDriver obj=(ChromeDriver)driver;
		
		
		
		
		//driver.get("http://localhost:8888/");
		// driver.manage().window().maximize();
		driver.navigate().to("http://localhost:8888");
		
		WebElement usName = driver.findElement(By.name("user_name"));
		usName.clear();
		usName.sendKeys("admin");

		WebElement b = driver.findElement(By.name("user_password"));
		b.clear();
		b.sendKeys("admin");
 
		driver.findElement(By.xpath("//input[@title=\"Login [Alt+L]\"]")).click();

		Actions actionObj = new Actions(driver);

		WebElement dragTopAccount = driver.findElement(By.xpath("//b[contains(text(),'Top Accounts')]"));
		WebElement dragTagCloud = driver.findElement(By.xpath("//b[contains(text(),'Tag Cloud')]"));
		actionObj.moveToElement(dragTopAccount).dragAndDrop(dragTagCloud, dragTopAccount).release().build().perform();

		Thread.sleep(5000);

		WebElement maketingClick = driver.findElement(By.xpath("//a[text()='Marketing']"));
		actionObj.moveToElement(maketingClick).build().perform();
		driver.findElement(By.linkText("Leads")).click();
		
		driver.findElement(By.xpath("//input[@id=\"129\"]")).click();
		driver.findElement(By.xpath("//input[@value='Delete']")).click();
		String getTextalart=driver.switchTo().alert().getText();
		if(getTextalart.equalsIgnoreCase("Are you sure you want to delete the selected 1 records?")) {
			System.out.println("Pass");
		}else {
			System.out.println("Failed");
		}   
		
		//driver.switchTo().alert().accept();
        driver.switchTo().alert().dismiss();
//        driver.switchTo().alert().sendKeys("");
        
	}

}
