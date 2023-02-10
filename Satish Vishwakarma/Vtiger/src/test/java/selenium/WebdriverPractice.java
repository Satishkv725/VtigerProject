 package selenium;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

class WebdriverPractice {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Satish Vishwakarma\\Desktop\\Satish Vishwakarma\\Rudra_tech\\driver\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();

		WebElement usName = driver.findElement(By.name("user_name"));
		usName.clear();
		usName.sendKeys("admin");

		WebElement b = driver.findElement(By.name("user_password"));
		b.clear();
		b.sendKeys("admin");

		driver.findElement(By.xpath("//input[@title=\"Login [Alt+L]\"]")).click();
		
		System.out.println();
		System.out.println("Homepagetab=");
		
		List<WebElement> getAllTagNameText=driver.findElements(By.xpath("//tr[@class=\"headerrow\"]"));
        for (WebElement text : getAllTagNameText) {
        	System.out.println(text.getText());
			
		}
         System.out.println();
         System.out.println("NodataFoundtext=");
        Thread.sleep(5000);
		List<WebElement> getTextNoDataFound=driver.findElements(By.xpath("//div[text()='No Data Found']"));
		for (WebElement Element : getTextNoDataFound) {
			System.out.println(Element.getText());
		}
		
		 Thread.sleep(5000);

		Actions act = new Actions(driver);
		WebElement marketing = driver.findElement(By.xpath("//a[text()='Marketing']"));
		act.moveToElement(marketing).build().perform();


		WebElement Lead = driver.findElement(By.xpath("//div[@id='Marketing_sub']//a[text()='Leads']"));
		Lead.click();

		Thread.sleep(5000);
		
		
		List<WebElement> listCheckBox = driver.findElements(By.xpath("//input[@name='selected_id']"));
		for (WebElement web1 : listCheckBox) {
			web1.click();
		//	System.out.println(web.getText());
		}
		System.out.println();
		System.out.println("LastName.....");
		List<WebElement> getTextPrintLastName=driver.findElements(By.xpath("//span[contains(@vtfieldname,'lastname')]/preceding-sibling::a"));
        for (WebElement text : getTextPrintLastName) {
        	System.out.println(text.getText());
			
		}
        System.out.println();
        System.out.println("FirstName....");
      //span[contains(@vtfieldname,'firstname')]/preceding-sibling::a
        List<WebElement> getTextPrintFirstName=driver.findElements(By.xpath("//span[contains(@vtfieldname,'firstname')]/preceding-sibling::a"));
        for (WebElement text : getTextPrintFirstName) {
        	System.out.println(text.getText());
			
		}
        
        List<WebElement> listCheckAlfhabets = driver.findElements(By.xpath("//td[@class='searchAlph']"));
		for (WebElement web : listCheckAlfhabets) {
			web.click();
			}

        
        
        
        
        
        
        
        
        
        
        
        
	}
}
