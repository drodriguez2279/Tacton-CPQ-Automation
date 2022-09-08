package Steps;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import PageFactory.accountPagePF;
import PageFactory.loginMethodsPF;

//Contains all reusable methods across classes

public class Helper {

	WebDriver driver;
	loginMethodsPF login;
	accountPagePF account;
	public static Logger logger;
	
	
	//method to append today's date into opp name // static so don't have to create an instance of the class
	public static String createRandomString() {
		//use DateFormat to convert today's date into a String specifying the format I want
		SimpleDateFormat df = new SimpleDateFormat("MM/DD/YYYY");
		Calendar cal = Calendar.getInstance();
		Date today = cal.getTime();
		String strDate = df.format(today); 
		System.out.println("Today's date is: "+strDate);
		return strDate;
	} 
	
	
	public static String oppName() {
		String pattern = "MM/dd/yyyy HH:mm:ss";
		String oppN="Auto";
		// Create an instance of SimpleDateFormat used for formatting 
		// the string representation of date according to the chosen pattern
		DateFormat df = new SimpleDateFormat(pattern);
		// Get the today date using Calendar object.
		Date today = Calendar.getInstance().getTime();        
		// Using DateFormat format method we can create a string 
		// representation of a date with the defined format.
		String oppName = oppN.concat(" ").concat(df.format(today));
        return oppName;	
	}
}



