package pageObjects;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.datatable.DataTable;

public class AddUserPage {
WebDriver driver;
	// page Objects

	@FindBy(xpath = "//a[@href='/web/index.php/admin/viewAdminModule']")
	WebElement adminSection;
	
	@FindBy(xpath = "//i[@class='oxd-icon bi-plus oxd-button-icon']/parent::button")
	WebElement addButton;
	
	@FindBy(xpath = "(//div[text()='-- Select --'])[1]")
	WebElement selectDropDown;
	
	@FindBy(xpath = "//div[text()='Admin']")
	WebElement adminOption;
	
	@FindBy(xpath = "(//div[text()='-- Select --'])[1]")
	WebElement selectDropDownStatus;
	
	@FindBy(xpath = "//div[text()='Enabled']")
	WebElement enabledOption;
	
	@FindBy(xpath = "(//input[@type='password'])[1]")
	WebElement passwordTextBox;
	
	@FindBy(xpath = "//input[@placeholder='Type for hints...']")
	WebElement employTextBox;
	
	@FindBy(xpath = "(//input[contains(@class,'oxd-input oxd-input')])[2]")
	WebElement userNameTextBox;
	
	@FindBy(xpath = "(//input[@type='password'])[2]")
	WebElement confirmwordTextBox;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveButton;
	
	@FindBy(xpath = "//span[contains(@class,'input-field-error-message')]")
	WebElement errrorMessage;
	
	@FindBy(xpath = "//p[text()='OrangeHRM OS 5.5']")
	WebElement copyRightText;
	
	
	
	
	
	public AddUserPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Action Methods
	
	public void clickAdminSectionAndAddButton() {
		adminSection.click();
		addButton.click();
	}
	
	public void enterUserRole() {
		Actions act=new Actions(driver);
		selectDropDown.click();
		//Thread.sleep(2000);
		act.sendKeys(Keys.ARROW_DOWN).perform();
		act.sendKeys(Keys.ENTER).perform();
		adminOption.click();
	}
	public void enterStatus() {
		Actions act=new Actions(driver);
		selectDropDownStatus.click();
		act.sendKeys(Keys.ARROW_DOWN).perform();
		act.sendKeys(Keys.ENTER).perform();
		//Thread.sleep(2000);
		enabledOption.click();
	}
	public void userEntersAllUserDetails(DataTable data) {
		List<Map<String,String>> datas = data.asMaps(String.class, String.class);
		System.out.println("aaaaaa"+datas.get(0).get("UserName"));
		System.out.println("bbbbb"+datas.get(0).get("Password"));
		System.out.println("ccc"+datas.get(0).get("ConfirmPassword"));
		System.out.println("dddd"+datas.get(0).get("EmployeeName"));
		Actions act=new Actions(driver);
		selectDropDown.click();
		//Thread.sleep(2000);
		act.sendKeys(Keys.ARROW_DOWN).perform();
		act.sendKeys(Keys.ENTER).perform();
		adminOption.click();
		selectDropDownStatus.click();
		act.sendKeys(Keys.ARROW_DOWN).perform();
		act.sendKeys(Keys.ENTER).perform();
		//Thread.sleep(2000);
		enabledOption.click();
		passwordTextBox.sendKeys(data.cell(1, 1));
		employTextBox.sendKeys(data.cell(1, 3));
		act.sendKeys(Keys.ARROW_DOWN).perform();
		act.sendKeys(Keys.ARROW_DOWN).perform();
		act.sendKeys(Keys.ENTER).perform();
		userNameTextBox.sendKeys(datas.get(0).get("UserName"));
		confirmwordTextBox.sendKeys(data.cell(1, 2));
	}
	
	public void clickSaveButton() {
		saveButton.click();
	}

}
