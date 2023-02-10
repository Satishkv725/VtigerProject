import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Automation_Program {

	public static void main(String[] args) {
		Automation_Program automation = new Automation_Program ();
	//	automation.automation1();
		automation.automation2();
	//	automation.automation3();

	}

	void automation1() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://practice.automationtesting.in");

		String getTitleNameActual=	driver.getTitle();
		if(getTitleNameActual.equalsIgnoreCase("Automation Practice Site")) {
			System.out.println("Home Page Should Be Appeard");	
		}else {
			System.out.println("Home Page Should Not Be Appeard");
		}
		
		driver.findElement(By.xpath("//a[text()='My Account']")).click(); // my account
		driver.findElement(By.xpath("//input[@id='reg_email']")).sendKeys("satishkv725@gmail.com"); // enter email address
																								// //registration
		driver.findElement(By.xpath("//input[@id='reg_password']")).sendKeys("satish725@");
		driver.findElement(By.xpath("//input[@value='Register']")).click();
	}

	void automation2() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://practice.automationtesting.in");
		
	String getTitleNameActual=	driver.getTitle();
	if(getTitleNameActual.equalsIgnoreCase("Automation Practice Site")) {
		System.out.println("Home Page Should Be Appeard");	
	}else {
		System.out.println("Home Page Should Not Be Appeard");
	}

		driver.findElement(By.xpath("//a[text()='My Account']")).click(); // my account
		driver.findElement(By.xpath("//input[@id='reg_email']")).sendKeys("satishkv725@gmail"); // enter email address
																								// //registration
		driver.findElement(By.xpath("//input[@id='reg_password']")).sendKeys("satish725@");
		driver.findElement(By.xpath("//input[@value='Register']")).click();
	}

	void automation3() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://practice.automationtesting.in");

		String getTitleNameActual=	driver.getTitle();
		if(getTitleNameActual.equalsIgnoreCase("Automation Practice Site")) {
			System.out.println("Home Page Should Be Appeard");	
		}else {
			System.out.println("Home Page Should Not Be Appeard");
		}
		
		driver.findElement(By.xpath("//a[text()='My Account']")).click(); // my account
		driver.findElement(By.xpath("//input[@id='reg_email']")).sendKeys("      "); // enter email address empty
																								// //registration
		driver.findElement(By.xpath("//input[@id='reg_password']")).sendKeys("satish725@");
		driver.findElement(By.xpath("//input[@value='Register']")).click();
	}
}
