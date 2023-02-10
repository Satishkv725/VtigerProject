package Automation;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GenaricLayer {
	WebDriver driver;
	ExtentTest ext;
	ExtentReports er;

	// ******************takeExtentTestReport*******************//

	public ExtentReports takeExtentTestReport() {
		String timeStamp = getDateTime();
		ExtentSparkReporter esr = new ExtentSparkReporter("report/vitiger" + timeStamp + ".html");
		er = new ExtentReports();
		er.attachReporter(esr);
		return er;
	}

	public void createTest(String testCaseName) {
		try {		
			ext = er.createTest(testCaseName);
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	public void flush() {
		er.flush();
	}

	// ******************takeScreenShot************************//

	public void takeScreenShot(String elementName) {
		String timeStamp = getDateTime();
		TakesScreenshot tss = (TakesScreenshot) driver;
		File from = tss.getScreenshotAs(OutputType.FILE);
		File to = new File("ScrrenShot/" + elementName + timeStamp + ".png");
		try {
			FileUtils.copyFile(from, to);
			ext.log(Status.INFO, "file copy our destination is successfuly");
		} catch (IOException e) {
			e.printStackTrace();
			ext.log(Status.INFO, "file  copy our destination is not successfuly");
		}

	}

	// ******************getDateTime*******************//

	public String getDateTime() {
		DateFormat df = new SimpleDateFormat("MM_dd_yyy__hh__mm__ss");
		String timeStamp = df.format(new Date());
		return timeStamp;
	}

	// ******************openUrl*******************//

	public void openUrl(String url) {
		try {
			
			driver.get(url);
			ext.log(Status.INFO, url + " open successfully");
		} catch (Exception e) {
			e.printStackTrace();
			ext.log(Status.INFO, url + "is not open successfully");
		}
	}

	// ******************getUrl*******************//

	public String getUrl() {
		String urlText = null;
		try {
			urlText = driver.getCurrentUrl();
			System.out.println(urlText);
			ext.log(Status.INFO, " should be derived url  successfully");
		} catch (Exception e) {
			e.printStackTrace();
			ext.log(Status.FAIL, "should not be derived url successfully");
		}
		return urlText;
	}

	// ******************lanchBrowser*******************//

	public WebDriver lanchBrowser(String browserName, String elementName) {

		try {
			if (browserName.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				ext.log(Status.INFO, "Browser lanch successfully");
			} else if (browserName.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				ext.log(Status.INFO, "Browser lanch successfully");
			} else if (browserName.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				ext.log(Status.INFO, "Browser lanch successfully");
			} else if (browserName.equalsIgnoreCase("ie")) {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				ext.log(Status.INFO, "Browser lanch successfully");
			}
		} catch (Exception e) {
			takeScreenShot(elementName);
			ext.log(Status.INFO, "Browser is not lanch successfully");
		}
		return driver;
	}

	// ******************getLocatorWebElement*******************//

	public WebElement getLocatorWebElement(String locatorName, String locatorValue) {
		WebElement we = null;
		if (locatorName.equalsIgnoreCase("xpath")) {
			we = driver.findElement(By.xpath(locatorValue));
		} else if (locatorName.equalsIgnoreCase("id")) {
			we = driver.findElement(By.id(locatorValue));
		} else if (locatorName.equalsIgnoreCase("name")) {
			we = driver.findElement(By.name(locatorName));
		} else if (locatorName.equalsIgnoreCase("class")) {
			we = driver.findElement(By.className(locatorValue));
		} else if (locatorName.equalsIgnoreCase("linkText")) {
			we = driver.findElement(By.linkText(locatorValue));
		} else if (locatorName.equalsIgnoreCase("css")) {
			we = driver.findElement(By.cssSelector(locatorValue));
		} else {
			ext.log(Status.FAIL, "you are enter worng" + locatorName + "or" + locatorValue + "name please check our "
					+ locatorName + "or" + locatorValue + "name try again");
		}
		return we;
	}

	// ******************getLocatorWebElementList*******************//

	public List<WebElement> getLocatorWebElementList(String locatorName, String locatorValue) {
		List<WebElement> we = null;
		if (locatorName.equalsIgnoreCase("xpath")) {
			we = driver.findElements(By.xpath(locatorValue));
		} else if (locatorName.equalsIgnoreCase("id")) {
			we = driver.findElements(By.id(locatorValue));
		} else if (locatorName.equalsIgnoreCase("name")) {
			we = driver.findElements(By.name(locatorName));
		} else if (locatorName.equalsIgnoreCase("class")) {
			we = driver.findElements(By.className(locatorValue));
		} else if (locatorName.equalsIgnoreCase("linkText")) {
			we = driver.findElements(By.linkText(locatorValue));
		} else if (locatorName.equalsIgnoreCase("css")) {
			we = driver.findElements(By.cssSelector(locatorValue));
		} else {
			ext.log(Status.FAIL, "you are enter worng" + locatorName + "or" + locatorValue + "name please check our "
					+ locatorName + "or" + locatorValue + "name try again");
		}
		return we;
	}

	// ******************checkElement*******************//

	public boolean checkElement(WebElement we, String elementName) {
		boolean status = false;
		if (we.isDisplayed() == true) {
			ext.log(Status.INFO, elementName + "test box is visible");
			if (we.isEnabled() == true) {
				ext.log(Status.INFO, elementName + "test box is clickable");
				status = true;
			} else {
				ext.log(Status.FAIL, elementName + "test box is not clickable");
			}
		} else {
			ext.log(Status.FAIL, elementName + "test box is not visible");
		}
		return status;
	}

	// ******************enterTextboxValue*******************//

	public void enterTextboxValue(String locatorType, String locatorValue, String elementName, String elementValue) {
		try {
			WebElement we = getLocatorWebElement(locatorType, locatorValue);
			boolean st = checkElement(we, elementName);
			we.clear();
			we.sendKeys(elementValue);
			ext.log(Status.INFO, elementName + "enter text box value perform is successfully");
		} catch (Exception e) {
			takeScreenShot(elementName);
			e.printStackTrace();
			ext.log(Status.FAIL, elementName + "enter text box value perform is NOT successfully");
		}
	}

	// ******************click*******************//

	public void click(String locatorType, String locatorValue, String elementName) {
		try {
			WebElement we = getLocatorWebElement(locatorType, locatorValue);
			boolean st = checkElement(we, elementName);
			we.click();
			ext.log(Status.INFO, elementName + "click method  perform is successfully");
		} catch (Exception e) {
			ext.log(Status.INFO, elementName + " click performed is not successfully");
			takeScreenShot(elementName);
			e.printStackTrace();
		}
	}

	// ******************actionSenkeys*******************//

	public void actionSenkeys(String locatorType, String locatorValue, String elementName, String elementValue) {
		try {
			WebElement we = getLocatorWebElement(locatorType, locatorValue);
			boolean st = checkElement(we, elementName);
			we.clear();
			Actions act = new Actions(driver);
			act.sendKeys(elementValue).perform();
			ext.log(Status.INFO, elementName + "enter text box value with help of ActionClass perform is successful");
		} catch (Exception e) {
			takeScreenShot(elementName);
			e.printStackTrace();
			ext.log(Status.FAIL,
					elementName + "enter text box value with help of ActionClass perform is NOT successful");
		}
	}

	// ******************actionClick*******************//

	public void actionClick(String locatorType, String locatorValue, String elementName) {
		try {
			WebElement we = getLocatorWebElement(locatorType, locatorValue);
			boolean st = checkElement(we, elementName);
			Actions act = new Actions(driver);
			act.click().perform();
			ext.log(Status.INFO, "Actions click method  perform is successfully");
		} catch (Exception e) {
			ext.log(Status.INFO, "Actions click performed is not successfully");
			takeScreenShot(elementName);
			e.printStackTrace();
		}
	}

	// ******************actionDoubleClick*******************//

	public void actionDoubleClick(String locatorType, String locatorValue, String elementName) {
		try {
			WebElement we = getLocatorWebElement(locatorType, locatorValue);
			boolean st = checkElement(we, elementName);
			Actions act = new Actions(driver);
			act.click().perform();
			ext.log(Status.INFO, "Actions click method  perform is successfully");
		} catch (Exception e) {
			ext.log(Status.INFO, "Actions click performed is not successfully");
			takeScreenShot(elementName);
			e.printStackTrace();
		}
	}

	// ******************actionMouseOver*******************//

	public void actionMouseOver(String locatorType, String locatorValue, String elementName) {
		try {
			WebElement we = getLocatorWebElement(locatorType, locatorValue);
			boolean st = checkElement(we, elementName);
			Actions act = new Actions(driver);
			act.moveToElement(we).build().perform();
			ext.log(Status.INFO, "Actions actionMouseOver  perform is successfully");
		} catch (Exception e) {
			ext.log(Status.INFO, "Actions actionMouseOver performed is not successfully");
			takeScreenShot(elementName);
			e.printStackTrace();
		}
	}

	// ******************actionRightClick*******************//

	public void actionRightClick(String locatorType, String locatorValue, String elementName) {
		try {
			WebElement we = getLocatorWebElement(locatorType, locatorValue);
			boolean st = checkElement(we, elementName);
			Actions act = new Actions(driver);
			act.contextClick(we).build().perform();
			ext.log(Status.INFO, "Actions actionRightClick  perform is successfully");
		} catch (Exception e) {
			ext.log(Status.INFO, "Actions actionRightClick performed is not successfully");
			takeScreenShot(elementName);
			e.printStackTrace();
		}
	}

	// ******************getInnerText*******************//

	public String getInnerText(String locatorType, String locatorValue, String elementName) {
		String innerText = null;
		try {
			WebElement we = getLocatorWebElement(locatorType, locatorValue);
			boolean st = checkElement(we, elementName);
			innerText = we.getText();
			System.out.println(innerText);
			ext.log(Status.INFO, "innerText derived is successfully");
		} catch (Exception e) {
			takeScreenShot(elementName);
			e.printStackTrace();
			ext.log(Status.FAIL, "innerText does not derived  successfully");
		}
		return innerText;
	}

	// ******************getSelectValue*******************//

	public void getSelectValue(String locatorType, String locatorValue, String elementName, String selectValueText) {
		try {
			WebElement we = getLocatorWebElement(locatorType, locatorValue);
			boolean st = checkElement(we, elementName);

			if (st == true) {
				Select selObj = new Select(we);
				selObj.selectByValue(selectValueText);
				ext.log(Status.INFO, "fetch selectByValue successfully");
			}
		} catch (Exception e) {
			takeScreenShot(elementName);
			e.printStackTrace();
			ext.log(Status.FAIL, "we can not get selectByValue successfuly");
		}
	}

	// ******************getSelectIndex*******************//

	public void getSelectIndex(String locatorType, String locatorValue, String elementName, int selectIndex) {
		try {
			WebElement we = getLocatorWebElement(locatorType, locatorValue);
			boolean st = checkElement(we, elementName);

			if (st == true) {
				Select selObj = new Select(we);
				selObj.selectByIndex(selectIndex);
				ext.log(Status.INFO, "fetch selectByIndex successfully");
			}
		} catch (Exception e) {
			takeScreenShot(elementName);
			e.printStackTrace();
			ext.log(Status.FAIL, "we can not get selectByIndex successfuly");
		}
	}

	// ******************getSelectVisibleText*******************//

	public void getSelectVisibleText(String locatorType, String locatorValue, String elementName,
			String selectVisibleText) {
		try {
			WebElement we = getLocatorWebElement(locatorType, locatorValue);
			boolean st = checkElement(we, elementName);
			if (st == true) {
				Select selObj = new Select(we);
				selObj.selectByVisibleText(selectVisibleText);
				ext.log(Status.INFO, "fetch selectVisibleText successfully");
			}
		} catch (Exception e) {
			takeScreenShot(elementName);
			e.printStackTrace();
			ext.log(Status.FAIL, "we can not get selectVisibleText successfuly");
		}
	}

	// ******************getDropdownItemCount*******************//

	public String getDropdownItemCount(String locatorType, String locatorValue, String elementNeme) {
		String text = null;
		try {
			List l = null;
			WebElement we = getLocatorWebElement(locatorType, locatorValue);
			boolean st = checkElement(we, elementNeme);
			Select selObj = new Select(we);
			List<WebElement> sel = selObj.getOptions();
			for (int i = 0; i <= sel.size() - 1; i++) {
				WebElement web = sel.get(i);
				text = web.getText();
				l.add(text);
			}
			ext.log(Status.INFO, "DropDown Elements are :-" + l);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot(elementNeme);
			ext.log(Status.FAIL, "DropDown Elements are not getOption");
		}
		return text;
	}

	// ******************selectGetFirstSelectedOption*******************//

	public String selectGetFirstSelectedOption(String locatorType, String locatorValue, String elementName) {
		String text = null;
		try {
			WebElement we = getLocatorWebElement(locatorType, locatorValue);
			boolean st = checkElement(we, elementName);
			Select selObj = new Select(we);
			WebElement weOption = selObj.getFirstSelectedOption();
			text = weOption.getText();
			ext.log(Status.INFO, "fetch GetFirstSelectedOption successfuly");
		} catch (Exception e) {
			takeScreenShot(elementName);
			e.printStackTrace();
			ext.log(Status.FAIL, "we can not get selectGetFirstSelectedOption successfuly");
		}
		return text;
	}

	// ******************selectGetAllSelectedOption*******************//

	public String selectGetAllSelectedOption(String locatorType, String locatorValue, String elementName) {
		String text = null;
		try {
			List l = null;
			WebElement we = getLocatorWebElement(locatorType, locatorValue);
			boolean st = checkElement(we, elementName);
			Select selObj = new Select(we);
			List<WebElement> sel = selObj.getAllSelectedOptions();
			for (int i = 0; i <= sel.size() - 1; i++) {
				WebElement web = sel.get(i);
				text = web.getText();
				l.add(text);
				ext.log(Status.INFO, "to allSelectedOption is :-" + l);
			}
		} catch (Exception e) {
			takeScreenShot(elementName);
			e.printStackTrace();
			ext.log(Status.FAIL, "we can not get all select option successfuly");
		}
		return text;
	}

	// ******************getAttributeValue*******************//

	public String getAttributeValue(String locatorType, String locatorValue, String elementName, String attributeName) {
		String attribute = null;
		try {
			WebElement we = getLocatorWebElement(locatorType, locatorValue);
			boolean st = checkElement(we, elementName);
			attribute = we.getAttribute(attributeName);
			System.out.println(attribute);
			ext.log(Status.INFO, "Fetched attribute value successfully");
		} catch (Exception e) {
			takeScreenShot(elementName);
			e.printStackTrace();
			ext.log(Status.FAIL, "do not Fetched attribute value successfully and take Scrrenshot");
		}
		return attribute;
	}

	// ******************getSize*******************//

	public Dimension getSize(String locatorType, String locatorValue, String elementName) {
		Dimension size = null;
		try {
			WebElement we = getLocatorWebElement(locatorType, locatorValue);
			boolean st = checkElement(we, elementName);
			if (st == true) {
				size = we.getSize();
				int ht = size.getHeight();
				int wi = size.getWidth();
				System.out.println(size);
				ext.log(Status.INFO,
						"Size of" + elementName + "Height is" + ht + "Width is" + wi + "Fetched successfully");
			}else {
				ext.log(Status.INFO,
						"Size of" + elementName + "Height and Width is not Fetched successfully");
			}
		} catch (Exception e) {
			takeScreenShot(elementName);
			e.printStackTrace();
			ext.log(Status.FAIL, "Size of" + elementName + "Should not be Fetched successfully");
		}
		return size;
	}

	// ******************getLocation*******************//

	public Point getLocation(String locatorType, String locatorValue, String elementName) {
		Point location = null;
		try {
			WebElement we = getLocatorWebElement(locatorType, locatorValue);
			boolean st = checkElement(we, elementName);
			if (st == true) {
				location = we.getLocation();
				int xValue = location.getX();
				int yValue = location.getY();
				System.out.println(location);
				ext.log(Status.INFO,
						"Location Size of" + elementName + "x--" + xValue + "y--" + yValue + "Fetched successfully");
			}else {
				ext.log(Status.INFO,
						"Location Size of" + elementName + "x-Value-" +"And-"+ "y-Value- not Fetched successfully");
			}
		} catch (Exception e) {
			takeScreenShot(elementName);
			e.printStackTrace();
			ext.log(Status.FAIL, "Location Size of is not Fetched successfully " + elementName);
		}
		return location;
	}

	// ******************validateGetLocation*******************//

	public void validateGetLocation(String locatorType, String locatorValue, String elementName, int xValue,
			int yValue) {

		Point expectedLocation = new Point(xValue, yValue);
		Point actualLocation = getLocation(locatorType, locatorValue, elementName);

		try {
			if (actualLocation.equals(expectedLocation)) {
				System.out.println("Matched");
				ext.log(Status.INFO, "Match Location Size " + actualLocation + "x--" + xValue + "y--" + yValue
						+ "--to--" + expectedLocation + "is successfully");
			} else {
				System.out.println("Miss-Matched");
				ext.log(Status.INFO, "Match Location Size " + actualLocation + "x--" + xValue + "y--" + yValue
						+ "--to--" + expectedLocation + "is not successfully");
			}
		} catch (Exception e) {
			takeScreenShot(elementName);
			ext.log(Status.FAIL, actualLocation + "  is not Match" + expectedLocation + " successfully " + elementName);

		}
	}

	// ******************validateGetSize*******************//

	public void validateGetSize(String locatorType, String locatorValue, String elementName, int wi, int ht) {
		Dimension expectedSize = new Dimension(wi, ht);
		Dimension actualSize = getSize(locatorType, locatorValue, elementName);
		try {

			if (actualSize.equals(expectedSize)) {
				System.out.println("Matched");
				ext.log(Status.INFO, actualSize + "actual size is match expected size -->" + expectedSize);
			} else {
				System.out.println("Miss-Matched");
				ext.log(Status.INFO, actualSize + "actual size is not  match expected size -->" + expectedSize);
			}
		} catch (Exception e) {
			takeScreenShot(elementName);
			ext.log(Status.FAIL, actualSize + "actual size is not match expected size -->" + expectedSize);

		}
	}

	// ******************validateText*******************//

	public void validateText(String locatorType, String locatorValue, String expectedText, String elementName) {
		try {
			String actualText = getInnerText(locatorType, locatorValue, elementName);
			if (actualText.equalsIgnoreCase(expectedText)) {
				ext.log(Status.INFO, elementName + "text validate pass -->" + actualText);
			} else {
				ext.log(Status.FAIL, elementName + "text validate failed " + actualText);
			}
		} catch (Exception e) {
			takeScreenShot(elementName);
		}
	}

	// ******************validateElementVisible*******************//

	public void validateElementVisible(String locatorType, String locatorValue, String elementName) {
		WebElement we = getLocatorWebElement(locatorType, locatorValue);
		boolean status = we.isDisplayed();
		if (status == true) {
			ext.log(Status.INFO, elementName + "is visible");
		} else {
			ext.log(Status.FAIL, elementName + "is not visible");
		}
	}

	// ******************validateElementNotVisible*******************//

	public void validateElementNotVisible(String locatorType, String locatorValue, String elementName) {
		WebElement we = getLocatorWebElement(locatorType, locatorValue);
		boolean status = we.isDisplayed();
		if (status == false) {
			ext.log(Status.INFO, elementName + "is NotVisible");
		} else {
			ext.log(Status.FAIL, elementName + "is visible");
		}
	}

	// ******************validateElementIsEnable*******************//

	public void validateElementIsEnable(String locatorType, String locatorValue, String elementName) {
		WebElement we = getLocatorWebElement(locatorType, locatorValue);
		boolean status = we.isEnabled();
		if (status == true) {
			ext.log(Status.INFO, elementName + "is Enable");
		} else {
			ext.log(Status.FAIL, elementName + "is Disable");
		}
	}

	// ******************validateElementIsDisable*******************//

	public void validateElementIsDisable(String locatorType, String locatorValue, String elementName) {
		WebElement we = getLocatorWebElement(locatorType, locatorValue);
		boolean status = we.isEnabled();
		if (status == false) {
			ext.log(Status.INFO, elementName + "is Disable");
		} else {
			ext.log(Status.FAIL, elementName + "is enable");
		}
	}

	// ******************validateTitle*******************//

	public void validateTitle(String expectedTitle) {
		String actualTitle = driver.getTitle();
		if (actualTitle.equalsIgnoreCase(expectedTitle)) {
			ext.log(Status.INFO, "this is the curent page Title is match---> " + actualTitle);
		} else {
			ext.log(Status.FAIL, "this is the curent page Title is not match---> " + actualTitle);
		}
	}

	// ******************getTitle*******************//

	public String getTitle() {
		String actualTitle = null;
		try {
			actualTitle = driver.getTitle();
			ext.log(Status.INFO, "fetched title succesful");
		} catch (Exception e) {
			e.printStackTrace();
			ext.log(Status.FAIL, "fetched title is not succesful");
		}
		return actualTitle;
	}

	// ******************setImplicityWait*******************//

	public void setImplicityWait(int timeOutInSecond) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOutInSecond));
			ext.log(Status.INFO, "ImplicityWait apply successful");

		} catch (Exception e) {
			e.printStackTrace();
			ext.log(Status.FAIL, "ImplicityWait apply is not successful");
		}
	}

	// ******************waitForVisibility*******************//

	public void waitForVisibility(By locator, int timeOutInSecond) {
		try {
			WebDriverWait wait = (WebDriverWait) driver.manage().timeouts()
					.implicitlyWait(Duration.ofSeconds(timeOutInSecond));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			ext.log(Status.INFO, "");
		} catch (Exception e) {
			e.printStackTrace();
			ext.log(Status.FAIL, "");
		}
	}

	// ******************waitForInVisibility*******************//

	public void waitForInVisibility(By locator, int timeOutInSecond) {
		try {
			WebDriverWait wait = (WebDriverWait) driver.manage().timeouts()
					.implicitlyWait(Duration.ofSeconds(timeOutInSecond));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
			ext.log(Status.INFO, "");
		} catch (Exception e) {
			e.printStackTrace();
			ext.log(Status.FAIL, "");
		}
	}

	// ******************uploadFile*******************//

	public void uploadFile(String locatorType, String locatorValue, String uploadLocationPath) {
		try {
			WebElement ob = getLocatorWebElement(locatorType, locatorValue);
			ob.sendKeys(uploadLocationPath);
			ext.log(Status.INFO, "file upload successful");
		} catch (Exception e) {
			e.printStackTrace();
			ext.log(Status.FAIL, "file upload is not successful");
		}
	}

	// ******************AlertText*******************//

	public void AlertText(String allertText) {
		try {
			driver.switchTo().alert().sendKeys(allertText);
			ext.log(Status.INFO, "Send alert text successful");
		} catch (Exception e) {
			e.printStackTrace();
			ext.log(Status.FAIL, "Send alert text is not successful");
		}
	}

	// ******************getAlertText*******************//

	public String getAlertText() {
		String getText = null;
		try {
			getText = driver.switchTo().alert().getText();
			ext.log(Status.INFO, "get alert text derived successful");
		} catch (Exception e) {
			e.printStackTrace();
			ext.log(Status.FAIL, "get alert text derived is not successful");
		}
		return getText;
	}

	// ******************acceptAlert*******************//

	public void acceptAlert() {
		try {
			driver.switchTo().alert().accept();
			ext.log(Status.INFO, "accept alert successful");
		} catch (Exception e) {
			e.printStackTrace();
			ext.log(Status.FAIL, "accept alert is not successful");
		}
	}

	// ******************dismisAlert*******************//

	public void dismisAlert() {
		try {
			driver.switchTo().alert().dismiss();
			ext.log(Status.INFO, "dismiss alert successful");
		} catch (Exception e) {
			e.printStackTrace();
			ext.log(Status.FAIL, "dismiss alert is not successful");
		}
	}

	// ******************getCheckBoxStatus*******************//

	public void getCheckBoxStatus(String locatorType, String locatorValue, String elementName) {
		try {
			WebElement we = getLocatorWebElement(locatorType, locatorValue);
			boolean web = checkElement(we, elementName);
			if (web == true) {
				we.isSelected();
				ext.log(Status.INFO, "check the radio button And CheckBox is successful");
			}
		} catch (Exception e) {
			e.printStackTrace();
			ext.log(Status.FAIL, "check the radio button And CheckBox is not successful");

		}
	}

	// ******************closeBrowser*******************//

	public void closeBrowser() {
		try {
			driver.close();
			ext.log(Status.INFO, "close current window is successful");
		} catch (Exception e) {
			e.printStackTrace();
			ext.log(Status.FAIL, "close current window is not successful");
		}
	}

	// ******************quitBrowser*******************//

	public void quitBrowser() {
		try {
			driver.quit();
			ext.log(Status.INFO, "close All window is successful");
		} catch (Exception e) {
			e.printStackTrace();
			ext.log(Status.FAIL, "close All window is not successful");
		}
	}

	// ******************switchToFrameByIndex*******************//

	public void switchToFrameByIndex(int index) {
		try {
			driver.switchTo().frame(index);

			ext.log(Status.INFO, "");
		} catch (Exception e) {
			e.printStackTrace();
			ext.log(Status.FAIL, "");
		}
	}

	// ******************switchToFrameBySting*******************//

	public void switchToFrameBySting(String frameName) {
		try {
			driver.switchTo().frame(frameName);
			ext.log(Status.INFO, "");
		} catch (Exception e) {
			e.printStackTrace();
			ext.log(Status.FAIL, "");
		}
	}

	// ******************switchToFrameByWebElement*******************//

	public void switchToFrameByWebElement(WebElement frameElement) {
		try {
			driver.switchTo().frame(frameElement);
			ext.log(Status.INFO, "");
		} catch (Exception e) {
			e.printStackTrace();
			ext.log(Status.FAIL, "");
		}
	}

	// ******************backToFrame*******************//

	public void backToFrame() {
		try {
			driver.switchTo().defaultContent();
			ext.log(Status.INFO, "");
		} catch (Exception e) {
			e.printStackTrace();
			ext.log(Status.FAIL, "");
		}
	}

	// ******************switchToParentFrame*******************//

	public void switchToParentFrame() {
		try {
			driver.switchTo().parentFrame();
			ext.log(Status.INFO, "");
		} catch (Exception e) {
			e.printStackTrace();
			ext.log(Status.FAIL, "");
		}
	}

	// ******************getCssValueBackgroundColor*******************//

	public void getCssValueBackgroundColor(String locatorType, String locatorValue, String codeOfColorElement) {
		try {
			String getColorElement = getLocatorWebElement(locatorType, locatorValue).getCssValue("background-color");
			String colorElement = Color.fromString(getColorElement).asHex();

			if (colorElement.equals(codeOfColorElement)) {
				ext.log(Status.INFO, "  background-color--Test is verified ");
			}
		} catch (Exception e) {
			e.printStackTrace();
			ext.log(Status.FAIL, "  background-color--Test is not verified ");
		}
	}

	// ******************getCssValueElementTextColor*******************//

	public void getCssValueElementTextColor(String locatorType, String locatorValue, String codeOfColorText) {
		try {
			String getColorText = getLocatorWebElement(locatorType, locatorValue).getCssValue("color");
			String colorText = Color.fromString(getColorText).asHex();
			if (colorText.equals(codeOfColorText)) {
				ext.log(Status.INFO, " Inner Text color--Test is verified ");
			}
		} catch (Exception e) {
			e.printStackTrace();
			ext.log(Status.FAIL, " Inner Text color--Test is not verified ");
		}
	}

	// ******************switchToWindowByTitle*******************//

	public void switchToWindowByTitle(String expectedUrl) {
		try {
			Set<String> windowsHandle = driver.getWindowHandles();
			for (String handle : windowsHandle) {
				driver.switchTo().window(handle);
				String actualTitle = driver.getTitle();
				if (actualTitle.equalsIgnoreCase(expectedUrl)) {
					break;
				}
			}
			ext.log(Status.INFO, "Switch to windows succesfully");
		} catch (Exception e) {
			e.printStackTrace();
			ext.log(Status.FAIL, "Do not Switch to windows succesfully");
		}
	}

	// ******************switchToWindowByUrl*******************//

	public void switchToWindowByUrl(String expectedUrl) {
		try {
			Set<String> windowsHandle = driver.getWindowHandles();
			for (String handle : windowsHandle) {
				driver.switchTo().window(handle);
				String actualUrl = driver.getCurrentUrl();
				if (actualUrl.equalsIgnoreCase(expectedUrl)) {
					break;
				}
			}
			ext.log(Status.INFO, "Switch to windows succesfully");
		} catch (Exception e) {
			e.printStackTrace();
			ext.log(Status.FAIL, "Do not Switch to windows succesfully");
		}
	}

	// ******************setDownloadFolder*******************//

	public void setDownloadFolder() {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
