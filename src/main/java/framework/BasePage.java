
package framework;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasePage {
	static Logger logger = LoggerFactory.getLogger(BasePage.class);

	protected AndroidDriver<AndroidElement> driver;
	protected WebDriverWait wait;
	protected List<AndroidElement> list = new ArrayList<AndroidElement>();

	public BasePage(AndroidDriver<AndroidElement> aDriver) {
		this.driver = aDriver;
		wait = new WebDriverWait(aDriver, 15);
	}

	protected void clickUsingTextContains(String txt) {
		logger.debug("Inside clickUsingTextContains function ");
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\""+txt+"\")")).click();

	}


	protected void clickUsingIDContains(String resourceId) {
		logger.debug("Inside clickUsingIDContains function ");
		wait.
		until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id(resourceId)))
		.click();				


	}

	protected void clickUsingAccessibilityID(String contentdescript) {
		logger.debug("Inside clickUsingIDContains function ");
		wait.
		until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId((contentdescript))))
		.click();				


	}



	protected List<AndroidElement> textMatchces(String regex) {
		logger.debug("Inside clickUsingIDContains function ");
		
		list  = driver.findElementsByAndroidUIAutomator("new UiSelector().textMatches(\"\\w+\\s{1}\\w+\")");

		return list;

	}
	
	protected void pressAndHold(String resourceId) {


		TouchAction action = new TouchAction(driver);
		action.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(driver.findElement(By.id(resourceId))))
				.withDuration(Duration.ofSeconds(2))).release().perform();

	}


	protected void enterText(String xpath, String txt) {
		logger.debug("Inside clickUsingIDContains function ");

		wait.
		until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath(xpath)))
		.clear();

		wait.
		until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath(xpath)))
		.sendKeys(txt);;				


	}



	public boolean isElementPresentOnScreen(String elementText) {

		return wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"" + elementText + "\")")))
				.isDisplayed();
	}

	protected void sendText(String text, String searchItemName) {
		logger.debug("Inside sendText function");
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + text + "\")")))
		.sendKeys(searchItemName);

	}


	protected void sendTextTo(String xpath, String searchItemName) {

		logger.debug("Inside sendText function");
	    driver.findElementByXPath(xpath).sendKeys(searchItemName);

	}
	public void pressKey(String keyEvent) {
		logger.debug("Inside pressKey function");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));

	}

	public void hideKeyBoard() {
		logger.debug("Inside pressKey function");
		driver.hideKeyboard();

	}

	protected String getText(By locator, int index) {
		return driver.findElements(locator).get(index).getText();
	}


	protected void findElementsAndClick(String locator, int index){

		list = driver.findElements(By.id(locator));
		list.get(index).click();

	}

	protected void clickUsingXpath(String xpath){

		driver.findElementByXPath(xpath).click();

	}

	protected List<AndroidElement> findElementsAndClickOnIt(String className){

		list = driver.findElements(By.className(className));

		return list;

	}

	protected List<AndroidElement> findElementsById(String id){


		//System.out.println(id);
		list = driver.findElements(MobileBy.id(id));

		return list;

	}


	protected List<AndroidElement> findElementsByXpath(String xpath){



		list = driver.findElements(MobileBy.xpath(xpath));

		return list;

	}

	protected String getToastMessage(){



		return driver.findElementByXPath("//android.widget.Toast").getAttribute("name");


	}


	public void scrollTo() throws InterruptedException {


		System.out.println("Scrolling started ---------------------------------------");

		Dimension size = driver.manage().window().getSize();
        System.out.println(size);

        int startx = size.getWidth() / 2;
        int starty = (int) (size.getHeight() * 0.5);
        int endy = (int) (size.getHeight() * 0.8);
        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(startx, starty)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(startx, endy)).release().perform();
        TimeUnit.SECONDS.sleep(5);




	}

	public void scrolltoElementAndDontClick(String txt) {
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\""+txt+"\"))"));
	}
	
	
	public void scrolltoElementAndClick(String txt) {
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\""+txt+"\"))")).click();
	}
	
	public void scrolltoElementAndtClick(String txt) {
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\""+txt+"\"))")).click();
	}

	public void scrolltoElement(String txt) {
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\""+txt+"\"))")).click();
	}
	public ScreenOrientation getCurrentOrientation() {
		return driver.getOrientation();
	}

	public void setScreenRotationToPortrait() {
		driver.rotate(ScreenOrientation.PORTRAIT);
	}

	public void setScreenRotationToLandscape() {
		driver.rotate(ScreenOrientation.LANDSCAPE);
	}	

	public static Properties readInputData(String inputFilePath) {
		File file = new File(inputFilePath);


		FileInputStream inputStream = null;

		try {
			inputStream = new FileInputStream(file.getAbsolutePath());
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
		}

		Properties properties = new Properties();

		try {
			properties.load(inputStream);
		} catch (IOException e) {
			logger.error(e.getMessage());		}
		return properties;

	}

}
