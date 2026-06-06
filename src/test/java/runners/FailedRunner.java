package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //this file we execute only when we give second chance to our failed test cases, so that we can e
        // asily execute only the failed test cases, instead of executing all the test cases
        //path of the feature directory
        features = "@target/failed.txt",
        //path of the steps package, name must be same
        glue = "steps"
)
public class FailedRunner {

}
