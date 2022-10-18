package de.bahn.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "src/test/java/de/bahn/step_definitions",
        features = "@Target/rerun.txt"
)

public class FailedRunnerClass {
}
