package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AddUserPage;
import pageObjects.LoginPage;

public class Steps {
	WebDriver driver;
	LoginPage loginPage;
	AddUserPage au;
	@Given("user launch browser")
	public void user_launch_browser() {
		System.setProperty("webdriver.chrome.driver","./src/test/resources/Drivers/chromedriver.exe");
		// WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		loginPage = new LoginPage(driver);  
	}
	@When("user opens Url {string}")
	public void user_opens_url(String url) {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
	}

	@When("user enters username as {string} and password as {string}")
	public void user_enters_username_as_and_password_as(String un, String pwd) {
		loginPage = new LoginPage(driver);  
		loginPage.enterUserName(un);
		loginPage.enterPassword(pwd);
	}

	@When("click on login button")
	public void click_on_login_button() {
		loginPage.clickOnLoginButton();
	}

	@Then("dashboard should be displayed")
	public void dashboard_should_be_displayed() {
		loginPage.verifyDashboardPage();
	}

	@When("user click on logout")
	public void user_click_on_logout() {
		loginPage.clickOnLogOutButton();
	}

	@Then("main login page should be displayed")
	public void main_login_page_should_be_displayed() {
		loginPage.verifyMainLoginPage();
	}

	@When("close browser")
	public void close_browser() {
		driver.close();
	}
	
	
	  @And ("^user enters (.*) and (.*)$") 
	  public void enterUserNameandPassword(String username, String password) {
	  loginPage.enterUserName(username); 
	  loginPage.enterPassword(password); 
	  }
	  
	 @When ("^user enters credentials$") 
	 public void enterCredentials(DataTable creds) { 
		 loginPage=new LoginPage(driver); 
		 loginPage.enterCreds(creds);
	 
	}
	
	@When("user clicks on Admin section and Add button")
	public void user_clicks_on_admin_section() {
		au=new AddUserPage(driver);
		au.clickAdminSectionAndAddButton();
	}
	@When("user enters all user details")
	public void user_enters_other_user_details(DataTable data) {
		au.userEntersAllUserDetails(data);
	}

	@When("user clicks save button")
	public void user_clicks_save_button() {
	    
	}
	    
	    
	
	
	
}
