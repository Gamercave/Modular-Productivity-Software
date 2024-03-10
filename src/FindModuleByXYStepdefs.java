import Main.Module.MPSModule;
import Main.ModuleDirectory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.awt.*;

import static org.junit.Assert.assertSame;


public class FindModuleByXYStepdefs {
    private MPSModule moduleToFind;
    private MPSModule foundModule;
    @Given("the x coordinate of a new module as {int} {int}")
    public void theXCoordinateOfANewModuleAs(int arg0, int arg1) {
        moduleToFind = new MPSModule("FindMe");
        ModuleDirectory.addModule(moduleToFind);
    }





    @When("the coordinates {string} are given")
    public void theCoordinatesAreGiven(String arg0) {
        String[] cords = arg0.split(",");
        Point point = new Point(Integer.parseInt(cords[0]) , Integer.parseInt(cords[1]));
        foundModule = ModuleDirectory.findModule(point);
    }

    @Then("the created module should be returned")
    public void theCreatedModuleShouldBeReturned() {
        assertSame(moduleToFind, foundModule);
    }
}
