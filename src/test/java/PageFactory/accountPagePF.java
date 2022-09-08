package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class accountPagePF {

	WebDriver driver;

	@FindBy(xpath = "//span[contains(text(),'Accounts')]")
	@CacheLookup
	WebElement acctPage;

	@FindBy(xpath = "//input[@id='searchFilter-null-name_Account-list_contains']")
	WebElement txtAcctName;

	@FindBy(xpath = "//button[contains(text(),'Search')]")
	WebElement btnSearch;

	@FindBy(xpath = "//td[contains(text(),'No matching records found')]")
	WebElement lblSearch;

	@FindBy(xpath = "//tbody/tr[1]/td[2]")
	WebElement acctRecord;

	@FindBy(xpath = "//a[contains(text(),'Create Opportunity')]")
	WebElement btnCreateOp;

	@FindBy(xpath = "//h4[contains(text(),'Create new Opportunity')]")
	WebElement createOpDialog;

	@FindBy(xpath = "//body/div[5]/div[1]/div[1]/div[2]/div[2]/form[1]/div[2]/div[1]/input[1]")
	WebElement txtJobName;

	@FindBy(xpath = "//body/div[5]/div[1]/div[1]/div[2]/div[2]/form[1]/div[8]/div[1]/select[1]")
	WebElement selOrderType;

	@FindBy(xpath = "//button[contains(text(),'Create')]")
	WebElement btnCreate;

	@FindBy(xpath = "//span[contains(text(),'Overview')]")
	WebElement lblOverview;

	@FindBy(xpath = "//body/div[5]/div[1]/div[1]/div[2]/div[2]/form[1]/div[16]/div[1]/input[1]")
	WebElement txtShipToAttention;

	@FindBy(css = "#requestedByDate")
	WebElement requestedByDate;

	@FindBy(xpath = "//button[contains(text(),'Today')]")
	WebElement today;

	@FindBy(xpath = "//body/div[5]/div[1]/div[1]/div[2]/div[2]/form[1]/div[38]/div[1]/textarea[1]")
	WebElement orderComments;
	



	//constructor
	public accountPagePF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public void clickInAccountPage() throws InterruptedException {
		acctPage.click();
		Thread.sleep(3000);
	}

	public void accountSearch(String acct) {
		txtAcctName.sendKeys("24 H");
	}

	public void accountSearchClick() throws InterruptedException {
		btnSearch.click();
		Thread.sleep(2000);
	}


	public void clickOnAcctRecord() throws InterruptedException {
		acctRecord.click();
		Thread.sleep(4000);
	}

	public void clickCreateOppButton() throws InterruptedException {
		btnCreateOp.click();
		Thread.sleep(2000);
	}

	public void createOppDialogShown() throws InterruptedException {
		createOpDialog.getText().equalsIgnoreCase("Create new Opportunity");
		Thread.sleep(3000);
	}

	public void enterOppName(String oppName) throws InterruptedException {
		txtJobName.sendKeys(oppName);
		Thread.sleep(2000);
	}

	public void selectOrderType() throws InterruptedException {
		Actions ac = new Actions(driver);
		ac.click().build().perform();
		Select sel = new Select(selOrderType);
		sel.selectByVisibleText("New Installation");
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath("//div[contains(text(),'New Installation')]"));
		//		Create an object of actions class and pass reference of WebDriver as a parameter to its constructor. 
		//		Actions allows me to move the mouse (There are only 3 actions that can be accomplished with a mouse: 
		//pressing down on a button, releasing a pressed button, and moving the mouse. Selenium provides convenience methods that combine these actions in the most common ways)
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();

	}

		public void enterReqByDate() throws InterruptedException {
			requestedByDate.click();
			Thread.sleep(1000);
			today.click();
			Thread.sleep(1000);			
		}
		
		public void enterOrderComments() throws InterruptedException {
			orderComments.sendKeys("Testing Comments");
			Thread.sleep(1000);
		}

		public void saveOpportunity() throws InterruptedException {
			btnCreate.click();
			Thread.sleep(3000);
		}

		public void oppDetailsPage() {
			boolean lblOverviewShown = lblOverview.isDisplayed();
		      if (lblOverviewShown) {
		         System.out.println("Overview shown");
		      } else {
		         System.out.println("Overview not shown");
		      }
		}


}
