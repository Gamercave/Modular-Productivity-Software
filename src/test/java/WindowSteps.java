package test.java;

import Main.MPSModule;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.awt.*;

import static org.junit.Assert.*;

public class WindowSteps {

    MPSModule root;
    MPSModule child;
    MPSModule child2;

    @Given("the user boots the application")
    public void theUserBootsTheAplication() {

    }

    @When("the root module is created")
    public void theRootModuleIsCreated() {
        root = new MPSModule("1");
    }

    @Then("the module has a window positioned at x = {int} , y = {int}")
    public void theModuleHasAWindowPositionedAtXY(int arg0, int arg1) {
        assertEquals(root.getPosition(), new Point(arg0, arg1));
    }

    @Given("A root module exists")
    public void aRootModuleExists() {
        root = new MPSModule("1");
    }

    @When("the user adds a module to the root module")
    public void theUserAddsAModuleToTheRootModule() {
        child = new MPSModule("2");
        root.addModule(child);
    }

    @Then("the root module contains both the child module and window")
    public void theRootModuleContainsBothTheChildModuleAndWindow() {
        assertTrue(root.contains(child));
    }

    @And("A second module is added to the root module")
    public void aSecondModuleIsAddedToTheRootModule() {
        child = new MPSModule(root);
    }

    @And("A third module is added to the second module")
    public void aThirdModuleIsAddedToTheSecondModule() {
        child2 = new MPSModule(child);
    }


    @When("the Third module is moved from the second module to the third module")
    public void theThirdModuleIsMovedFromTheSecondModuleToTheThirdModule() {
        child2.move(child, root);
    }


    @Then("neither the third child nor its pane exist within the second module")
    public void neitherTheThirdChildNorItsPaneExistWithinTheSecondModule() {
        assertFalse(child.contains(child2));
    }

    @And("the third module and its pane exist in the first module;")
    public void theThirdModuleAndItsPaneExistInTheFirstModule() {
        root.contains(child2);
    }
}
