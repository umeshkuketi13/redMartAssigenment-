package redMart.runner.addingcart;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(plugin = { "html:target/cucumber-html-report" },
features={"classpath:featurefile/Scenario2.feature"},
glue={"classpath:stepdefination.addingcart","classpath:redMart.support"})

public class AddProductCart extends AbstractTestNGCucumberTests {

}
