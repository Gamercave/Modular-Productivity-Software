package test.java;

import Main.Module.MPSModule;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class GetModuleIDTestSteps {
    MPSModule parent;
    MPSModule secondParent;
    MPSModule child;

    @Given("parentID = {string}")
    public void parentid(String arg0) {
        parent = new MPSModule(arg0);
    }

    @And("Parent has no Children")
    public void parentHasNoChildren() {
        assertEquals(0, parent.getNumChildren());
    }

    @When("ChildCreated")
    public void childCreated() {
        child = new MPSModule(parent);
    }


    @Then("ChildID = {string}")
    public void child(String arg0) {
        assertEquals(child.getID(), arg0);
    }


    @And("Parent has {int} child")
    public void parentHasChild(int arg0) {
        for (int i = 0; i < arg0; i++) {
            child = new MPSModule(parent);
        }
    }

    @And("Parent has between {int} and {int} Children")
    public void parentHasBetweenAndChildren(int arg0, int arg1) {
        int count = arg0;
        while (count <= arg1) {
            child = new MPSModule(parent);
            childIdNumChildren(parent.getID() + ",");
            count++;
        }
    }

    @Then("ChildID = {string} Num Children")
    public void childIdNumChildren(String arg0) {
        String childID = arg0 + parent.getNumChildren();
        assertEquals(child.getID(), childID);
    }


    @And("second parentID = {string}")
    public void secondParentID(String arg0) {
        secondParent = new MPSModule(arg0);

    }

    @When("Child Moves from one parent to another")
    public void childMovesFromOneParentToAnother() {
        child.move(parent, secondParent);
    }
}
