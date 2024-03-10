package Main;

import Main.Module.MPSModule;

import java.awt.*;
import java.util.ArrayList;

public class ModuleDirectory {

    private static ArrayList<MPSModule > allModules = new ArrayList<MPSModule>();

    public static void addModule(MPSModule module){
        allModules.add(module);
    }

    public static MPSModule findModule(Point point) {
        MPSModule foundModule;
        ArrayList<MPSModule> withinBounds = getModulesInBounds(point);
        return getLowestNest(withinBounds);
    }

    private static ArrayList<MPSModule> getModulesInBounds(Point point){
        ArrayList<MPSModule> withinBounds = new ArrayList<MPSModule>();
        for(MPSModule module: allModules){
            if(module.isInBounds(point)){
                withinBounds.add(module);
            }
        }
        return  withinBounds;
    }

    private static MPSModule getLowestNest(ArrayList<MPSModule> list){
        MPSModule foundModule = null;
        int lowestNest = -1;
        for(MPSModule module: list){
            if (module.getNestLevel()>lowestNest){
                foundModule = module;
                lowestNest = foundModule.getNestLevel();
            }
        }
        return foundModule;
    }
}
