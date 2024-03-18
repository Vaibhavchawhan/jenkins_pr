package CommonUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtils {
	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void implicitlywait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

//	DropDown
	public void handledropdown(WebElement element, String targetedelement) {
		Select s = new Select(element);
		s.selectByVisibleText(targetedelement);
	}

// MouseHover
	public void mousehover(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element);
		a.perform();
	}

// To transfer the driver control from parent window to child window
	public void swichwindow(WebDriver driver, String expectedurl) {
		Set<String> id = driver.getWindowHandles();

		for (String ele : id) {
			String actualurl = driver.switchTo().window(ele).getCurrentUrl();

			if (actualurl.contains(expectedurl)) {
				break;
			}
		}
	}

//ScreenShot	
	public String screenshot(WebDriver driver, String ScreenshotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File tempfile = ts.getScreenshotAs(OutputType.FILE);
		// To create path To store the Sceenshot Contacts
		File destinationfile = new File("./Screenshot/" + ScreenshotName + ".png");
		FileUtils.copyFile(tempfile, destinationfile);
		return destinationfile.getAbsolutePath();
	}

}
