package Steps;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

import PageFactory.accountPagePF;
import PageFactory.loginMethodsPF;
import io.cucumber.java.en.*;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class StepsDefinition extends Helper {


	//LOGIN METHODS----------------------------------------------h----------------------------------------------------!

	@Given("browser is opened")
	public void browser_is_opened() throws InterruptedException {
		//instanciating logger to be able to start tracking in the log file
		logger=Logger.getLogger("CucumberJava");
		PropertyConfigurator.configure("log4j.properties");
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/Drivers/chromedriver.exe");
		logger.info("************Launching Browser************");
		driver = new ChromeDriver();
	}

	@And("user navigates to the login page")
	public void user_navigates_to_the_login_page() throws InterruptedException {
		logger.info("************Opening Tacton CPQ Test2************");
		driver.navigate().to("https://vantageelevation-test2.tactoncpq.com");
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}

	@And("^user enters (.*) and (.*)$") //the dot star denotes that anything can be entered specified on login feature file
	public void user_enters_and(String username, String password) throws InterruptedException {
		logger.info("************Login************");
		login = new loginMethodsPF(driver); //passing driver from line #9
		login.enterUsernamePassword(username, password);
	}

	@And("close browser")
	public void closeBrowser() {
		driver.quit();
	}
	//END OF LOGIN METHOS

	// ACCOUNTS METHODS----------------------------------------------------------------------------------------------!

	@And("user clicks in Account page")
	public void user_clicks_in_account_page() throws InterruptedException {
		logger.info("************Account page shown************");
		account = new accountPagePF(driver);
		account.clickInAccountPage();
	}

	@And("^user enters (.*) in filter$")
	public void user_enters_in_filter(String acct) {
		logger.info("************Account search************");
		account.accountSearch(acct);
	}

	@And("user clicks in search")
	public void user_clicks_in_search() throws InterruptedException {
		logger.info("************Show Account in result page************");
		account.accountSearchClick();
		//will force the page to scroll all the way up (0 will make it go all the way up)
		((JavascriptExecutor) driver)
		.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
		Thread.sleep(3000);
	}

	@Given("user clicks in record")
	public void user_clicks_in_record() throws InterruptedException {
		logger.info("************Click in account from page result************");
		accountPagePF account = new accountPagePF(driver);
		account.clickOnAcctRecord();
	}

	@Then("account details page is displayed")
	public void account_details_page_is_displayed() {
		logger.info("************Show account details page************");
		Assert.assertEquals("24 HOUR ELEVATOR - Tacton CPQ", account.getPageTitle());
	}

	@Given("user clicks in Create Opportunity")
	public void user_clicks_in_create_opportunity() throws InterruptedException {
		logger.info("************Create Opportunity form shown************");
		accountPagePF account = new accountPagePF(driver); // need to make an instance of the class every time a new scenario starts off of 02account.feature
		account.clickCreateOppButton();
	}

	@Then("form is displayed")
	public void form_is_displayed() throws InterruptedException {
		logger.info("************Opportunity form displayed************");
		account.createOppDialogShown();
	}

	@And("user enters information")
	public void user_enters_information() throws InterruptedException {
		logger.info("************Opportunity details completion in form************");
		String oppName = oppName();
		account.enterOppName(oppName);
		account.selectOrderType();
		account.enterReqByDate();
		account.enterOrderComments();
	}

	@And("user clicks in Create")
	public void user_clicks_in_create() throws InterruptedException {
		logger.info("************Click in create opportunity button************");
		account.saveOpportunity();
	}

	@And("opportunity details page is displayed")
	public void opportunity_details_page_is_displayed() {
		logger.info("************Opportunity details shown************");	
		account.oppDetailsPage();
	}

}
