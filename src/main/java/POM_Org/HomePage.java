package POM_Org;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonUtils.WebDriverUtils;

public class HomePage extends WebDriverUtils {
	
	public WebDriver driver;

//	 Identify Organization 
	@FindBy(xpath = "(//a[text()='Organizations'])[1]")
	private WebElement organizations;

//	 Identify Contacts
	@FindBy(xpath = "//a[text()='Contacts']")
	private WebElement contacts;

	// Identify Image
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement image;

	// Identify Signout
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signout;

	/**
	 * @return the organizations
	 */
	public WebElement getOrganizations() {
		return organizations;
	}

	/**
	 * @return the contacts
	 */
	public WebElement getContacts() {
		return contacts;
	}

	/**
	 * @return the image
	 */
	public WebElement getImage() {
		return image;
	}

	/**
	 * @return the signout
	 */
	public WebElement getSignout() {
		return signout;
	}
	// ------------------------------------------------------

	// create constructor -> to initialize the webelement
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// create a method ->to perform the action
	public OrganizationsPage Home() {
		// click on organizations
		organizations.click();
		return new OrganizationsPage(driver);
		}

	// crete method sign out
	public LoginPage Home(WebDriver driver) {
		// mouse hover on image
		mousehover(driver, image);
		// click on sign out button
		signout.click();
		return new LoginPage(driver);
	}
	
	
	//--------------------------------------

//	public ContactsPage HomeContact() {
//		// click on Contacts
//		contacts.click();
//		return new ContactsPage(driver);
//	}

}
