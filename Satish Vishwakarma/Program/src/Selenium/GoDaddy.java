package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoDaddy {

	public static void main(String[] args) {
		GoDaddy daddy = new GoDaddy();
		//daddy.test1();
		//daddy.test2();
		daddy.test3();

	}

	void test1() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.godaddy.com/");
		driver.manage().window().maximize();
		driver.close();
	}

	void test2() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.godaddy.com/");
		driver.manage().window().maximize();
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		String url = driver.getCurrentUrl();
		System.out.println(url);
		driver.close();
	}

	void test3() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.godaddy.com/");
	//	driver.manage().window().maximize();
		String actualTitle = driver.getTitle();
		String expectedTitle = "Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy IN";
		if (actualTitle.equalsIgnoreCase(expectedTitle)) {
			System.out.println("Test case passed your actual page title matched");
		} else {
			System.out.println("Test case failed your actual page title not matched");
		}
		String url = driver.getCurrentUrl();
		System.out.println(url);
		String expectedUrl = "https://www.godaddy.com";
		if (url.equalsIgnoreCase(expectedUrl)) {
			System.out.println("Test case passed your actual URL matched");
		} else {
			System.out.println("Test case failed your actual URL not matched");
		}
       String pageSource= driver.getPageSource();
       //System.out.println(pageSource);
       if(pageSource.contains(actualTitle)) {
    	 System.out.println("test case passed and match pagesource title");  
       }else {
    	   System.out.println("test case failed and not  match pagesource title");   
       }
       
		//driver.close();
	}

}
