package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
//import io.cucumber.messages.types.DataTable;

import java.util.List;

import org.junit.Assert;


public class LoginPage {
	WebDriver driver;
	// page objects

	@FindBy(name = "username")
	WebElement userNameField;

	@FindBy(name = "password")
	WebElement passwordNameField;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginButton;

	@FindBy(xpath = "//img[@alt='company-branding']")
	WebElement companyLogo;
	
	@FindBy(xpath = "//a[@href='/web/index.php/dashboard/index']")
	WebElement dashBoardImage;
	
	@FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
	WebElement userDropDown;
	
	@FindBy(xpath = "//a[text()='Logout']")
	WebElement logoutButton;
	
	@FindBy(xpath = "//span[contains(@class,'input-field-error-message')]")
	WebElement errrorMessage;
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void enterUserName(String username) {
		userNameField.sendKeys(username);
	}
	public void enterPassword(String password) {
		passwordNameField.sendKeys(password);
	}
	public void clickOnLoginButton(){
		loginButton.click();
	}
	public void verifyDashboardPage(){
		boolean imageDashBoard = dashBoardImage.isDisplayed();
		Assert.assertEquals(true, imageDashBoard);	
	}
	public void clickOnLogOutButton(){
		userDropDown.click();
		logoutButton.click();
		
	}
	
	public void verifyMainLoginPage(){
		boolean logoImage = companyLogo.isDisplayed();
		Assert.assertEquals(true, logoImage);		
	}
	
	
public void enterCreds(DataTable creds) {
		userNameField.sendKeys(creds.cell(0, 0));
		passwordNameField.sendKeys(creds.cell(0, 1));
	}

}
