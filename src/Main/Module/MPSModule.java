package Main.Module;

import java.awt.*;
import java.util.HashMap;

public class MPSModule {
    private String id;
    private final HashMap<String, MPSModule> children;

    private final ModuleUI window;
    private MPSModule parent;


    public MPSModule(String id) {// Only for use when creating root Module
        this.id = id;
        children = new HashMap<>();
        window = new ModuleUI(this);
        this.parent = parent;
    }

    public MPSModule(MPSModule parent) {

        children = new HashMap<>();
        window = new ModuleUI(this);
        this.id = parent.addModule(this);
        this.parent = parent;

    }

    public String addModule(MPSModule child) {
        String childID = getChildID();
        child.setID(childID);
        children.put(childID, child);
        window.add(child.getWidnow());
        return childID;
    }

    public ModuleUI getWidnow() {
        return window;
    }

    private String getChildID() {
        String childID = id + "," + (children.size() + 1);
        return childID;
    }

    public String getID() {
        return id;
    }

    private void setID(String NewID) {
        this.id = NewID;
    }

    public int getNumChildren() {
        return children.size();
    }

    public Point getPosition() {

        return window.getPosition();
    }

    public boolean contains(MPSModule child) {
        Boolean childInMap;
        Boolean childInWindow;
        if (children.get(child.getID()) != null) {
            childInMap = children.get(child.getID()).equals(child);
        } else {
            childInMap = false;
        }

        childInWindow = window.Contains(child.getWidnow());
        return childInWindow && childInMap;
    }


    public void move(MPSModule moveFrom, MPSModule moveToo) {
        moveFrom.removeModule(this);
        moveToo.addModule(this);
    }

    private void removeModule(MPSModule child) {
        children.remove(child.getID());
        window.remove(child.getWidnow());
    }

    public MPSModule getParent() {
        return parent;
    }
}
