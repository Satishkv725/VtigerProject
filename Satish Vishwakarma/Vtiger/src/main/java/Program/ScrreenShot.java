package Program;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrreenShot {

	public static void main(String[] args) throws IOException {

		File fileName = new File("//AutomationReport//testResult.html");
		ExtentSparkReporter htmlReport = new ExtentSparkReporter(fileName);

		ExtentReports extentObj = new ExtentReports();
		extentObj.attachReporter(htmlReport);

		ExtentTest testCase01 = extentObj.createTest("tc.001");

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		testCase01.log(Status.INFO, "Browser launched Successfully");
		driver.get("http://localhost:8888");
		testCase01.log(Status.INFO, "Url navigated sucessfully");

		WebElement userName = driver.findElement(By.name("user_name"));
		boolean uboxIsEnabled = userName.isEnabled();
		if (uboxIsEnabled == true) {
			testCase01.log(Status.PASS, "userName box is enable");
		} else {
			testCase01.log(Status.FAIL, "userName box is disable");
		}
		userName.clear();
		userName.sendKeys("admin");

		WebElement userPassword = driver.findElement(By.name("user_password"));
		userPassword.clear();
		userPassword.sendKeys("admin");

		driver.findElement(By.name("Login")).click();

		TakesScreenshot tss = (TakesScreenshot) driver;
		File from = tss.getScreenshotAs(OutputType.FILE);
		File to = new File("AutomationReport//abc" + System.currentTimeMillis() + ".png");
		Files.copy(from, to);
		testCase01.addScreenCaptureFromPath(to.getAbsolutePath());
		extentObj.flush();
	}

}
