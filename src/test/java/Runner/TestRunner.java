package Runner;

import org.junit.runner.RunWith;                 
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber ;
/*This class is needed as will have many different features that will be executed 1 after the other.
 * Need to specify the RunWith cucumber class and cucumberOptions to specify the location of my features
 and glue refers to in this case the steps folder that has them but I could have specified the loginSteps
 java file instead. From now on, will run as junit this class to execute all features.*/

/*the plugin will print an xml report each time I run as junit the test, I could have also specify it as a json output
 i.e.: plugin = {"pretty", "json:target/ExecutionReport/report.json"}, or plugin = {"pretty", "html:target/reports"}*/
//monochrome true will remove special characters showing in the console after running this class. The tags smoketest will record in 
//report the smoketest suite from login.feature
//dryrun = true will not fire the browser only console
@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/TactonCPQ",
		glue= {"Steps"},
		monochrome = true,
		dryRun=false,
		plugin = {"pretty","html:target/HTMLReport", 
				"junit:target/jUnitExecutionReport/report.xml",
				"json:target/ExecutionReport/report.json", 
				"html:target/HtmlReports/report.html",},tags="@SmokeTest") 

public class TestRunner {

}
