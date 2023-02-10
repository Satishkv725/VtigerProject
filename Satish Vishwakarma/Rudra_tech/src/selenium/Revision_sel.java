package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Revision_sel {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Satish Vishwakarma\\Desktop\\Satish Vishwakarma\\Rudra_tech\\driver\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");

		WebElement usName = driver.findElement(By.name("user_name"));
		usName.clear();
		usName.sendKeys("admin");

		WebElement usPassword = driver.findElement(By.name("user_password"));
		usPassword.clear();
		usPassword.sendKeys("admin");
        
		String getatvalue=usPassword.getAttribute("name");
		System.out.println(getatvalue);
		
		WebElement loginButoon = driver.findElement(By.name("Login"));
		Dimension size = loginButoon.getSize();
		int a = size.getHeight();
		int b = size.getWidth();
		System.out.println("Height = " + a + "," + " Width = " + b);
		loginButoon.click();
		// a[@class="hdrLink"]
	// 	WebElement weTitle=driver.findElement(By.xpath("//title[text()='admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM'] "));
		 
		String exp_title = "admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM";
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		if (actualTitle.equalsIgnoreCase(exp_title)) {

			System.out.println("Home page has been appared");
		} else {
			System.out.println("Home page should not be appared");
		}

		driver.findElement(By.xpath("//a[text()='Marketing']")).click();
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys("Donate Food");
		driver.findElement(By.xpath("//input[@onclick=\"toggleAssignType(this.value)\"]")).click();
		driver.findElement(By.xpath("//option[@value='Public Relations']")).click();
		driver.findElement(By.xpath("//input[@name=\"targetaudience\"]")).sendKeys("100");
		driver.findElement(By.xpath("(//input[@onblur=\"this.className='detailedViewTextBox'\"])[4]"))
				.sendKeys("Rudra Interpriceses");
		driver.findElement(By.xpath("//input[@id=\"numsent\"]")).sendKeys("50");
		driver.findElement(By.xpath("//option[@value=\"Planning\"]")).click();
		// driver.findElement(By.xpath("//input[@name='product_name']")).sendKeys("Nonvage_Food");

		WebElement date = driver.findElement(By.xpath("//input[@id=\"jscal_field_closingdate\"]"));
		date.clear();
		date.sendKeys("2022-08-30");

		driver.findElement(By.xpath("//input[@id=\"targetsize\"]")).sendKeys("15 ");

		WebElement bugetcost = driver.findElement(By.xpath("//input[@id=\"budgetcost\"]"));
		bugetcost.clear();
		bugetcost.sendKeys("10000");

		Select selectObj = new Select(driver.findElement(By.xpath("//select[@name=\"expectedresponse\"]")));
		selectObj.selectByValue("Excellent");

		driver.findElement(By.xpath("//input[@id=\"expectedsalescount\"]")).sendKeys("500");

		driver.findElement(By.xpath("//input[@id='expectedresponsecount']")).sendKeys("85");

		WebElement roiObj = driver.findElement(By.xpath("//input[@id=\"expectedroi\"]"));
		roiObj.clear();
		roiObj.sendKeys("25");

		WebElement actualCostObj = driver.findElement(By.xpath("//input[@id=\"actualcost\"]"));
		actualCostObj.clear();
		actualCostObj.sendKeys("35");

		WebElement expectedRevenuObj = driver.findElement(By.xpath("//input[@id=\"expectedrevenue\"]"));
		expectedRevenuObj.clear();
		expectedRevenuObj.sendKeys("45");

		WebElement actSale = driver.findElement(By.xpath("//input[@id=\"actualsalescount\"]"));
		actSale.clear();
		actSale.sendKeys("40");

		WebElement actResponseCount = driver.findElement(By.xpath("//input[@id=\"actualresponsecount\"]"));
		actResponseCount.clear();
		actResponseCount.sendKeys("25");

		WebElement actualRoi = driver.findElement(By.xpath("//input[@id=\"actualroi\"]"));
		actualRoi.clear();
		actualRoi.sendKeys("10");

		WebElement summary = driver.findElement(By.xpath("//textarea[@class=\"detailedViewTextBox\"]"));
		summary.clear();
		summary.sendKeys("This campaign is very good prospect to provide many food for poor people . ");

//		WebElement logOut = driver.findElement(By.xpath("(//input[@accesskey=\"S\"])[2]"));
//        logOut.click();
	}
}
