package Automation;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;

public class WebUtil {

	private WebDriver driver;
	private ExtentTest extentloggert;

	// ******************getTimeStamp************************

	public String getTimeStamp() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy hh_mm_ss");
		String time = sdf.format(new Date());
		return time;

	}
	// ******************getRandomName************************

	public String getRandomName(int count) {
		String name = "";
		for (int i = 1; i <= count; i++) {
			int rnd = (int) (Math.random() * 52);
			Character base = (rnd < 26) ? 'A' : 'a';
			name = name + base.toString() + rnd % 26;

		}
		return name;

	}

	// *************takeScreenshot*********************

	public String takeScreenshot(String snapshotName) {

		String time = getTimeStamp();
		TakesScreenshot tss = (TakesScreenshot) driver;
		File sourceFile = tss.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File("reports\\snap" + snapshotName + time + ".jpeg");
		try {
			Files.copy(sourceFile, destinationFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destinationFile.getAbsolutePath();

	}

	public void validateInnerText(String xpath, String expectedText, String imgPath) {
		WebElement we = getWebElement(xpath);
		String actualText = we.getText();

		if (actualText.equalsIgnoreCase(expectedText)) {
			extentloggert.log(Status.PASS, "where actualtext" + actualText + "& expectedvalue-" + expectedText);
		} else {
			extentloggert.log(Status.FAIL, " where actualText" + actualText + "& expectedvalue-" + expectedText);
			try {
				extentlogger.addScreenCaptureFromPath(imgPath);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public void validateEnabled(String xpath, String imgPath) {
		WebElement we = getWebElement(xpath);
		boolean status = we.isEnabled();

		if (status) {
			extentloggert.log(Status.PASS, "Element is Enabled");
		} else {
			extentloggert.log(Status.FAIL, "Element is Disabled");
			try {
				extentlogger.addScreenCaptureFromPath(imgPath);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validateDisabled(String xpath, String imgPath) {
		WebElement we = getWebElement(xpath);
		boolean status = we.isEnabled();

		if (status == false) {
			extentloggert.log(Status.PASS, "Element is Disabled");
		} else {
			extentloggert.log(Status.FAIL, "Element is  Enabled");
			try {
				extentlogger.addScreenCaptureFromPath(imgPath);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validateAttribute(String xpath, String imgPath) {
		WebElement we = getWebElement(xpath);
		boolean status = we.isEnabled();

		if (status == false) {
			extentloggert.log(Status.PASS, "Element is Disabled");
		} else {
			extentloggert.log(Status.FAIL, "Element is  Enabled");
			try {
				extentlogger.addScreenCaptureFromPath(imgPath);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// *************************waitForElementVisiilty************************

	public void waitForElementVisiilty(String xpath, Duration timeOutSeceonds) {
		WebDriverWait expWait = new WebDriverWait(driver, timeOutSeceonds);
		expWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}

	// *********************waitForElementEnabled***************************

	public void waitForElementEnabled(String xpath, Duration timeOutSeceonds) {
		WebDriverWait expWait = new WebDriverWait(driver, timeOutSeceonds);
		expWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
	}

	// *******************************waitForElementInvisibilty******************

	public void waitForElementInvisibilty(String xpath, Duration timeOutSeceonds) {
		WebDriverWait expWait = new WebDriverWait(driver, timeOutSeceonds);
		expWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

	}

	// ******************waitForElementText**********************

	public void waitForElementText(String xpath, Duration timeOutSeceonds, String expectedText) {
		WebDriverWait expWait = new WebDriverWait(driver, timeOutSeceonds);
		expWait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(xpath), expectedText));

	}
	// ******************lanchingbrowser*******************//

	public void lanuchBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			extentloggert.log(Status.INFO, "Chrome Browser Launched");
		} else if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			extentloggert.log(Status.INFO, "Firefox Browser Launched");
		}
	}
	// ********************openURL***************************//

	public void openUrl(String url) {
		try {
			driver.get(url);

			extentloggert.log(Status.INFO, url + "url opened successfully");
		} catch (Exception e) {
			extentloggert.log(Status.FAIL, url + "url doesn't open successfully");

		}
	}

	// ***************************getWebElement**************************//

	public WebElement getWebElement(String xpath) {
		WebElement weEle;
		try {
			weEle = driver.findElement(By.xpath(xpath));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			extentloggert.log(Status.INFO, "exception occured while searching element" + e);
			weEle = driver.findElement(By.xpath(xpath));
		}
		return weEle;
	}

	// **********************sendKeys*****************//

	public void inputData(String inputdata, String xpath, String msg) {
		WebElement weEle = getWebElement(xpath);
		// extentlogger.log(Status.INFO, "Value is Inputed succesfully in"+ xpath);
		try {
			weEle.clear();
			weEle.sendKeys(inputdata);
		} catch (ElementNotInteractableException e) {

		}
		extentloggert.log(Status.INFO, msg);
	}

	// ******************initHtmlReporter*****************

	ExtentReports Reports;
	ExtentTest extentlogger;

	public void initHtmlReporter() {
		ExtentSparkReporter exthtml = new ExtentSparkReporter("path"); // It is used to create report inhtml formate
		exthtml.config().setReportName("Funtional report");
		exthtml.config().setDocumentTitle("Vtiger Atomation Report");
		new ExtentReports();
		Reports.attachReporter(exthtml);
		Reports.setSystemInfo("user.name", System.getProperty("user.name"));
		Reports.setSystemInfo("OS", System.getProperty("OS.name"));
		Reports.setSystemInfo("Envoirment", "QA");

	}

	// ******************jsClick*******************

	public void jsClick(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);

	}

	// ******************setExtentlogger*******************

	public void setExtentlogger(String testcase) {

		extentlogger = Reports.createTest(testcase); // to generate logs for specific method /// set of information

	}

	// ******************flushReport******************

	public void flushReport() {
		Reports.flush();
	}

	// *******************VerifyText**********

	public void VerifyText(String xpath, String expectedText, String snapShotName) {

		WebElement element = getWebElement(xpath);
		String actualText = element.getText();
		if (actualText.contains(expectedText)) {
			extentlogger.log(Status.PASS,
					"Actual Text(" + actualText + ")expected text(" + expectedText + "is matched Test is Passed");

		} else {
			extentlogger.log(Status.FAIL,
					"Actual Text(" + actualText + ")expected text(" + expectedText + "is mismatched Test is failed");

			String imgPath = takeScreenshot(snapShotName);
			try {
				extentlogger.addScreenCaptureFromPath(imgPath);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void VerifyAttributevalue(String xpath, String expectedvalue, String attributeName, String snapShotName) {

		WebElement element = getWebElement(xpath);
		String actualValue = element.getAttribute(attributeName);
		if (actualValue.contains(expectedvalue)) {
			extentlogger.log(Status.PASS, "Actual Attribute(" + actualValue + ")expected Attribute(" + expectedvalue
					+ "is matched Attribute is Passed");

		} else {
			extentlogger.log(Status.FAIL, "Actual Attribute(" + actualValue + ")expected Attribute(" + expectedvalue
					+ "is mismatched Attribute is failed");
			String imgPath = takeScreenshot(snapShotName);
			try {
				extentlogger.addScreenCaptureFromPath(imgPath);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void VerifyTitle(String xpath, String expectedTitle, String snapShotName) {
		WebElement element = getWebElement(xpath);

		String actualTitle = driver.getTitle();
		if (actualTitle.contains(expectedTitle)) {
			extentlogger.log(Status.PASS, "Actual Attribute(" + actualTitle + ")expected Attribute(" + expectedTitle
					+ "is matched Attribute is Passed");

		} else {
			extentlogger.log(Status.FAIL, "Actual Attribute(" + actualTitle + ")expected Attribute(" + expectedTitle
					+ "is mismatched Attribute is failed");
			String imgPath = takeScreenshot(snapShotName);
			try {
				extentlogger.addScreenCaptureFromPath(imgPath);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void VerifyElementvisible(String xpath, String expectedVrEleVisible, String snapShotName) {
		WebElement weEle = getWebElement(xpath);
		boolean actualElevisible = weEle.isDisplayed();

		if (actualElevisible) {
			extentlogger.log(Status.PASS, "Actual visible(" + actualElevisible + ")expected visible("
					+ expectedVrEleVisible + "is matched visible is Passed");

		} else {
			extentlogger.log(Status.FAIL, "Actual visible(" + actualElevisible + ")expected visible("
					+ expectedVrEleVisible + "is mismatched visible is failed");
			String imgPath = takeScreenshot(snapShotName);
			try {
				extentlogger.addScreenCaptureFromPath(imgPath);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void VerifyElementinvisible(String xpath, String expectedVrEleinVisible, String snapShotName) {
		WebElement weEle = getWebElement(xpath);

		boolean actualElevisible = weEle.isDisplayed();
		if (actualElevisible) {
			extentlogger.log(Status.PASS, "Actual invisible(" + actualElevisible + ")expected invisible("
					+ expectedVrEleinVisible + "is matched invisible is Passed");

		} else {
			extentlogger.log(Status.FAIL, "Actual invisible(" + actualElevisible + ")expected invisible("
					+ expectedVrEleinVisible + "is mismatched invisible is failed");
			String imgPath = takeScreenshot(snapShotName);
			try {
				extentlogger.addScreenCaptureFromPath(imgPath);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void VerifyElementEnabled(String xpath, String expectedVrEleVisible, String snapShotName) {
		WebElement weEle = getWebElement(xpath);
		boolean actualElevisible = weEle.isDisplayed();
		if (actualElevisible) {
			extentlogger.log(Status.PASS, "Actual Attribute(" + actualElevisible + ")expected Attribute("
					+ expectedVrEleVisible + "is matched Attribute is Passed");

		} else {
			extentlogger.log(Status.FAIL, "Actual Attribute(" + actualElevisible + ")expected Attribute("
					+ expectedVrEleVisible + "is mismatched Attribute is failed");
			String imgPath = takeScreenshot(snapShotName);
			try {
				extentlogger.addScreenCaptureFromPath(imgPath);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void VerifyTextContains(String xpath, String expectedText, String snapShotName) {
		WebElement element = getWebElement(xpath);
		String actualText = element.getText();
		if (actualText.contains(expectedText)) {
			extentlogger.log(Status.PASS,
					"Actual Text(" + actualText + ")expected text(" + expectedText + "is matched Test is Passed");

		} else {
			extentlogger.log(Status.FAIL,
					"Actual Text(" + actualText + ")expected text(" + expectedText + "is mismatched Test is failed");

			String imgPath = takeScreenshot(snapShotName);
			try {
				extentlogger.addScreenCaptureFromPath(imgPath);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	// ******************click****************//

	public void click(String xpath, String msg) {
		WebElement weEle = getWebElement(xpath);

		try {
			weEle.click();
		} catch (ElementNotInteractableException e) {
			weEle = driver.findElement(By.xpath(xpath));
			weEle.clear();

		} catch (StaleElementReferenceException e) {

		}
		extentloggert.log(Status.INFO, msg);
	}

	// ****************selectByVisibleText******************//

	public void selectByVisibleText(String xpath, String sendVisibleText, String msg) {
		WebElement weEle = getWebElement(xpath);
		Select selobj = new Select(weEle);
		try {
			selobj.selectByVisibleText(sendVisibleText);
		} catch (ElementNotInteractableException e) {
			weEle = driver.findElement(By.xpath(xpath));
			weEle.clear();

		} catch (StaleElementReferenceException e) {

		}
		extentloggert.log(Status.INFO, msg);
	}

	public void selectByValue(String xpath, String sendValue, String msg) {
		WebElement weEle = getWebElement(xpath);
		Select selobj = new Select(weEle);
		try {
			selobj.deselectByValue(sendValue);
		} catch (ElementNotInteractableException e) {
			weEle = driver.findElement(By.xpath(xpath));
			weEle.clear();

		} catch (StaleElementReferenceException e) {

		}
		extentloggert.log(Status.INFO, msg);

	}

	public void selectByIndex(String xpath, int indexnumber, String msg) {
		WebElement weEle = getWebElement(xpath);
		Select selobj = new Select(weEle);
		try {
			selobj.selectByIndex(indexnumber);
		} catch (ElementNotInteractableException e) {
			weEle = driver.findElement(By.xpath(xpath));
			weEle.clear();

		} catch (StaleElementReferenceException e) {

		}
		extentloggert.log(Status.INFO, msg);
	}

	// *******************actionsMouseOver*******************

	public void actionsMouseOver(String xpath, String msg) {
		WebElement weEle = getWebElement(xpath);
		Actions actobj = new Actions(driver);
		try {
			actobj.moveToElement(weEle).click().build().perform();
		} catch (ElementNotInteractableException e) {
			weEle = driver.findElement(By.xpath(xpath));
			weEle.clear();

		} catch (StaleElementReferenceException e) {

		}
		extentloggert.log(Status.INFO, msg);
	}

	// *********************actionRightclick**********************

	public void actionRightclick(String xpath, String msg) {
		WebElement weEle = getWebElement(xpath);
		Actions actobj = new Actions(driver);
		try {
			actobj.contextClick(weEle).click().build().perform();
		} catch (ElementNotInteractableException e) {
			weEle = driver.findElement(By.xpath(xpath));
			weEle.clear();

		} catch (StaleElementReferenceException e) {

		}
		extentloggert.log(Status.INFO, msg);
	}

	// **********************actionsdubleclick*************************

	public void actionsdubleclick(String xpath, String msg) {
		WebElement weEle = getWebElement(xpath);
		Actions actobj = new Actions(driver);
		try {
			actobj.doubleClick(weEle).click().build().perform();
		} catch (ElementNotInteractableException e) {
			weEle = driver.findElement(By.xpath(xpath));
			weEle.clear();

		} catch (StaleElementReferenceException e) {

		}
		extentloggert.log(Status.INFO, msg);
	}

	// ********************actionsdragAnddrop***********************

	public void actionsdragAnddrop(String xpath, String msg) {
		WebElement weEle = getWebElement(xpath);
		Actions actobj = new Actions(driver);

		actobj.dragAndDrop(weEle, weEle).click().build().perform();

		extentloggert.log(Status.INFO, msg);
	}

	// ******************IframeIndex*****************

	public void IframeIndex(String xpath, String msg) {
		WebElement weEle = getWebElement(xpath);
		driver.switchTo().frame(0);
		try {
		} catch (ElementNotInteractableException e) {
			weEle = driver.findElement(By.xpath(xpath));
			weEle.clear();

		} catch (StaleElementReferenceException e) {
			weEle = driver.findElement(By.xpath(xpath));

		}
		extentloggert.log(Status.INFO, msg);
	}

	// ******************IframeName*****************
	public void IframeName(String xpath, String msg) {
		WebElement weEle = getWebElement(xpath);
		driver.switchTo().frame(0);
		try {
		} catch (ElementNotInteractableException e) {
			weEle = driver.findElement(By.xpath(xpath));
			weEle.clear();

		} catch (StaleElementReferenceException e) {
			weEle = driver.findElement(By.xpath(xpath));

		}
		extentloggert.log(Status.INFO, msg);
	}

	// ***************IframeElement*************

	public void IframeElement(ExtentTest extTest, String xpath, String msg) {
		WebElement weEle = getWebElement(xpath);
		driver.switchTo().frame(0);
		try {
		} catch (ElementNotInteractableException e) {
			weEle = driver.findElement(By.xpath(xpath));
			weEle.clear();

		} catch (StaleElementReferenceException e) {
			weEle = driver.findElement(By.xpath(xpath));

		}
		extTest.log(Status.INFO, msg);
	}

	// *********************alart******************

	public void alart(String xpath, String msg) {
		WebElement weEle = getWebElement(xpath);
		driver.switchTo().alert().accept();
		try {
		} catch (ElementNotInteractableException e) {
			weEle = driver.findElement(By.xpath(xpath));
			weEle.clear();

		} catch (StaleElementReferenceException e) {
			weEle = driver.findElement(By.xpath(xpath));

		}
		extentloggert.log(Status.INFO, msg);
	}

	// **********************getExtentReportobject**********************

	public ExtentReports getExtentReportobject() {
		ExtentSparkReporter extenthtml = new ExtentSparkReporter("reports\\result.html");
		ExtentReports extReport = new ExtentReports();
		extReport.attachReporter(extenthtml);
		return extReport;
	}

	// ************StartExtentText*****************

	public void StartExtentText(ExtentReports exReports, String testcaseName) {
		extentloggert = exReports.createTest(testcaseName);

	}

	// **********************WindowHandlsTitle*************************

	public void getWindowHandlsTitle(String expwindowTitle, String msg) {
		Set<String> weHandleValue = driver.getWindowHandles();
		for (String getWindowHandl : weHandleValue) {
			driver.switchTo().window(getWindowHandl);
			String getwindowTitle = driver.getTitle();
			System.out.println(getwindowTitle);
			if (getwindowTitle.equalsIgnoreCase(getwindowTitle))
				;
			break;

		}
		extentlogger.log(Status.INFO, msg);
	}

	// **********************WindowHandlsUrl*************************

	public void getWindowHandlsUrl(String expwindowUrl, String msg) {
		Set<String> weHandleValue = driver.getWindowHandles();
		for (String getWindowHandl : weHandleValue) {
			driver.switchTo().window(getWindowHandl);
			String getwindowUrl = driver.getCurrentUrl();
			System.out.println(getwindowUrl);
			if (getwindowUrl.equalsIgnoreCase(getwindowUrl))
				;
			break;

		}
		extentlogger.log(Status.INFO, msg);
	}

}
