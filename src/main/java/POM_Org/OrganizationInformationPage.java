package POM_Org;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonUtils.WebDriverUtils;

public class OrganizationInformationPage {
	public WebDriver driver;

	WebDriverUtils wutil = new WebDriverUtils();

	// Identify Organization Name
	@FindBy(name = "accountname")
	private WebElement organizationnametf;

	// Identify Group Radio button
	@FindBy(xpath = "(//input[@name='assigntype'])[2]")
	private WebElement groupbtn;

	// Identify DropDown
	@FindBy(name = "assigned_group_id")
	private WebElement dropdown;

	// Identify Save Button
	@FindBy(xpath = "(//input[@name='button'])[1]")
	private WebElement savebtn;

	// Identify Image
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement image;

	// Identify Signout
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signout;

	/**
	 * @return the savebtn
	 */
	public WebElement getSavebtn() {
		return savebtn;
	}

	/**
	 * @return the dropdown
	 */
	public WebElement getDropdown() {
		return dropdown;
	}

	/**
	 * @return the groupbtn
	 */
	public WebElement getGroupbtn() {
		return groupbtn;
	}

	public WebElement getOrganizationnametf() {
		return organizationnametf;
	}

	//create paramitrize constructor
	public OrganizationInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// create method
	public HomePage OrganizationInformation(String Orgnamedata, String groupdata) {
		// Enter Organization name
		organizationnametf.sendKeys(Orgnamedata);
		// click on group radio btn
		groupbtn.click();
		// select support group in dropdown
		wutil.handledropdown(dropdown, groupdata);
		// click on save button
		savebtn.click();
		return new HomePage(driver);  // return next landing page

	}

}
