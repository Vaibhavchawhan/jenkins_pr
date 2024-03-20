package CommonUtils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {

	public WebDriver driver = new ChromeDriver();

//	Declaration is only screenshot
	public static WebDriver sdriver;

	PropertyFileUtils putil = new PropertyFileUtils();
	WebDriverUtils wutil = new WebDriverUtils();

//Step1:
	@BeforeSuite
	public void BS() {
		System.out.println("Connect TO Database");
	}

//Step2:	
	@BeforeClass
	public void BC() throws IOException {
		System.out.println("Launch the Browser");
		String BROWSER = putil.getDataFromPropertyFile("Browser");
		// @before class to launch the apllication
		String URL = putil.getDataFromPropertyFile("Url");

		if (BROWSER.equals("Chrome")) {
			ChromeDriver chromeDriver = new ChromeDriver();
		} else if (BROWSER.equals("Edge")) {
			EdgeDriver edgeDriver = new EdgeDriver();
		} else {
			FirefoxDriver firefoxDriver = new FirefoxDriver();
		}

		wutil.maximize(driver);
		wutil.implicitlywait(driver);

		// re-Initializing is only take screenshot
		sdriver = driver;

		// To launch the Application
		driver.get(URL);
	}

//Step3	:
	@BeforeMethod
	public void BM() throws IOException {
		System.out.println("Login the Application");
		String USERNAME = putil.getDataFromPropertyFile("Username");
		String PASSWORD = putil.getDataFromPropertyFile("Password");

		// Login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
	}

// Step4:
	@AfterMethod
	public void AM() throws InterruptedException {
		System.out.println("After method used LogOut the Application");
//	mouse hover on Image
		Thread.sleep(2000);
		WebElement image = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		wutil.mousehover(driver, image);
//	sign out
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}

// Step5:
	@AfterClass
	public void AC() {
		System.out.println("@after class used close the Browser");
		driver.quit();
	}

// Step6:
	@AfterSuite
	public void AS() {
		System.out.println("DisConnect TO Database");
	}

}
