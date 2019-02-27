package uk.co.vwf.insuranceportal.step;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = "uk.co.vwf.insuranceportal.step",
        plugin = "html:target/selenium-reports"
)
public class TestRunner{

}
