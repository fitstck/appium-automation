package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", // Lokasi file .feature
        glue = {"steps"}, // Lokasi step definitions
        plugin = {"pretty", "html:target/cucumber-reports.html"} // Plugin untuk laporan
)
public class TestRunner {
}
