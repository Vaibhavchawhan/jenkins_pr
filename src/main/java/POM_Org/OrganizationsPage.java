package POM_Org;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	public WebDriver driver;

	// click on create organization (+)
	@FindBy(xpath = "(//img[@title='Create Organization...'])")
	private WebElement Createorg;

	/**
	 * @return the createorg
	 */
	public WebElement getCreateorg() {
		return Createorg;
	}

	//create paramitrize constructor
	public OrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Create a method
	public OrganizationInformationPage Organizations() {
		// click on create org....(+)
		Createorg.click();
		return new OrganizationInformationPage(driver);

	}
}
