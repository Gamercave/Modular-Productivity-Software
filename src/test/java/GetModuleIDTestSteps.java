package test.java;

import Main.MPSModule;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

public class GetModuleIDTestSteps {
    MPSModule parent;
    MPSModule child;
    @Given("parentID = {string}")
    public void parentid(String arg0) {
        parent = new MPSModule(arg0);
    }

    @And("Parent has no Children")
    public void parentHasNoChildren() {
        assertTrue(parent.getChildCount() == 0);
    }

    @When("ChildCreated")
    public void childcreated() {
        child = new MPSModule(parent);
    }


    @Then("ChildID = {string}")
    public void child(String arg0) {
        assertTrue(child.getID() == arg0);
    }
}
