package test.java;

import Main.Module.MPSModule;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.assertTrue;

public class StepDefMovingModules {
    private ArrayList<MPSModule> allModules;
    @Given("{int} Random modules have been created")
    public void randomModulesHaveBeenCreated(int arg0) {
        allModules = new ArrayList<MPSModule>();
        allModules.add(new MPSModule("1"));
        Random random = new Random();
        for(int i = arg0; i>0; i--)
        {
            allModules.add(new MPSModule(allModules.get(random.nextInt(0,allModules.size()))));
        }

    }

    @When("A random module is moved around randomly {int} times whist being tracked")
    public void aRandomModuleIsMovedAroundRandomlyTimesWhistBeingTracked(int arg0) {
        Random random = new Random();
       MPSModule mover = allModules.get(random.nextInt(0,allModules.size()));
       allModules.remove(mover);
       for(int i=arg0; i>0; i--){
           MPSModule visited = allModules.get(random.nextInt(0,allModules.size()));
           mover.move(visited );
           allModules.remove(visited);
       }
    }



    @Then("The error rate is {int}")
    public void theErrorRateIs(int arg0) {

    }

    @And("All modules have been visited")
    public void allModulesHaveBeenVisited() {
        assertTrue(allModules.isEmpty());
    }
}
