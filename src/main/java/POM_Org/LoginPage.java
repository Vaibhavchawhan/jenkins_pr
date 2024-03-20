package POM_Org;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;

//	 Identify Username TF
	@FindBy(name = "user_name")
	private WebElement usernametf;

//	 Identify Password TF
	@FindBy(name = "user_password")
	private WebElement passwordtf;

//	 Identify Login button  
	@FindBy(id = "submitButton")
	private WebElement loginbtn;

	/**
	 * @return the usernametf
	 */
	public WebElement getUsernametf() {
		return usernametf;
	}

	/**
	 * @return the passwordtf
	 */
	public WebElement getPasswordtf() {
		return passwordtf;
	}

	/**
	 * @return the loginbtn
	 */
	public WebElement getLoginbtn() {
		return loginbtn;
	}
	//------------------------------------------------------------

	// Create a Constructor -> to initialize webelement
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Create a method -> to perform the action
	public HomePage Login(String uSERNAMEdata, String pASSWORDdata) {
		usernametf.sendKeys(uSERNAMEdata);
		passwordtf.sendKeys(pASSWORDdata);
		loginbtn.click();
		return new HomePage(driver);
	}

}
