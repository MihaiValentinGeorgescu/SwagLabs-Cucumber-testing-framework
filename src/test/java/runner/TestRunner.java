package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.messages.types.TestRunFinished;
import io.cucumber.plugin.Plugin;
import net.masterthought.cucumber.Configuration;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import io.cucumber.testng.AbstractTestNGCucumberTests;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.testng.TestNGAntTask.Mode.testng;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = {"step_Definition"},
        plugin = {"pretty", "html:reports/cucumber-reports.html"}
)

public class TestRunner extends AbstractTestNGCucumberTests{

}
