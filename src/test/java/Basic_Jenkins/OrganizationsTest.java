package Basic_Jenkins;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


import CommonUtils.PropertyFileUtils;
import CommonUtils.WebDriverUtils;

public class OrganizationsTest {
	@Test
	public void CreateOrganizationsTest() throws IOException {
//       WebDriver driver= new ChromeDriver();
//       driver.get("http://localhost:8888/");
       
       
        PropertyFileUtils putil = new PropertyFileUtils();
     	WebDriverUtils wutil = new WebDriverUtils();

		WebDriver driver = new ChromeDriver();
		wutil.maximize(driver);
		wutil.implicitlywait(driver);

//   	 To Read the Data From Properties File	
		String URL = putil.getDataFromPropertyFile("Url");
		String USERNAME = putil.getDataFromPropertyFile("Username");
		String PASSWORD = putil.getDataFromPropertyFile("Password");

//   	To Read the Data From Excel File	
//		String ORGNAME = eutil.getDataFromExcel("Organization", 0, 1);
//		String GROUP = eutil.getDataFromExcel("Organization", 1, 1);

		// To launch the Application
		driver.get(URL);

//   	Login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
	}
}
