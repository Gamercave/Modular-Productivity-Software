package Main;

import java.util.HashMap;

public class MPSModule {
    private final String id;
    private HashMap<String, MPSModule> children;

    public MPSModule(String id){// Only for use when creating root Module
        this.id = id;
        children = new HashMap<>();
    }
    public MPSModule(MPSModule parent){
        this.id = parent.addChild(this);
        children = new HashMap<>();
    }

    private String addChild(MPSModule child) {
        String childID = getChildID();
        children.put(childID, child);
        return childID;
    }

    private String getChildID() {
        String childID = id + "," + (children.size()+1);
        return childID;
    }

    public String getID() {
        return id;
    }

}
