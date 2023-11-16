package Core;

import java.util.HashMap;


public class Module {
    private String moduleID;

    private Module parentModule;
    private HashMap<String,Module> childModules;
    private float width;
    private float height;
    private float xPos;
    private float yPos;

    private String moduleTitle;

    public Module(String parentModuleID){
        // you must set Core.Module Title
        //this.parentModule = parentModule;
        moduleID = IDHandler.getModuleID(parentModuleID);
        //moduleID = IDHandler.getModuleID(parentModule.getModuleID());
        childModules = new HashMap<String,Module>();
        // you must set width and height for your Core.Module
        xPos = 0;
        yPos = 0;

    }
        public boolean setChildren (HashMap<String, Module> modules) {
        this.childModules = modules;
        return true;
        // Needs to be implemented to return false if failed
    }

        public boolean setWidth ( float width){
        this.width = width;
            return true;
            // Needs to be implemented to return false if failed
    }

        public boolean setHeight ( float height){
        this.height = height;
            return true;
            // Needs to be implemented to return false if failed
    }

        public boolean setxPos ( float xPos){
        this.xPos = xPos;
            return true;
            // Needs to be implemented to return false if failed
    }

        public boolean setyPos ( float yPos){
        this.yPos = yPos;
            return true;
            // Needs to be implemented to return false if failed
    }

        public String getModuleID(){
           return moduleID;
    }

        public HashMap<String, Module> getModules () {
        return childModules;
    }

        public float getWidth () {
        return width;
    }

        public float getHeight () {
        return height;
    }

        public float getxPos () {
        return xPos;
    }

        public float getyPos () {
        return yPos;
    }

public boolean clearModules(){
            childModules = new HashMap<String, Module>();
            return true;
            // needs implementing
}
public Module getChildModule(String childModuleID){
        return childModules.get(childModuleID);
}
public boolean removeChildModule(String childModuleID){
        childModules.remove(childModuleID);
        return true;
}
public boolean addChildModule(Module child){
        childModules.put(child.getModuleID(), child);
        return true;
}

}
