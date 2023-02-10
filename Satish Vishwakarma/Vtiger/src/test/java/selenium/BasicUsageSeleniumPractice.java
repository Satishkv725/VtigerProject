package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicUsageSeleniumPractice {

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

		String passwordValue = wePassword.getAttribute("value");
		System.out.println(passwordValue);

		String loginButtonText = driver.findElement(By.name("Login")).getText();
		System.out.println("Login Button text is " + loginButtonText);
		driver.findElement(By.name("Login")).click();

		String actualErrorMsgText = driver.findElement(By.xpath("//font[@color='Brown']")).getText();
		String expectedErrorMsgText = "You must specify a valid username and password.";
		if (actualErrorMsgText.equals(expectedErrorMsgText)) {
			System.out.println("Testing is Passed. Error Message is correct");
		} else {
			System.out.println("Testing is Failed. Error Message is incorrect");

		}

		driver.findElement(By.linkText("Marketing")).click();

		String actualText = driver.findElement(By.xpath("//span[@class='moduleName']")).getText();
		String expectedText = "Search";
		if (actualText.equalsIgnoreCase(expectedText)) {
			System.out.println("Search Testing is passed");
		} else {
			System.out.println("Search Testing is failed");
		}
		String actualSearchNowText = driver.findElement(By.xpath("//input[@class='crmbutton small create']"))
				.getAttribute("value");
		String expectedSearchNowText = " Search Now ";

		if (actualSearchNowText.equalsIgnoreCase(expectedSearchNowText) == true) {
			System.out.println("Search Now Button Testing is passed.");
		} else {
			System.out.println("Search Now Button Testing is Failed.");
		}

		Dimension dimSearchNowButton = driver.findElement(By.xpath("//input[@class='crmbutton small create']"))
				.getSize();
		int height = dimSearchNowButton.getHeight(); /// vertically Horizontally
		int width = dimSearchNowButton.getWidth();
		System.out.println(height + "," + width);

		///// Verification Testing Validation

		Point locationObject = driver.findElement(By.xpath("//input[@class='crmbutton small create']")).getLocation();
		int xvalue = locationObject.getX();
		int yValue = locationObject.getY();
		System.out.println("x-" + xvalue + ", y-" + yValue);

		boolean createButtonStatus = driver.findElement(By.xpath("//input[@class='crmbutton small create']"))
				.isDisplayed();

		if (createButtonStatus == true) {
			System.out.println("create button testing is passed. Create button is visible");
		} else {
			System.out.println("create button testing is failed. Create button is invisible");

		}

		boolean actualStatus = driver.findElement(By.xpath("//input[@class='crmbutton small create']")).isEnabled();
		boolean expectedStatus = true;
		if (actualStatus == expectedStatus) {
			System.out.println("Search Now button testing is passed because button is enabled.");
		} else {
			System.out.println("Search Now button testing is failed and button because disabled.");
		}

		/// verify campaign's first checkbox is unchecked or unselected

		boolean checkboxSelectionStatus = driver.findElement(By.xpath("//input[@name='selectall']")).isSelected();
		if (checkboxSelectionStatus == false) {
			System.out.println("campaign first checkbox test is passed. It is unchecked");
		} else {
			System.out.println("campaign first checkbox test is failed. It is checked");

		}

	}

}
