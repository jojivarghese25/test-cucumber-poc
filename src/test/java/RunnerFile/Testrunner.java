package RunnerFile;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		
		features="src/test/java/Featurefile/Resources.feature",
		glue= "StepDefinition",
		plugin= {"html:target/cucumber-html-report","json:target/cucumber-reports/cucumber.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter"
			},
			
			monochrome = true
		)
		
		public class Testrunner extends AbstractTestNGCucumberTests {

}
