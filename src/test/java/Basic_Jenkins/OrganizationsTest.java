package Basic_Jenkins;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import CommonUtils.ExcelUtils;
import CommonUtils.JavaUtils;
import CommonUtils.PropertyFileUtils;
import CommonUtils.WebDriverUtils;
import CommonUtils.listenerImplimation;

@Listeners(listenerImplimation.class)
public class OrganizationsTest {
	@Test
	public void CreateOrganizationsTest() throws IOException, InterruptedException {
//       WebDriver driver= new ChromeDriver();
//       driver.get("http://localhost:8888/");
       
       
        PropertyFileUtils putil = new PropertyFileUtils();
     	WebDriverUtils wutil = new WebDriverUtils();
     	ExcelUtils eutil = new ExcelUtils();
    	JavaUtils jutil = new JavaUtils();

		WebDriver driver = new ChromeDriver();
		wutil.maximize(driver);
		wutil.implicitlywait(driver);

//   	 To Read the Data From Properties File	
		String URL = putil.getDataFromPropertyFile("Url");
		String USERNAME = putil.getDataFromPropertyFile("Username");
		String PASSWORD = putil.getDataFromPropertyFile("Password");

//   	To Read the Data From Excel File	
		String ORGNAME = eutil.getDataFromExcel("Organization", 0, 1);
		String GROUP = eutil.getDataFromExcel("Organization", 1, 1);

		// To launch the Application
		driver.get(URL);

//   	Login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
	//   click on organization
			driver.findElement(By.xpath("//a[text()='Organizations'][1]")).click();
//		click on create organization (+)
			driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();
	//  Enter Organization name
			driver.findElement(By.name("accountname")).sendKeys(ORGNAME + jutil.getRandomNumber());
	//  In Assigned To Click on group
			driver.findElement(By.cssSelector("input[value='T']")).click();
//			In the Drop Down Select Support Group
			WebElement dropdown = driver.findElement(By.name("assigned_group_id"));
			wutil.handledropdown(dropdown, GROUP);
	//   Click on save Button
			driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
//			Mousehover on Image
			Thread.sleep(2000);
			WebElement image = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			wutil.mousehover(driver, image);
			
//			sign out
			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		}
	}

