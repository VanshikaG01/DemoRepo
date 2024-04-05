package Test;



import org.junit.runner.RunWith;
 
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)
@CucumberOptions (features ="src/test/resources/Feature",
glue= "com.stepdef", plugin = {"html: reports/reports.html", "json: target/cucumber.json", "rerun: target/rerun.txt"})

public class TestRunner {

}
